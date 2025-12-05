package com.example.projeto_test.controller;

import com.example.projeto_test.model.Product;
import com.example.projeto_test.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para operações com produtos do cardápio.
 *
 * Esta classe expõe endpoints REST para gerenciar o cardápio do restaurante,
 * permitindo operações CRUD completas nos produtos disponíveis para venda.
 *
 * @author Sistema de Gestão de Restaurante
 * @version 1.0
 * @since 2025-01-01
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * Construtor com injeção de dependência.
     *
     * @param productService Serviço de lógica de negócio para produtos
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Cria um novo produto no cardápio.
     *
     * Recebe os dados do produto via JSON e o salva no banco de dados
     * após validações automáticas (@Valid).
     *
     * @param product Dados do produto a ser criado
     * @return Produto criado com ID gerado e status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    /**
     * Lista todos os produtos do cardápio.
     *
     * @return Lista completa de produtos disponíveis com status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Busca um produto específico pelo ID.
     *
     * @param id Identificador único do produto
     * @return Produto encontrado ou erro 404 se não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * Atualiza os dados de um produto existente.
     *
     * Recebe os novos dados do produto e atualiza o registro
     * correspondente ao ID informado.
     *
     * @param id ID do produto a ser atualizado
     * @param productDetails Novos dados do produto
     * @return Produto atualizado com status 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Remove um produto do cardápio.
     *
     * @param id ID do produto a ser removido
     * @return Status 204 (No Content) se removido com sucesso
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

