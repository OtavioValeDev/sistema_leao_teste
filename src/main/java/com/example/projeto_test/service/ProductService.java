package com.example.projeto_test.service;

import com.example.projeto_test.model.Product;
import com.example.projeto_test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço de negócio para operações com produtos.
 *
 * Esta classe contém toda a lógica de negócio relacionada aos produtos
 * do cardápio, incluindo validações e regras específicas do domínio.
 * Atua como intermediário entre o controller e o repository.
 *
 * @author Sistema de Gestão de Restaurante
 * @version 1.0
 * @since 2025-01-01
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Cria um novo produto no cardápio.
     *
     * @param product Produto a ser criado (já validado)
     * @return Produto criado com ID gerado
     */
    public Product createProduct(@NonNull Product product) {
        return productRepository.save(product);
    }

    /**
     * Retorna todos os produtos do cardápio.
     *
     * @return Lista completa de produtos disponíveis
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Busca um produto específico pelo ID.
     *
     * @param id Identificador único do produto
     * @return Produto encontrado
     * @throws RuntimeException Se o produto não for encontrado
     */
    public Product getProductById(@NonNull Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    /**
     * Atualiza os dados de um produto existente.
     *
     * @param id ID do produto a ser atualizado
     * @param productDetails Novos dados do produto
     * @return Produto atualizado
     * @throws RuntimeException Se o produto não for encontrado
     */
    public Product updateProduct(@NonNull Long id, @NonNull Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setPriceInCents(productDetails.getPriceInCents());
        return productRepository.save(product);
    }

    /**
     * Remove um produto do cardápio.
     *
     * @param id ID do produto a ser removido
     * @throws RuntimeException Se o produto não for encontrado
     */
    public void deleteProduct(@NonNull Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
}

