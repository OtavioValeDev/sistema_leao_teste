// Declaração do pacote - organiza a classe no modelo de domínio
package com.example.projeto_test.model;

// Importa anotações JPA (Jakarta Persistence API) para mapeamento objeto-relacional
// @Entity: Marca a classe como uma entidade JPA
// @Table: Especifica o nome da tabela no banco de dados
// @Id: Marca o campo como chave primária
// @GeneratedValue: Define como a chave primária será gerada
// @Column: Define propriedades da coluna no banco de dados
import jakarta.persistence.*;

// Importa anotações de validação do Bean Validation
// @NotBlank: Valida que o campo não seja nulo, vazio ou apenas espaços
// @Positive: Valida que o número seja positivo (maior que zero)
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

// Importa anotações do Lombok para reduzir código boilerplate
// @Getter: Gera automaticamente métodos getters para todos os campos
// @Setter: Gera automaticamente métodos setters para todos os campos
// @AllArgsConstructor: Gera um construtor com todos os campos
// @NoArgsConstructor: Gera um construtor sem argumentos (necessário para JPA)
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//JPA (Java Persistence API) é uma especificação da plataforma Java que define padrões para o mapeamento objeto-relacional (ORM), permitindo que desenvolvedores usem objetos Java para interagir com bancos de dados relacionais de forma simplificada. O JPA em si é um conjunto de regras e anotações, não um código executável; para funcionar, ele precisa de uma implementação, como o Hibernate ou o EclipseLink. Ele abstrai a complexidade do SQL, permitindo o uso de consultas em linguagem de consulta de objeto (JPQL) e o gerenciamento de relacionamentos e transações.
//Funcionalidades e como funciona
//Mapeamento Objeto-Relacional (ORM): O JPA facilita a conversão de classes Java (POJOs) em tabelas de banco de dados e de objetos Java em linhas de tabelas, e vice-versa.
//Anotações: O desenvolvedor utiliza anotações (como @Entity, @Table, @Id) para mapear os objetos Java para as tabelas do banco de dados, simplificando o desenvolvimento.
//Abstração: O JPA abstrai os detalhes específicos do banco de dados e do SQL, permitindo que os desenvolvedores foquem na lógica do negócio em vez de gerenciar a comunicação direta com o banco de dados.
//Implementação: O JPA necessita de uma implementação (um framework ORM) para executar as tarefas, como o Hibernate ou o EclipseLink. O framework implementa os padrões definidos pela especificação JPA.
//EntityManager: A interface EntityManager é responsável por gerenciar as entidades persistidas e interagir com o banco de dados.
//JPQL: Oferece suporte a consultas em linguagem de consulta de objeto (Java Persistence Query Language), que funciona de forma semelhante ao SQL, mas opera sobre objetos e entidades Java em vez de tabelas e colunas.

/**
 * Classe de Entidade - Representa a tabela "products" no banco de dados
 * 
 * Esta classe é mapeada para uma tabela no banco de dados usando JPA (Jakarta Persistence API).
 * O JPA é um framework que permite trabalhar com bancos de dados relacionais usando objetos Java,
 * sem precisar escrever SQL manualmente na maioria dos casos.
 * 
 * O Spring Data JPA usa esta entidade para:
 * - Criar automaticamente a tabela no banco (se ddl-auto=update)
 * - Converter objetos Java em registros SQL
 * - Converter registros SQL em objetos Java
 */
@Entity // Indica ao JPA que esta classe é uma entidade (será mapeada para uma tabela)
@Table(name = "products") // Especifica o nome da tabela no banco de dados (opcional, usa o nome da classe se omitido)
@Getter // Lombok: Gera getters automaticamente (ex: getId(), getName(), getPriceInCents())
@Setter // Lombok: Gera setters automaticamente (ex: setId(), setName(), setPriceInCents())
@AllArgsConstructor // Lombok: Gera construtor com todos os campos (ex: new Product(1L, "Notebook", 250000))
@NoArgsConstructor // Lombok: Gera construtor sem argumentos (necessário para o JPA criar instâncias)
public class Product {

    /**
     * Campo ID - Chave primária da tabela
     * 
     * O @Id marca este campo como chave primária.
     * O @GeneratedValue com strategy IDENTITY significa que o banco de dados
     * gerará automaticamente o valor (auto-incremento no MySQL/PostgreSQL, 
     * ou IDENTITY no H2).
     * 
     * GenerationType.IDENTITY: O banco de dados gera o ID automaticamente
     * (equivalente a AUTO_INCREMENT no MySQL ou SERIAL no PostgreSQL)
     */
    @Id // Marca este campo como chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o ID será gerado automaticamente pelo banco
    private Long id; // Tipo Long para suportar IDs grandes

    /**
     * Campo Name - Nome do produto
     * 
     * @NotBlank: Validação que garante que o campo não seja:
     * - null
     * - String vazia ("")
     * - String com apenas espaços ("   ")
     * 
     * @Column: Define propriedades da coluna no banco:
     * - nullable = false: A coluna não aceita valores NULL
     * - length = 100: Define o tamanho máximo da coluna VARCHAR(100)
     * 
     * Quando uma requisição POST/PUT chega com dados inválidos, o Spring
     * automaticamente retorna um erro 400 (Bad Request) com a mensagem especificada.
     */
    @NotBlank(message = "O nome do produto não pode estar vazio") // Validação: campo obrigatório e não pode ser vazio
    @Column(nullable = false, length = 100) // Define que a coluna é obrigatória e tem no máximo 100 caracteres
    private String name; // Nome do produto

    /**
     * Campo PriceInCents - Preço do produto em centavos
     * 
     * Armazenamos o preço em centavos (Integer) ao invés de usar BigDecimal
     * para evitar problemas de arredondamento com números decimais.
     * Exemplo: R$ 2.500,00 = 250000 centavos
     * 
     * @Positive: Valida que o valor seja maior que zero
     * @Column(nullable = false): Garante que o preço seja obrigatório
     * 
     * O Spring Validation executa essas validações automaticamente quando
     * o método do controller recebe um objeto com @Valid.
     */
    @Positive(message = "O preço deve ser maior que zero") // Validação: número deve ser positivo (> 0)
    @Column(nullable = false) // Define que a coluna é obrigatória (não aceita NULL)
    private Integer priceInCents; // Preço em centavos para evitar problemas de arredondamento
}

