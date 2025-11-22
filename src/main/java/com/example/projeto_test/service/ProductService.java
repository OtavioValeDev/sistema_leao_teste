// Declaração do pacote - organiza a classe no pacote de serviços
package com.example.projeto_test.service;

// Importa a entidade Product
import com.example.projeto_test.model.Product;

// Importa o repositório para acessar os dados
import com.example.projeto_test.repository.ProductRepository;

// Importa Optional para trabalhar com valores que podem ser nulos
import java.util.List;
import java.util.Optional;

// Importa anotações do Spring
// @Service: Marca a classe como um serviço Spring (componente de lógica de negócio)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Camada de Serviço - Lógica de Negócio
 * 
 * A camada Service é uma das mais importantes na arquitetura de uma aplicação Spring Boot.
 * Ela fica entre o Controller (camada de apresentação) e o Repository (camada de dados).
 * 
 * POR QUE A CAMADA SERVICE É ESSENCIAL?
 * 
 * 1. SEPARAÇÃO DE RESPONSABILIDADES:
 *    - Controller: Apenas recebe requisições HTTP e retorna respostas
 *    - Service: Contém toda a lógica de negócio (validações complexas, regras, cálculos)
 *    - Repository: Apenas acessa dados (CRUD básico)
 * 
 * 2. REUTILIZAÇÃO DE CÓDIGO:
 *    - A mesma lógica de negócio pode ser usada por múltiplos controllers
 *    - Pode ser chamada por outros serviços
 *    - Facilita a criação de APIs diferentes (REST, GraphQL, etc.) que usam a mesma lógica
 * 
 * 3. FACILITA TESTES:
 *    - Pode testar a lógica de negócio sem precisar do controller
 *    - Pode mockar o repository facilmente
 *    - Testes unitários mais simples e rápidos
 * 
 * 4. MANUTENIBILIDADE:
 *    - Código organizado e fácil de encontrar
 *    - Mudanças na lógica de negócio não afetam o controller
 *    - Facilita refatoração e evolução do código
 * 
 * 5. PRINCÍPIOS SOLID:
 *    - Single Responsibility: Cada classe tem uma responsabilidade única
 *    - Dependency Inversion: Controller depende de abstrações (Service), não de implementações
 * 
 * @Service: Marca esta classe como um componente Spring do tipo Service
 * O Spring automaticamente:
 * - Cria uma instância desta classe (singleton por padrão)
 * - Permite injeção via @Autowired em outras classes
 * - Gerencia o ciclo de vida do objeto
 */
@Service // Marca como componente Spring do tipo Service (lógica de negócio)
public class ProductService {

    /**
     * Injeção de Dependência do Repositório
     * 
     * O Service usa o Repository para acessar os dados.
     * O Controller NÃO deve acessar o Repository diretamente!
     * 
     * FLUXO CORRETO:
     * Controller → Service → Repository → Banco de Dados
     * 
     * FLUXO INCORRETO (evite):
     * Controller → Repository → Banco de Dados
     * 
     * Por que o Controller não deve acessar o Repository?
     * - Viola a separação de responsabilidades
     * - Lógica de negócio fica espalhada
     * - Dificulta testes e manutenção
     */
    @Autowired // Injeção de dependência: Spring injeta automaticamente o ProductRepository
    private ProductRepository productRepository; // Repositório para acessar dados do banco

    /**
     * CREATE - Criar um novo produto
     * 
     * Este método encapsula a lógica de criação de um produto.
     * Aqui você pode adicionar:
     * - Validações de negócio complexas
     * - Cálculos (ex: aplicar desconto, calcular impostos)
     * - Transformações de dados
     * - Logs de auditoria
     * - Notificações
     * 
     * @param product O produto a ser criado (já validado pelo Bean Validation)
     * @return O produto criado com ID gerado
     * 
     * EXEMPLO DE LÓGICA DE NEGÓCIO QUE PODERIA SER ADICIONADA:
     * - Verificar se já existe produto com mesmo nome
     * - Aplicar regras de desconto baseado em categoria
     * - Enviar email de notificação
     * - Registrar log de auditoria
     */
    public Product createProduct(Product product) {
        // Aqui você pode adicionar lógica de negócio antes de salvar
        // Exemplo: validar se o nome já existe, aplicar descontos, etc.
        
        // Salva o produto no banco de dados
        // O método save() do JPA:
        // - Se o ID for null: cria um novo registro (INSERT)
        // - Se o ID existir: atualiza o registro existente (UPDATE)
        Product savedProduct = productRepository.save(product);
        
        // Aqui você pode adicionar lógica após salvar
        // Exemplo: enviar notificação, atualizar cache, etc.
        
        return savedProduct;
    }

