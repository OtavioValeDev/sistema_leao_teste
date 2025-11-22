# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.7/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.7/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.7/reference/web/servlet.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.7/reference/using/devtools.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.7/reference/data/sql.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

---

# CRUD com Spring Boot - Documentação

## Estrutura criada

### 1. Dependências adicionadas (`pom.xml`)

- **Spring Boot Starter Validation** (validações)
- **Lombok** (redução de boilerplate)

### 2. Configuração do banco (`application.properties`)

- H2 Database configurado em memória
- Console H2 habilitado em `/h2-console`
- JPA configurado com logs SQL

### 3. Entidade Product (`model/Product.java`)

- Anotações JPA (`@Entity`, `@Id`, `@GeneratedValue`)
- Validações (`@NotBlank`, `@Positive`)
- Lombok para getters/setters

### 4. Repositório (`repository/ProductRepository.java`)

- Interface que estende `JpaRepository`
- Métodos CRUD automáticos

### 5. Controller (`controller/ProductController.java`)

Endpoints REST:

- `POST /products` - Criar produto
- `GET /products` - Listar todos
- `GET /products/{id}` - Buscar por ID
- `PUT /products/{id}` - Atualizar produto
- `DELETE /products/{id}` - Deletar produto

### 6. Tratamento de exceções (`exception/GlobalExceptionHandler.java`)

- Handler global para exceções
- Validações com mensagens de erro

## Como testar

### 1. Execute a aplicação:

```bash
mvn spring-boot:run
```

### 2. Acesse o console H2: `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User:** `sa`
- **Password:** (vazio)

### 3. Teste os endpoints:

#### Criar: `POST http://localhost:8080/products`

```json
{
  "name": "Notebook",
  "priceInCents": 250000
}
```

#### Listar: `GET http://localhost:8080/products`

#### Buscar: `GET http://localhost:8080/products/1`

#### Atualizar: `PUT http://localhost:8080/products/1`

```json
{
  "name": "Notebook Atualizado",
  "priceInCents": 300000
}
```

#### Deletar: `DELETE http://localhost:8080/products/1`
