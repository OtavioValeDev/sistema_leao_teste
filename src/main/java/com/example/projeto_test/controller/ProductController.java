package com.example.projeto_test.controller;

import com.example.projeto_test.model.Product;
import com.example.projeto_test.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

import java.util.List;

/**
 * Controller REST para operações com produtos do cardápio.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println("POST /products chamado com: " + product.getName());
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .body(savedProduct);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts() {
        System.out.println("GET /products chamado");
        List<Product> products = productService.getAllProducts();
        System.out.println("Produtos encontrados: " + products.size());
        for (Product p : products) {
            System.out.println("Produto: " + p.getId() + " - " + p.getName() + " - " + p.getPriceInCents());
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .header("Content-Type", "application/json")
                .body(products);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable @NonNull Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable @NonNull Long id, @RequestBody @NonNull Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable @NonNull Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }

    /**
     * Endpoint de debug para verificar se o cliente.html consegue carregar produtos
     * Retorna dados JSON simples para debug
     */
    @GetMapping("/debug")
    public ResponseEntity<String> debugProdutos() {
        List<Product> products = productService.getAllProducts();

        StringBuilder debug = new StringBuilder();
        debug.append("{\n");
        debug.append("  \"status\": \"OK\",\n");
        debug.append("  \"timestamp\": \"").append(java.time.Instant.now()).append("\",\n");
        debug.append("  \"products_count\": ").append(products.size()).append(",\n");
        debug.append("  \"products\": [\n");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            debug.append("    {\n");
            debug.append("      \"id\": ").append(product.getId()).append(",\n");
            debug.append("      \"name\": \"").append(product.getName()).append("\",\n");
            debug.append("      \"priceInCents\": ").append(product.getPriceInCents()).append("\n");
            debug.append("    }");
            if (i < products.size() - 1) {
                debug.append(",");
            }
            debug.append("\n");
        }

        debug.append("  ],\n");
        debug.append("  \"message\": \"Se você vê isso, a API está funcionando!\"\n");
        debug.append("}");

        return ResponseEntity.ok()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("Access-Control-Allow-Origin", "*")
                .body(debug.toString());
    }

    /**
     * Endpoint de teste CORS - simula exatamente o que o cliente.html faz
     */
    @GetMapping("/cors-test")
    public ResponseEntity<String> corsTest() {
        List<Product> products = productService.getAllProducts();

        // Simula exatamente a resposta que o cliente.html espera
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            json.append("{\"id\":").append(product.getId())
                .append(",\"name\":\"").append(product.getName())
                .append("\",\"priceInCents\":").append(product.getPriceInCents())
                .append("}");
            if (i < products.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");

        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .body(json.toString());
    }

    /**
     * Lista de notificações para atendimento preferencial
     */
    private static final List<Map<String, Object>> preferentialNotifications = new ArrayList<>();

    /**
     * Endpoint para solicitar atendimento preferencial (sem observações)
     */
    @PostMapping("/notificacao-preferencial")
    public ResponseEntity<Map<String, Object>> solicitarAtendimentoPreferencial() {
        Map<String, Object> notification = new HashMap<>();
        notification.put("id", System.currentTimeMillis());
        notification.put("timestamp", java.time.Instant.now());
        notification.put("type", "PREFERENTIAL_SERVICE");
        notification.put("message", "Cliente solicitou atendimento preferencial");
        notification.put("status", "PENDING");

        preferentialNotifications.add(notification);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Solicitação de atendimento preferencial enviada com sucesso!");
        response.put("notificationId", notification.get("id"));

        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .body(response);
    }

    /**
     * Endpoint para o funcionário ver notificações pendentes
     */
    @GetMapping("/notificacoes-pendentes")
    public ResponseEntity<List<Map<String, Object>>> getNotificacoesPendentes() {
        List<Map<String, Object>> pendingNotifications = preferentialNotifications.stream()
                .filter(notification -> "PENDING".equals(notification.get("status")))
                .collect(java.util.stream.Collectors.toList());

        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .body(pendingNotifications);
    }

    /**
     * Endpoint para marcar notificação como atendida
     */
    @PostMapping("/notificacao/{id}/atender")
    public ResponseEntity<Map<String, Object>> atenderNotificacao(@PathVariable String id) {
        for (Map<String, Object> notification : preferentialNotifications) {
            if (id.equals(String.valueOf(notification.get("id")))) {
                notification.put("status", "ATTENDED");
                notification.put("attendedAt", java.time.Instant.now());

                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Notificação marcada como atendida");

                return ResponseEntity.ok()
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                        .header("Access-Control-Allow-Headers", "*")
                        .body(response);
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "Notificação não encontrada");

        return ResponseEntity.notFound().build();
    }
}