    /**
     * READ - Listar todos os produtos
     * 
     * Este método pode ser estendido para:
     * - Aplicar filtros
     * - Ordenação customizada
     * - Paginação
     * - Cache
     * 
     * @return Lista de todos os produtos
     * 
     * EXEMPLO DE MELHORIAS FUTURAS:
     * - Adicionar paginação: findAll(int page, int size)
     * - Adicionar filtros: findByCategory(String category)
     * - Adicionar ordenação: findAllOrderByPrice()
     * - Implementar cache: @Cacheable("products")
     */
    public List<Product> getAllProducts() {
        // Busca todos os produtos no banco de dados
        // findAll() retorna uma List com todos os registros da tabela
        return productRepository.findAll();
    }

    /**
     * READ - Buscar um produto por ID
     * 
     * Este método encapsula a lógica de busca e tratamento de erro.
     * O Service é responsável por lançar exceções de negócio.
     * 
     * @param id O ID do produto a ser buscado
     * @return O produto encontrado
     * @throws RuntimeException Se o produto não for encontrado
     * 
     * POR QUE LANÇAR EXCEÇÃO AQUI E NÃO NO CONTROLLER?
     * - A lógica de negócio fica centralizada no Service
     * - O Controller apenas trata a exceção e retorna HTTP apropriado
     * - Facilita reutilização (outros controllers podem usar o mesmo service)
     */
    public Product getProductById(Long id) {
        // Busca o produto pelo ID
        // findById() retorna Optional<Product>:
        // - Se encontrar: Optional<Product> com o produto
        // - Se não encontrar: Optional.empty()
        Optional<Product> productOptional = productRepository.findById(id);
        
        // Se não encontrar, lança exceção
        // O GlobalExceptionHandler captura e retorna HTTP 404
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }
        
        // Retorna o produto encontrado
        return productOptional.get();
    }

    /**
     * UPDATE - Atualizar um produto existente
     * 
     * Este método encapsula a lógica de atualização.
     * Aqui você pode adicionar:
     * - Validações antes de atualizar
     * - Histórico de alterações
     * - Notificações de mudança
     * 
     * @param id O ID do produto a ser atualizado
     * @param productDetails Os novos dados do produto (já validados pelo Bean Validation)
     * @return O produto atualizado
     * @throws RuntimeException Se o produto não for encontrado
     * 
     * EXEMPLO DE LÓGICA DE NEGÓCIO:
     * - Verificar se o usuário tem permissão para atualizar
     * - Salvar histórico de alterações
     * - Validar se a mudança é permitida (ex: não pode alterar preço se já foi vendido)
     */
    public Product updateProduct(Long id, Product productDetails) {
        // Busca o produto existente no banco
        // Se não encontrar, lança exceção (tratada pelo GlobalExceptionHandler)
        Product product = getProductById(id); // Reutiliza o método getProductById
        
        // Atualiza os campos do produto existente com os novos valores
        // Não atualizamos o ID (chave primária não deve ser alterada)
        product.setName(productDetails.getName()); // Atualiza o nome
        product.setPriceInCents(productDetails.getPriceInCents()); // Atualiza o preço
        
        // Aqui você pode adicionar lógica antes de salvar
        // Exemplo: validar se a mudança é permitida, registrar histórico, etc.
        
        // Salva o produto atualizado
        // O JPA detecta que o ID já existe e faz UPDATE ao invés de INSERT
        Product updatedProduct = productRepository.save(product);
        
        // Aqui você pode adicionar lógica após salvar
        // Exemplo: enviar notificação, atualizar cache, etc.
        
        return updatedProduct;
    }

    /**
     * DELETE - Deletar um produto
     * 
     * Este método encapsula a lógica de exclusão.
     * Aqui você pode adicionar:
     * - Validações antes de deletar (ex: verificar se tem vendas associadas)
     * - Soft delete (marcar como deletado ao invés de remover)
     * - Logs de auditoria
     * 
     * @param id O ID do produto a ser deletado
     * @throws RuntimeException Se o produto não for encontrado
     * 
     * EXEMPLO DE LÓGICA DE NEGÓCIO:
     * - Verificar se o produto pode ser deletado (ex: não tem vendas)
     * - Soft delete: marcar como deletado ao invés de remover do banco
     * - Registrar quem deletou e quando
     */
    public void deleteProduct(Long id) {
        // Verifica se o produto existe antes de tentar deletar
        // Se não existir, lança exceção (retorna HTTP 404)
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        
        // Aqui você pode adicionar validações de negócio
        // Exemplo: verificar se o produto pode ser deletado
        // Product product = getProductById(id);
        // if (product.hasSales()) {
        //     throw new BusinessException("Não é possível deletar produto com vendas");
        // }
        
        // Deleta o produto do banco de dados
        // deleteById() remove o registro da tabela
        productRepository.deleteById(id);
        
        // Aqui você pode adicionar lógica após deletar
        // Exemplo: registrar log de auditoria, enviar notificação, etc.
    }
}

