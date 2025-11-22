# CRUD Spring Boot com PostgreSQL

Este projeto é uma implementação completa de CRUD (Create, Read, Update, Delete) usando Spring Boot e PostgreSQL.

## 📋 Pré-requisitos

- Java 24 ou superior
- Maven 3.6+
- PostgreSQL instalado e rodando
- Banco de dados criado (veja instruções abaixo)

## 🗄️ Configuração do Banco de Dados PostgreSQL

### 1. Instalar PostgreSQL

Se ainda não tiver o PostgreSQL instalado, baixe em: https://www.postgresql.org/download/

### 2. Criar o Banco de Dados

Abra o terminal/command prompt e execute:

```sql
-- Conecte-se ao PostgreSQL
psql -U postgres

-- Crie o banco de dados
CREATE DATABASE crud_db;

-- Verifique se foi criado
\l
```

### 3. Configurar as Credenciais

Edite o arquivo `src/main/resources/application.properties` e ajuste as seguintes propriedades conforme sua configuração:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/crud_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha_aqui
```

## 🚀 Como Executar

### 1. Clone ou navegue até a pasta do projeto

```bash
cd projeto-postgres
```

### 2. Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📡 Endpoints da API

### Criar Produto
```http
POST http://localhost:8080/products
Content-Type: application/json

{
  "name": "Notebook",
  "priceInCents": 250000
}
```

### Listar Todos os Produtos
```http
GET http://localhost:8080/products
```

### Buscar Produto por ID
```http
GET http://localhost:8080/products/1
```

### Atualizar Produto
```http
PUT http://localhost:8080/products/1
Content-Type: application/json

{
  "name": "Notebook Atualizado",
  "priceInCents": 300000
}
```

### Deletar Produto
```http
DELETE http://localhost:8080/products/1
```

## 🛠️ Tecnologias Utilizadas

- **Spring Boot 3.5.7** - Framework Java
- **Spring Data JPA** - Persistência de dados
- **PostgreSQL** - Banco de dados relacional
- **Lombok** - Redução de boilerplate
- **Bean Validation** - Validação de dados

## 📁 Estrutura do Projeto

```
projeto-postgres/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/projeto_postgres/
│   │   │       ├── controller/
│   │   │       │   └── ProductController.java
│   │   │       ├── exception/
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       ├── model/
│   │   │       │   └── Product.java
│   │   │       ├── repository/
│   │   │       │   └── ProductRepository.java
│   │   │       └── ProjetoPostgresApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## 🔍 Verificando os Dados no PostgreSQL

Para verificar os dados inseridos, você pode usar o `psql`:

```bash
psql -U postgres -d crud_db

-- Listar todos os produtos
SELECT * FROM products;
```

Ou use uma ferramenta gráfica como:
- **pgAdmin** (https://www.pgadmin.org/)
- **DBeaver** (https://dbeaver.io/)
- **DataGrip** (JetBrains)

## ⚙️ Configurações Adicionais

### Connection Pool

O projeto já está configurado com HikariCP (pool de conexões padrão do Spring Boot):

```properties
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
```

### Logs SQL

Os logs SQL estão habilitados para facilitar o debug. Para desabilitar, altere:

```properties
spring.jpa.show-sql=false
```

## 🐛 Troubleshooting

### Erro de Conexão

Se receber erro de conexão, verifique:
1. PostgreSQL está rodando
2. Credenciais estão corretas no `application.properties`
3. Banco de dados `crud_db` foi criado
4. Porta 5432 está acessível

### Erro de Permissão

Se houver erro de permissão, certifique-se de que o usuário `postgres` tem permissões para criar tabelas no banco.

## 📝 Notas

- A tabela `products` será criada automaticamente na primeira execução (devido ao `spring.jpa.hibernate.ddl-auto=update`)
- Os dados persistem no PostgreSQL (diferente do H2 que é em memória)
- Para produção, considere usar `spring.jpa.hibernate.ddl-auto=validate` ou `none`

