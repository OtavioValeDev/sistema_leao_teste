# 🎓 Guia Completo: Criando CRUD com Spring Boot - Material para Aula

## 📋 Índice

1. [Introdução](#introdução)
2. [Pré-requisitos](#pré-requisitos)
3. [Configuração Inicial do Projeto](#configuração-inicial-do-projeto)
4. [Ordem de Desenvolvimento](#ordem-de-desenvolvimento)
5. [Passo a Passo Detalhado](#passo-a-passo-detalhado)
6. [Testando a Aplicação](#testando-a-aplicação)
7. [Exercícios Práticos](#exercícios-práticos)
8. [Boas Práticas e Dicas](#boas-práticas-e-dicas)
9. [Troubleshooting](#troubleshooting)

---

## 🎯 Introdução

### O que vamos aprender?

Neste guia, você vai aprender a criar uma **API REST completa** com **Spring Boot** que realiza operações **CRUD** (Create, Read, Update, Delete) em um banco de dados.

### O que é CRUD?

**CRUD** é um acrônimo que representa as quatro operações básicas de um sistema:

- **C**reate (Criar) - Adicionar novos registros
- **R**ead (Ler) - Consultar registros existentes
- **U**pdate (Atualizar) - Modificar registros existentes
- **D**elete (Deletar) - Remover registros

### Por que Spring Boot?

- ✅ **Produtividade**: Desenvolvimento rápido e eficiente
- ✅ **Convenções**: Menos configuração, mais código
- ✅ **Ecosystem**: Muitas bibliotecas e ferramentas integradas
- ✅ **Mercado**: Amplamente usado em empresas

### O que vamos construir?

Uma API para gerenciar produtos de uma loja com os seguintes endpoints:

- `POST /products` - Criar um novo produto
- `GET /products` - Listar todos os produtos
- `GET /products/{id}` - Buscar um produto específico
- `PUT /products/{id}` - Atualizar um produto
- `DELETE /products/{id}` - Deletar um produto

---

## 📚 Pré-requisitos

### Conhecimentos necessários:

- ✅ Conhecimento básico de **Java**
- ✅ Conceitos básicos de **orientação a objetos**
- ✅ Noções básicas de **HTTP** (GET, POST, PUT, DELETE)
- ✅ Conceitos básicos de **banco de dados**

### Ferramentas necessárias:

1. **Java JDK 21 ou 17** ✅ **OBRIGATÓRIO**
   - Verificar instalação: `java -version`
   - **Recomendado**: Java 21 (LTS mais recente)
   - Download: [OpenJDK 21](https://adoptium.net/temurin/releases/?version=21) ou [OpenJDK 17](https://adoptium.net/temurin/releases/?version=17)

2. **Maven** (gerenciador de dependências) ⚠️ **NÃO É OBRIGATÓRIO!**
   - O projeto Spring Boot vem com **Maven Wrapper** (`mvnw` ou `mvnw.cmd`)
   - O wrapper permite usar Maven **sem precisar instalar**
   - **Use sempre o wrapper**: `.\mvnw.cmd` (Windows) ou `./mvnw` (Linux/Mac)
   - **Se quiser instalar mesmo assim** (opcional):
     - Verificar instalação: `mvn -version`
     - Download: [Maven](https://maven.apache.org/download.cgi)
   - **💡 Dica**: Se você ver erro `'mvn' is not recognized`, use `mvnw.cmd` ao invés de `mvn`!

3. **IDE** (Ambiente de Desenvolvimento Integrado)
   - **IntelliJ IDEA** (recomendado) - [Download](https://www.jetbrains.com/idea/)
   - **Eclipse** - [Download](https://www.eclipse.org/downloads/)
   - **VS Code** com extensões Java - [Download](https://code.visualstudio.com/)

4. **Postman** ou **Insomnia** (para testar a API)
   - Postman: [Download](https://www.postman.com/downloads/)
   - Insomnia: [Download](https://insomnia.rest/download)

---

## 🚀 Configuração Inicial do Projeto

### Passo 1: Criar o Projeto com Spring Initializr

Como estamos usando **IntelliJ IDEA**, temos duas opções excelentes para criar o projeto. Recomendamos começar pela **Opção A (IntelliJ)** por ser mais integrada, mas a **Opção B (Site)** também funciona perfeitamente!

#### ⭐ Opção A: Via IntelliJ IDEA (Recomendado - Mais Integrado)

Esta é a forma mais simples e recomendada para começar!

##### Passo 1.1: Acessar o Spring Initializr

1. Abra seu navegador
2. Acesse: **https://start.spring.io/**
3. Você verá uma interface com campos para configurar o projeto

**📸 Como a Interface se Parece:**

A interface do Spring Initializr está dividida em duas partes principais:

**PARTE SUPERIOR** (Configurações do Projeto):
```
┌─────────────────────────────────────────────────────────┐
│  Project: [Maven ▼]  Language: [Java ▼]                │
│  Spring Boot: [3.5.8 ▼]                                │
│                                                         │
│  Project Metadata:                                      │
│  Group:      [com.example        ]                     │
│  Artifact:   [crud-spring-boot    ]                     │
│  Name:       [crud-spring-boot    ]                     │
│  Description:[CRUD Spring Boot...]                     │
│  Package:    [com.example.crud   ]                     │
│  Packaging:  [Jar ▼]  Java: [21 ▼]                     │
└─────────────────────────────────────────────────────────┘
```

**PARTE INFERIOR** (Dependências):
```
┌─────────────────────────────────────────────────────────┐
│  Dependencies: [Add Dependencies...]                  │
│                                                         │
│  Selected Dependencies:                                │
│  [Spring Web] [Spring Data JPA] [H2 Database] ...     │
│                                                         │
│                    [GENERATE] ← Botão verde            │
└─────────────────────────────────────────────────────────┘
```

##### Passo 1.2: Configurar o Projeto (Parte Superior)

Na parte superior da página, configure:

**Project** (Tipo de Build):
- Selecione: **Maven** (recomendado para iniciantes)
- Alternativa: Gradle (se você já conhece)

**Language** (Linguagem):
- Selecione: **Java**

**Spring Boot** (Versão):
- Selecione: **3.5.8** ou **4.0.0** (versão mais recente estável)
- Versões mais antigas também funcionam (3.4.x, 3.3.x)

**Project Metadata** (Metadados do Projeto):
- **Group**: `com.example`
  - *Este é o grupo/organização do projeto (padrão da indústria)*
- **Artifact**: `crud-spring-boot`
  - *Este será o nome do arquivo JAR gerado*
- **Name**: `crud-spring-boot`
  - *Nome do projeto (geralmente igual ao Artifact)*
- **Description**: `CRUD Spring Boot Application`
  - *Descrição opcional do projeto*
- **Package name**: `com.example.crud`
  - *Nome do pacote base (geralmente Group + Artifact)*
- **Packaging**: **Jar** (recomendado)
  - *Jar: aplicação standalone | War: para deploy em servidor*
- **Java**: **21** (recomendado LTS), **17** (LTS), ou **24** (mais recente)
  - *Versão do Java (21 e 17 são LTS - Long Term Support)*
  - ⚠️ **IMPORTANTE**: Java 24 é muito novo - pode precisar de configuração adicional no `pom.xml` (veja Troubleshooting)

##### Passo 1.3: Adicionar Dependências (Parte Inferior)

Na parte inferior da página, você verá um campo "Dependencies". Clique nele ou no botão **"Add Dependencies"**.

**IMPORTANTE**: Você precisa adicionar as seguintes dependências:

1. **Spring Web**
   - Categoria: **Web**
   - Nome: **Spring Web**
   - Descrição: "Build web, including RESTful, applications using Spring MVC"
   - *Essencial para criar APIs REST*

2. **Spring Data JPA**
   - Categoria: **SQL**
   - Nome: **Spring Data JPA**
   - Descrição: "Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate"
   - *Essencial para acesso a dados com JPA*

3. **H2 Database**
   - Categoria: **SQL**
   - Nome: **H2 Database**
   - Descrição: "Provides a fast in-memory database that supports JDBC API and R2DBC access"
   - *Banco de dados em memória para desenvolvimento*

4. **Validation**
   - Categoria: **Core**
   - Nome: **Validation**
   - Descrição: "Bean Validation with Hibernate validator"
   - *Para validações de dados (@NotBlank, @Positive, etc.)*

5. **Lombok**
   - Categoria: **Developer Tools**
   - Nome: **Lombok**
   - Descrição: "Java annotation library which helps to reduce boilerplate code"
   - *Para reduzir código repetitivo (getters, setters, construtores)*

**Como adicionar cada dependência:**
- Digite o nome da dependência no campo de busca
- Ou navegue pelas categorias (Web, SQL, Developer Tools, etc.)
- Clique na dependência para adicioná-la
- Ela aparecerá na lista de dependências selecionadas

**Dica**: Você pode ver todas as dependências disponíveis em: [https://start.spring.io/dependencies](https://start.spring.io/dependencies)

##### Passo 1.4: Gerar e Baixar o Projeto

1. Após configurar tudo, clique no botão **"Generate"** (botão verde no final da página)
2. O Spring Initializr irá:
   - Gerar o projeto com todas as configurações
   - Criar um arquivo ZIP com a estrutura completa
   - Fazer o download automaticamente

##### Passo 1.5: Extrair e Abrir o Projeto

1. **Localize o arquivo ZIP baixado** (geralmente na pasta Downloads)
   - Nome do arquivo: `crud-spring-boot.zip` (ou similar)

2. **Extraia o arquivo ZIP**:
   - Clique com botão direito → "Extrair" ou "Extract"
   - Ou use um programa como WinRAR, 7-Zip, etc.

3. **Abra o projeto na sua IDE**:

   **IntelliJ IDEA:**
   - File → Open
   - Selecione a pasta extraída (não o arquivo ZIP)
   - Clique em "OK"
   - Aguarde o Maven baixar as dependências (pode levar alguns minutos na primeira vez)

   **Eclipse:**
   - File → Import
   - Maven → Existing Maven Projects
   - Selecione a pasta do projeto
   - Clique em "Finish"

   **VS Code:**
   - File → Open Folder
   - Selecione a pasta extraída
   - Instale extensões Java se necessário

##### Passo 1.6: Verificar a Estrutura do Projeto

Após abrir na IDE, você deve ver a seguinte estrutura:

```
crud-spring-boot/
├── .mvn/                    # Configurações do Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/crud/
│   │   │       └── CrudSpringBootApplication.java  # Classe principal
│   │   └── resources/
│   │       ├── application.properties                # Configurações
│   │       └── static/                             # Arquivos estáticos
│   └── test/                                        # Testes
├── .gitignore                                       # Arquivos ignorados pelo Git
├── mvnw                                             # Maven Wrapper (Unix/Mac)
├── mvnw.cmd                                         # Maven Wrapper (Windows)
└── pom.xml                                          # Configuração Maven
```

**✅ Se você vê essa estrutura, o projeto foi criado com sucesso!**

##### Dica: URL Direta para o Projeto Configurado

Você também pode usar esta URL pré-configurada para gerar o projeto diretamente:

```
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.5.8&packaging=jar&jvmVersion=21&groupId=com.example&artifactId=crud-spring-boot&name=crud-spring-boot&description=CRUD%20Spring%20Boot%20Application&packageName=com.example.crud&dependencies=web,data-jpa,h2,validation,lombok
```

Basta copiar e colar no navegador, e o projeto já virá configurado!

##### Passo 1.1: Abrir o IntelliJ IDEA

1. **Inicie o IntelliJ IDEA**
   - Se for a primeira vez, você verá a tela de boas-vindas
   - Se já tiver projetos abertos, vá em: **File → New → Project**

##### Passo 1.2: Criar Novo Projeto

**Na Tela de Boas-Vindas:**
- Clique em **"New Project"** (botão grande no centro)

**Ou se já estiver com um projeto aberto:**
- **File → New → Project**
- Ou use o atalho: `Ctrl+Alt+Shift+S` (Windows/Linux) ou `Cmd+Alt+Shift+S` (Mac)

##### Passo 1.3: Selecionar Spring Initializr

1. Na janela "New Project", você verá várias opções no lado esquerdo
2. **Procure e selecione**: **Spring Initializr**
   - Se não aparecer, verifique se você tem o plugin Spring Boot instalado
   - File → Settings → Plugins → Procure "Spring Boot" e instale se necessário
3. **Verifique as configurações**:
   - **Project SDK**: Deve mostrar sua versão do Java (21 ou 17)
     - Se não aparecer, clique em "New" e selecione o JDK instalado
   - **Spring Initializr Service URL**: Deixe o padrão `https://start.spring.io`
4. Clique em **Next** (botão no canto inferior direito)

##### Passo 1.4: Configurar Metadados do Projeto

Nesta tela, você configurará as informações básicas do projeto:

**Preencha os campos:**

- **Group**: `com.example`
  - *Identifica a organização/empresa (padrão da indústria)*
  
- **Artifact**: `crud-spring-boot`
  - *Nome do projeto (será usado no nome do JAR)*
  
- **Version**: `0.0.1-SNAPSHOT` (deixe o padrão)
  - *Versão do projeto*
  
- **Name**: `crud-spring-boot`
  - *Nome do projeto (geralmente igual ao Artifact)*
  
- **Description**: `CRUD Spring Boot Application`
  - *Descrição opcional do projeto*
  
- **Package**: `com.example.crud`
  - *Nome do pacote base Java (geralmente Group + Artifact)*
  
- **Packaging**: Selecione **Jar**
  - *Jar: aplicação standalone (recomendado)*
  - *War: para deploy em servidor de aplicação*
  
- **Java**: Selecione **21** (recomendado LTS), **17** (LTS), ou **24** (mais recente)
  - *Versão do Java (21 e 17 são LTS - Long Term Support)*
  - ⚠️ **IMPORTANTE**: Java 24 é muito novo - pode precisar de configuração adicional no `pom.xml` (veja Troubleshooting)

**Clique em Next**

##### Passo 1.5: Selecionar Dependências

Esta é uma das partes mais importantes! Aqui você seleciona as bibliotecas que o projeto vai usar.

**Como adicionar dependências:**

1. **Na lista de categorias à esquerda**, você verá:
   - Developer Tools
   - Web
   - SQL
   - NoSQL
   - E outras categorias...

2. **Procure e marque as seguintes dependências:**

   **Na categoria "Web":**
   - ✅ **Spring Web**
     - *Procure digitando "web" na busca ou navegue até Web → Spring Web*
     - *Essencial para criar APIs REST*

   **Na categoria "SQL":**
   - ✅ **Spring Data JPA**
     - *Procure "jpa" ou navegue até SQL → Spring Data JPA*
     - *Para acesso a dados com JPA*
   
   - ✅ **H2 Database**
     - *Procure "h2" ou navegue até SQL → H2 Database*
     - *Banco de dados em memória para desenvolvimento*

   **Na categoria "Core":**
   - ✅ **Validation**
     - *Procure "validation" ou navegue até Core → Validation*
     - *Para validações de dados (@NotBlank, @Positive, etc.)*

   **Na categoria "Developer Tools":**
   - ✅ **Lombok**
     - *Procure "lombok" ou navegue até Developer Tools → Lombok*
     - *Para reduzir código repetitivo*

3. **Verifique as dependências selecionadas:**
   - No lado direito, você verá uma lista com todas as dependências marcadas
   - Deve aparecer: Spring Web, Spring Data JPA, H2 Database, Validation, Lombok

4. **Clique em Next**

##### Passo 1.6: Configurar Nome e Localização

1. **Project name**: `crud-spring-boot`
   - *Nome da pasta do projeto*

2. **Project location**: 
   - Escolha onde salvar o projeto
   - Exemplo: `C:\Dev\crud-spring-boot` ou `/home/usuario/projetos/crud-spring-boot`
   - **Dica**: Crie uma pasta específica para seus projetos Spring Boot

3. **Clique em Finish**

##### Passo 1.7: Aguardar Configuração Automática

O IntelliJ vai fazer várias coisas automaticamente:

1. **Baixar o projeto do Spring Initializr**
   - Pode levar alguns segundos

2. **Baixar todas as dependências do Maven**
   - Isso pode levar alguns minutos na primeira vez
   - Você verá uma barra de progresso no canto inferior direito
   - **Não feche o IntelliJ durante este processo!**

3. **Indexar os arquivos do projeto**
   - O IntelliJ analisa todo o código para oferecer autocomplete

4. **Configurar o projeto**
   - Cria a estrutura de pastas
   - Configura o Maven
   - Prepara tudo para desenvolvimento

**⏳ Aguarde até ver "BUILD SUCCESS" ou até a barra de progresso desaparecer**

##### Passo 1.8: Verificar se Está Tudo OK

Após a configuração, verifique:

1. **Estrutura do Projeto** (painel esquerdo):
   ```
   crud-spring-boot
   ├── .mvn
   ├── src
   │   ├── main
   │   │   ├── java
   │   │   │   └── com.example.crud
   │   │   │       └── CrudSpringBootApplication.java
   │   │   └── resources
   │   │       └── application.properties
   │   └── test
   ├── pom.xml
   └── ...
   ```

2. **Abra o arquivo `pom.xml`** e verifique se as dependências estão lá

3. **Tente executar a aplicação**:
   - Clique com botão direito em `CrudSpringBootApplication.java`
   - Selecione **"Run 'CrudSpringBootApplication'"**
   - Deve iniciar sem erros (mesmo que não faça nada ainda)

**✅ Se tudo isso funcionou, seu projeto está pronto!**

---

#### Opção B: Via Site Spring Initializr (Alternativa)

**💡 Quando usar a Opção B (Site)?**

- Se o IntelliJ não tiver o plugin Spring Boot instalado
- Se preferir usar o site oficial
- Se quiser compartilhar a URL do projeto com outros alunos
- Se tiver problemas com a integração do IntelliJ

### Passo 2: Verificar se o Projeto foi Criado Corretamente

Após criar o projeto (via site ou IDE), verifique se tudo está correto:

#### 2.1: Verificar a Estrutura de Pastas

Você deve ter a seguinte estrutura:

```
crud-spring-boot/
├── .mvn/                          # Maven Wrapper (permite usar Maven sem instalação)
│   └── wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/crud/
│   │   │       └── CrudSpringBootApplication.java  # ⭐ Classe principal
│   │   └── resources/
│   │       ├── application.properties                # ⭐ Configurações
│   │       ├── static/                              # Arquivos estáticos (CSS, JS, etc.)
│   │       └── templates/                          # Templates (HTML, etc.)
│   └── test/                                        # Testes unitários
│       └── java/
│           └── com/example/crud/
│               └── CrudSpringBootApplicationTests.java
├── .gitignore                                       # Arquivos ignorados pelo Git
├── mvnw                                             # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                         # Maven Wrapper (Windows)
├── pom.xml                                          # ⭐ Configuração Maven e dependências
└── README.md                                        # Documentação do projeto
```

#### 2.2: Verificar o arquivo `pom.xml`

Abra o arquivo `pom.xml` e verifique se contém as dependências que você selecionou:

```xml
<dependencies>
    <!-- Spring Web - Para APIs REST -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Data JPA - Para acesso a dados -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- H2 Database - Banco em memória -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Validation - Para validações -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- Lombok - Para reduzir boilerplate -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    
    <!-- Testes -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

**✅ Se todas as dependências estão presentes, está tudo certo!**

#### 2.3: Verificar a Classe Principal

Abra `src/main/java/com/example/crud/CrudSpringBootApplication.java`. Deve estar assim:

```java
package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudSpringBootApplication.class, args);
    }
}
```

**✅ Se está assim, está perfeito!**

#### 2.4: Verificar o application.properties

Abra `src/main/resources/application.properties`. Pode estar vazio ou com algumas configurações básicas. Isso é normal - vamos configurar depois!

**🎉 Parabéns! Seu projeto Spring Boot está pronto para desenvolvimento!**

### 💡 Dicas Específicas para IntelliJ IDEA

#### Dica 1: Plugin Spring Boot

Se a opção "Spring Initializr" não aparecer ao criar um novo projeto:

1. **File → Settings** (ou `Ctrl+Alt+S`)
2. **Plugins**
3. Procure por **"Spring Boot"**
4. Marque a caixa e clique em **Apply**
5. Reinicie o IntelliJ

#### Dica 2: Maven Auto-Import

O IntelliJ geralmente detecta automaticamente mudanças no `pom.xml`, mas se não detectar:

1. Abra o `pom.xml`
2. Procure por um banner no topo: **"Maven projects need to be imported"**
3. Clique em **"Import Changes"** ou **"Enable Auto-Import"**

#### Dica 3: Executar a Aplicação

**Método 1 - Botão Run:**
- Clique com botão direito em `CrudSpringBootApplication.java`
- Selecione **"Run 'CrudSpringBootApplication'"**
- Ou use o atalho: `Shift+F10`

**Método 2 - Terminal Integrado:**
- Abra o terminal no IntelliJ (View → Tool Windows → Terminal)
- Execute: `./mvnw spring-boot:run` (Linux/Mac) ou `mvnw.cmd spring-boot:run` (Windows)

#### Dica 4: Ver Logs da Aplicação

Quando a aplicação estiver rodando:
- Os logs aparecem na aba **"Run"** na parte inferior do IntelliJ
- Você verá mensagens como: "Started CrudSpringBootApplication in X seconds"

#### Dica 5: Parar a Aplicação

- Clique no botão **vermelho de stop** (quadrado) na barra de ferramentas
- Ou use o atalho: `Ctrl+F2` (Windows/Linux) ou `Cmd+F2` (Mac)

#### Dica 6: Configurar Lombok no IntelliJ

Se o Lombok não estiver funcionando (erros de "cannot find symbol"):

1. **File → Settings → Plugins**
2. Procure por **"Lombok"**
3. Instale o plugin Lombok
4. **File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors**
5. Marque **"Enable annotation processing"**
6. Clique em **Apply** e **OK**
7. Reinicie o IntelliJ

#### Dica 7: Atalhos Úteis do IntelliJ

- **`Ctrl+Alt+L`**: Formatar código
- **`Ctrl+Space`**: Autocomplete
- **`Ctrl+Shift+F10`**: Executar aplicação
- **`Ctrl+F2`**: Parar aplicação
- **`Alt+Enter`**: Sugestões rápidas (quick fixes)
- **`Ctrl+Click`**: Navegar para definição
- **`Alt+Insert`**: Gerar código (getters, setters, construtores)

---

### 💡 Dicas Extras sobre o Spring Initializr

#### Dica 1: URL Pré-configurada (Atalho Rápido)

Você pode usar esta URL para gerar o projeto já configurado:

```
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.5.8&packaging=jar&jvmVersion=21&groupId=com.example&artifactId=crud-spring-boot&name=crud-spring-boot&description=CRUD%20Spring%20Boot%20Application&packageName=com.example.crud&dependencies=web,data-jpa,h2,validation,lombok
```

**Como usar:**
1. Copie a URL acima
2. Cole no navegador
3. Pressione Enter
4. O projeto já virá configurado!
5. Clique em "Generate" para baixar

#### Dica 2: Explorar Dependências Disponíveis

O Spring Initializr tem centenas de dependências disponíveis! Explore em:

- **Site oficial**: [https://start.spring.io/dependencies](https://start.spring.io/dependencies)
- **Categorias principais**:
  - **Web**: Spring Web, WebFlux, GraphQL
  - **SQL**: JPA, JDBC, PostgreSQL, MySQL, MongoDB
  - **NoSQL**: Redis, MongoDB, Cassandra
  - **Security**: Spring Security, OAuth2
  - **Messaging**: RabbitMQ, Kafka
  - **Developer Tools**: DevTools, Lombok, Actuator

#### Dica 3: Gerar apenas o pom.xml

Se você já tem um projeto e só quer o `pom.xml`:

1. Configure o projeto no Spring Initializr
2. Clique em **"Explore"** (ao invés de "Generate")
3. Você verá o `pom.xml` gerado
4. Copie e cole no seu projeto

#### Dica 4: Versões do Spring Boot

**Versões LTS (Long Term Support) - Recomendadas:**
- **3.4.x**: Versão estável e confiável
- **3.5.x**: Versão mais recente estável
- **4.0.x**: Versão mais nova (pode ter mudanças)

**Para este curso, recomendamos:**
- **3.5.8** ou **3.4.12** (mais estáveis)
- Evite versões SNAPSHOT em produção

#### Dica 5: Maven vs Gradle

**Maven** (Recomendado para iniciantes):
- ✅ Mais simples
- ✅ XML de configuração
- ✅ Amplamente usado
- ✅ Melhor documentação

**Gradle**:
- ✅ Mais flexível
- ✅ Builds mais rápidos
- ✅ DSL Kotlin/Groovy
- ⚠️ Curva de aprendizado maior

**Para este curso, usaremos Maven!**

#### Dica 6: Verificar Dependências Após o Download

Após baixar o projeto, sempre verifique:

1. **Abra o `pom.xml`**
2. **Procure pela seção `<dependencies>`**
3. **Confirme que todas as dependências estão presentes**

Se alguma dependência estiver faltando:
- Adicione manualmente no `pom.xml`, ou
- Recrie o projeto no Spring Initializr

#### Dica 7: Problemas Comuns

**Problema**: "Dependência não encontrada"
- **Solução**: Verifique se adicionou corretamente no Spring Initializr

**Problema**: "Projeto não compila"
- **Solução**: Aguarde o Maven baixar todas as dependências (pode levar alguns minutos)

**Problema**: "Lombok não funciona"
- **Solução**: Instale o plugin Lombok na sua IDE e habilite annotation processing

---

## 📐 Ordem de Desenvolvimento

### 🎯 Sequência Correta (Profissional)

Seguir esta ordem é **essencial** para um desenvolvimento organizado e profissional:

```
1️⃣ Model (Entidade)
   ↓
2️⃣ Repository (Acesso a Dados)
   ↓
3️⃣ Service (Lógica de Negócio)
   ↓
4️⃣ Controller (API REST)
   ↓
5️⃣ Exception Handler (Tratamento de Erros)
   ↓
6️⃣ Application Properties (Configurações)
   ↓
7️⃣ Application Main (Classe Principal - já existe)
```

### Por que essa ordem?

- **Model primeiro**: Tudo depende da entidade
- **Repository depois**: Precisa do Model para funcionar
- **Service em seguida**: Precisa do Repository
- **Controller por último**: Precisa do Service
- **Exception Handler**: Só faz sentido quando a API está funcionando

---

## 🔨 Passo a Passo Detalhado

### 📦 PASSO 1: Model (Entidade) - `Product.java`

#### O que é uma Entidade?

Uma **entidade** é uma classe Java que representa uma tabela no banco de dados. Cada instância da classe representa uma linha da tabela.

#### Criando a Entidade

1. **Crie o pacote `model`**:
   - Clique com botão direito em `com.example.crud`
   - New → Package
   - Nome: `model`

2. **Crie a classe `Product`**:
   - Clique com botão direito em `model`
   - New → Java Class
   - Nome: `Product`

3. **Código completo da classe `Product`**:

```java
package com.example.crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade Product - Representa a tabela "products" no banco de dados
 * 
 * Esta classe é mapeada para uma tabela usando JPA (Jakarta Persistence API).
 * O JPA converte objetos Java em registros SQL automaticamente.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "products") // Nome da tabela no banco (opcional)
@Getter // Lombok: gera getters automaticamente
@Setter // Lombok: gera setters automaticamente
@AllArgsConstructor // Lombok: gera construtor com todos os campos
@NoArgsConstructor // Lombok: gera construtor sem argumentos (necessário para JPA)
public class Product {

    @Id // Marca como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID gerado automaticamente
    private Long id;

    @NotBlank(message = "O nome do produto não pode estar vazio")
    @Column(nullable = false, length = 100)
    private String name;

    @Positive(message = "O preço deve ser maior que zero")
    @Column(nullable = false)
    private Integer priceInCents; // Preço em centavos para evitar problemas de arredondamento
}
```

#### Explicação das Anotações:

- **`@Entity`**: Marca a classe como uma entidade JPA (será mapeada para uma tabela)
- **`@Table(name = "products")`**: Define o nome da tabela no banco
- **`@Id`**: Marca o campo como chave primária
- **`@GeneratedValue`**: Define que o ID será gerado automaticamente
- **`@Column`**: Define propriedades da coluna (nullable, length, etc.)
- **`@NotBlank`**: Valida que o campo não seja nulo, vazio ou apenas espaços
- **`@Positive`**: Valida que o número seja positivo
- **Lombok**: Anotações que geram código automaticamente (getters, setters, construtores)

---

### 📚 PASSO 2: Repository (Acesso a Dados) - `ProductRepository.java`

#### O que é um Repository?

Um **Repository** é uma interface que fornece métodos para acessar dados. O Spring Data JPA cria automaticamente a implementação!

#### Criando o Repository

1. **Crie o pacote `repository`**:
   - Clique com botão direito em `com.example.crud`
   - New → Package
   - Nome: `repository`

2. **Crie a interface `ProductRepository`**:
   - Clique com botão direito em `repository`
   - New → Java Class → Interface
   - Nome: `ProductRepository`

3. **Código completo da interface**:

```java
package com.example.crud.repository;

import com.example.crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository - Camada de acesso a dados
 * 
 * Esta interface herda métodos prontos do JpaRepository:
 * - save(entity): Salva ou atualiza
 * - findById(id): Busca por ID
 * - findAll(): Busca todos
 * - deleteById(id): Deleta por ID
 * - existsById(id): Verifica se existe
 * 
 * O Spring cria a implementação automaticamente!
 */
@Repository // Marca como componente Spring
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Esta interface está vazia, mas herda todos os métodos do JpaRepository!
}
```

#### Explicação:

- **`JpaRepository<Product, Long>`**: 
  - `Product`: A entidade que este repositório gerencia
  - `Long`: O tipo da chave primária
- **Métodos automáticos**: Você ganha métodos CRUD sem escrever código!

---

### 🧠 PASSO 3: Service (Lógica de Negócio) - `ProductService.java`

#### O que é um Service?

Um **Service** contém a **lógica de negócio** da aplicação. Ele fica entre o Controller e o Repository.

#### Por que usar Service?

- ✅ Separa responsabilidades
- ✅ Facilita testes
- ✅ Permite reutilização
- ✅ Melhora manutenção

#### Criando o Service

1. **Crie o pacote `service`**:
   - Clique com botão direito em `com.example.crud`
   - New → Package
   - Nome: `service`

2. **Crie a classe `ProductService`**:
   - Clique com botão direito em `service`
   - New → Java Class
   - Nome: `ProductService`

3. **Código completo da classe**:

```java
package com.example.crud.service;

import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service - Camada de lógica de negócio
 * 
 * Esta classe contém toda a lógica de negócio.
 * O Controller NÃO deve acessar o Repository diretamente!
 * 
 * Fluxo correto: Controller → Service → Repository → Banco
 */
@Service // Marca como componente Spring do tipo Service
public class ProductService {

    @Autowired // Injeção de dependência do Repository
    private ProductRepository productRepository;

    /**
     * CREATE - Criar um novo produto
     */
    public Product createProduct(Product product) {
        // Aqui você pode adicionar lógica de negócio:
        // - Validar se nome já existe
        // - Aplicar descontos
        // - Enviar notificações
        return productRepository.save(product);
    }

    /**
     * READ - Listar todos os produtos
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * READ - Buscar produto por ID
     */
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }
        return productOptional.get();
    }

    /**
     * UPDATE - Atualizar um produto
     */
    public Product updateProduct(Long id, Product productDetails) {
        // Busca o produto existente
        Product product = getProductById(id);
        
        // Atualiza os campos
        product.setName(productDetails.getName());
        product.setPriceInCents(productDetails.getPriceInCents());
        
        // Salva as alterações
        return productRepository.save(product);
    }

    /**
     * DELETE - Deletar um produto
     */
    public void deleteProduct(Long id) {
        // Verifica se existe
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        // Deleta
        productRepository.deleteById(id);
    }
}
```

---

### 🌐 PASSO 4: Controller (API REST) - `ProductController.java`

#### O que é um Controller?

Um **Controller** recebe requisições HTTP e retorna respostas. É a camada que expõe a API.

#### Criando o Controller

1. **Crie o pacote `controller`**:
   - Clique com botão direito em `com.example.crud`
   - New → Package
   - Nome: `controller`

2. **Crie a classe `ProductController`**:
   - Clique com botão direito em `controller`
   - New → Java Class
   - Nome: `ProductController`

3. **Código completo da classe**:

```java
package com.example.crud.controller;

import com.example.crud.model.Product;
import com.example.crud.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller - Camada de apresentação (API REST)
 * 
 * Esta classe expõe os endpoints HTTP da aplicação.
 * O Controller delega a lógica de negócio para o Service.
 */
@RestController // Marca como controller REST (retorna JSON)
@RequestMapping("/products") // Caminho base para todos os endpoints
public class ProductController {

    @Autowired // Injeção de dependência do Service
    private ProductService productService;

    /**
     * POST /products - Criar um novo produto
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    /**
     * GET /products - Listar todos os produtos
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * GET /products/{id} - Buscar produto por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * PUT /products/{id} - Atualizar um produto
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id, 
            @Valid @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * DELETE /products/{id} - Deletar um produto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
```

#### Explicação das Anotações HTTP:

- **`@PostMapping`**: Mapeia requisições HTTP POST
- **`@GetMapping`**: Mapeia requisições HTTP GET
- **`@PutMapping`**: Mapeia requisições HTTP PUT
- **`@DeleteMapping`**: Mapeia requisições HTTP DELETE
- **`@PathVariable`**: Extrai variáveis da URL (ex: `/products/{id}`)
- **`@RequestBody`**: Converte JSON do corpo da requisição em objeto Java
- **`@Valid`**: Habilita validações do Bean Validation

---

### ⚠️ PASSO 5: Exception Handler (Tratamento de Erros) - `GlobalExceptionHandler.java`

#### O que é um Exception Handler?

Um **Exception Handler** centraliza o tratamento de erros, retornando respostas HTTP padronizadas.

#### Criando o Exception Handler

1. **Crie o pacote `exception`**:
   - Clique com botão direito em `com.example.crud`
   - New → Package
   - Nome: `exception`

2. **Crie a classe `GlobalExceptionHandler`**:
   - Clique com botão direito em `exception`
   - New → Java Class
   - Nome: `GlobalExceptionHandler`

3. **Código completo da classe**:

```java
package com.example.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Exception Handler - Tratamento global de exceções
 * 
 * Esta classe captura exceções lançadas em qualquer controller
 * e retorna respostas HTTP apropriadas.
 */
@RestControllerAdvice // Marca como handler global de exceções
public class GlobalExceptionHandler {

    /**
     * Trata RuntimeException (ex: produto não encontrado)
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Trata erros de validação (ex: campo vazio, valor negativo)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        errors.put("status", String.valueOf(HttpStatus.BAD_REQUEST.value()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
```

---

### ⚙️ PASSO 6: Application Properties (Configurações)

#### Configurando o Banco de Dados

1. **Abra o arquivo `application.properties`**:
   - Localização: `src/main/resources/application.properties`

2. **Adicione as seguintes configurações**:

```properties
# Nome da aplicação
spring.application.name=crud-spring-boot

# ============================================
# CONFIGURAÇÕES DO BANCO H2 (EM MEMÓRIA)
# ============================================

# URL de conexão com o banco H2
spring.datasource.url=jdbc:h2:mem:testdb

# Usuário e senha do H2
spring.datasource.username=sa
spring.datasource.password=

# Driver do H2
spring.datasource.driver-class-name=org.h2.Driver

# ============================================
# CONSOLE H2 (Interface Web)
# ============================================

# Habilita o console web do H2
spring.h2.console.enabled=true

# Caminho do console (acesse em: http://localhost:8080/h2-console)
spring.h2.console.path=/h2-console

# ============================================
# CONFIGURAÇÕES JPA/HIBERNATE
# ============================================

# Dialeto SQL do H2
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Estratégia de criação do schema
# update: Cria/atualiza tabelas automaticamente
spring.jpa.hibernate.ddl-auto=update

# Exibe queries SQL no console (útil para debug)
spring.jpa.show-sql=true

# Formata as queries SQL (facilita leitura)
spring.jpa.properties.hibernate.format_sql=true
```

#### Explicação das Configurações:

- **`spring.datasource.url`**: URL de conexão com o banco
- **`spring.h2.console.enabled`**: Habilita interface web para visualizar dados
- **`spring.jpa.hibernate.ddl-auto=update`**: Cria/atualiza tabelas automaticamente
- **`spring.jpa.show-sql=true`**: Mostra as queries SQL no console (útil para aprender!)

---

## 🧪 Testando a Aplicação

### Passo 1: Executar a Aplicação no IntelliJ IDEA

#### Método 1: Botão Run (Mais Fácil)

1. **Localize a classe principal**:
   - No painel de projetos (lado esquerdo), navegue até:
   - `src/main/java/com/example/crud/CrudSpringBootApplication.java`

2. **Abra o arquivo** (duplo clique)

3. **Execute a aplicação**:
   - **Opção A**: Clique com botão direito no arquivo → **"Run 'CrudSpringBootApplication'"**
   - **Opção B**: Clique no ícone de "play" (▶️) verde ao lado do método `main`
   - **Opção C**: Use o atalho: `Ctrl+Shift+F10` (Windows/Linux) ou `Cmd+Shift+R` (Mac)

4. **Aguarde a inicialização**:
   - Você verá logs no console na parte inferior do IntelliJ
   - Procure por: `Started CrudSpringBootApplication in X.XXX seconds`
   - Se aparecer essa mensagem, a aplicação está rodando! ✅

#### Método 2: Terminal Integrado do IntelliJ

1. **Abra o terminal**:
   - **View → Tool Windows → Terminal**
   - Ou use o atalho: `Alt+F12`

2. **Execute o comando usando Maven Wrapper**:
   
   **⚠️ IMPORTANTE**: Use `mvnw.cmd` (Windows) ou `./mvnw` (Linux/Mac) ao invés de `mvn`!
   
   O projeto Spring Boot vem com **Maven Wrapper**, que permite executar o Maven **sem precisar instalar o Maven** no sistema.
   
   ```bash
   # Windows (PowerShell ou CMD)
   .\mvnw.cmd spring-boot:run
   
   # Linux/Mac
   ./mvnw spring-boot:run
   ```
   
   **Por que usar Maven Wrapper?**
   - ✅ Não precisa instalar Maven globalmente
   - ✅ Garante que todos usam a mesma versão do Maven
   - ✅ Funciona mesmo sem Maven instalado
   - ✅ Já vem incluído no projeto Spring Boot

3. **Aguarde a inicialização** (mesmo processo do Método 1)

#### Método 3: Configuração de Run (Para Executar Múltiplas Vezes)

1. **Crie uma configuração de Run**:
   - Clique na seta ao lado do botão Run (▶️)
   - Selecione **"Edit Configurations..."**
   - Clique no **"+"** (plus)
   - Selecione **"Spring Boot"**

2. **Configure**:
   - **Name**: `CrudSpringBootApplication`
   - **Main class**: `com.example.crud.CrudSpringBootApplication`
   - Clique em **OK**

3. **Execute**:
   - Agora você pode executar usando o botão Run ou `Shift+F10`

#### ⚠️ Problemas Comuns ao Executar

**Problema**: `'mvn' is not recognized` ou `mvn: command not found`
- **Causa**: O Maven não está instalado ou não está no PATH do sistema
- **Solução**: Use o **Maven Wrapper** que já vem com o projeto!
  ```bash
  # Windows (PowerShell ou CMD)
  .\mvnw.cmd spring-boot:run
  
  # Linux/Mac
  ./mvnw spring-boot:run
  ```
- **Alternativa**: Se realmente quiser usar `mvn`, instale o Maven:
  - Windows: [Download Maven](https://maven.apache.org/download.cgi)
  - Adicione ao PATH do sistema
  - Mas **não é necessário** - o wrapper funciona perfeitamente!

**Problema**: `'mvnw' is not recognized` (Windows)
- **Causa**: Você está usando `mvnw` ao invés de `mvnw.cmd`
- **Solução**: No Windows, use sempre `mvnw.cmd`:
  ```bash
  .\mvnw.cmd spring-boot:run
  ```
- **Dica**: No PowerShell, você pode usar `.\mvnw` que funciona também

**Problema**: "Port 8080 already in use"
- **Causa**: Outra aplicação está usando a porta 8080
- **Solução**: Altere a porta no `application.properties`:
  ```properties
  server.port=8081
  ```
- **Ou**: Feche a aplicação que está usando a porta 8080

**Problema**: "Cannot resolve symbol"
- **Causa**: Dependências não foram baixadas ou projeto não foi importado
- **Solução**: 
  1. Clique com botão direito no projeto
  2. **Maven → Reload Project**
  3. Aguarde o IntelliJ baixar as dependências
  4. Se não funcionar, feche e reabra o IntelliJ

**Problema**: Aplicação não inicia
- **Solução**: Verifique os logs no console para ver o erro específico
- **Dica**: Os logs aparecem na aba "Run" na parte inferior do IntelliJ

### Passo 2: Verificar se está funcionando

1. Abra o navegador
2. Acesse: `http://localhost:8080/products`
3. Você deve ver: `[]` (lista vazia, pois não há produtos ainda)

### Passo 3: Testar os Endpoints

#### Usando Postman ou Insomnia

#### 1. **CREATE - Criar um Produto**

- **Método**: `POST`
- **URL**: `http://localhost:8080/products`
- **Headers**: 
  ```
  Content-Type: application/json
  ```
- **Body** (JSON):
  ```json
  {
    "name": "Notebook",
    "priceInCents": 250000
  }
  ```
- **Resposta esperada**: Status `201 Created` com o produto criado (incluindo o ID)

#### 2. **READ - Listar Todos os Produtos**

- **Método**: `GET`
- **URL**: `http://localhost:8080/products`
- **Resposta esperada**: Status `200 OK` com lista de produtos

#### 3. **READ - Buscar Produto por ID**

- **Método**: `GET`
- **URL**: `http://localhost:8080/products/1` (substitua 1 pelo ID do produto)
- **Resposta esperada**: Status `200 OK` com o produto encontrado

#### 4. **UPDATE - Atualizar um Produto**

- **Método**: `PUT`
- **URL**: `http://localhost:8080/products/1` (substitua 1 pelo ID)
- **Headers**: 
  ```
  Content-Type: application/json
  ```
- **Body** (JSON):
  ```json
  {
    "name": "Notebook Atualizado",
    "priceInCents": 300000
  }
  ```
- **Resposta esperada**: Status `200 OK` com o produto atualizado

#### 5. **DELETE - Deletar um Produto**

- **Método**: `DELETE`
- **URL**: `http://localhost:8080/products/1` (substitua 1 pelo ID)
- **Resposta esperada**: Status `204 No Content` (sem corpo)

### Passo 4: Visualizar Dados no Console H2

1. Abra o navegador
2. Acesse: `http://localhost:8080/h2-console`
3. **JDBC URL**: `jdbc:h2:mem:testdb`
4. **User**: `sa`
5. **Password**: (deixe vazio)
6. Clique em **"Connect"**
7. Execute a query: `SELECT * FROM products;`

---

## 📝 Exercícios Práticos

### Exercício 1: Adicionar Novo Campo

**Objetivo**: Adicionar um campo `description` (descrição) ao produto.

**Passos**:
1. Adicione o campo `description` na classe `Product`
2. Adicione validação `@NotBlank` no campo
3. Reinicie a aplicação
4. Teste criando um produto com descrição

**Solução**:
```java
@NotBlank(message = "A descrição não pode estar vazia")
@Column(nullable = false, length = 500)
private String description;
```

### Exercício 2: Criar Método de Busca Customizado

**Objetivo**: Criar um método no Repository para buscar produtos por nome.

**Passos**:
1. Adicione o método no `ProductRepository`:
   ```java
   List<Product> findByNameContainingIgnoreCase(String name);
   ```
2. Adicione o método no `ProductService`:
   ```java
   public List<Product> searchProductsByName(String name) {
       return productRepository.findByNameContainingIgnoreCase(name);
   }
   ```
3. Adicione o endpoint no `ProductController`:
   ```java
   @GetMapping("/search")
   public ResponseEntity<List<Product>> searchProducts(@RequestParam String name) {
       List<Product> products = productService.searchProductsByName(name);
       return ResponseEntity.ok(products);
   }
   ```
4. Teste: `GET http://localhost:8080/products/search?name=notebook`

### Exercício 3: Adicionar Validação de Preço Máximo

**Objetivo**: Validar que o preço não seja maior que 1.000.000 centavos (R$ 10.000,00).

**Passos**:
1. Crie uma anotação customizada ou use `@Max`
2. Adicione no campo `priceInCents`:
   ```java
   @Max(value = 1000000, message = "O preço não pode ser maior que R$ 10.000,00")
   ```

### Exercício 4: Implementar Soft Delete

**Objetivo**: Ao invés de deletar, marcar o produto como deletado.

**Passos**:
1. Adicione campo `deleted` (boolean) na entidade
2. Modifique o método `deleteProduct` para marcar como deletado
3. Modifique `getAllProducts` para não retornar produtos deletados

---

## 💡 Boas Práticas e Dicas

### 1. **Sempre use a camada Service**

❌ **ERRADO**:
```java
@RestController
public class ProductController {
    @Autowired
    private ProductRepository repository; // Controller acessando Repository diretamente
}
```

✅ **CORRETO**:
```java
@RestController
public class ProductController {
    @Autowired
    private ProductService service; // Controller usando Service
}
```

### 2. **Valide sempre os dados de entrada**

Use `@Valid` nos métodos do Controller:
```java
public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
    // ...
}
```

### 3. **Use nomes descritivos**

- ✅ `getProductById` - claro e objetivo
- ❌ `get` - muito genérico

### 4. **Trate exceções adequadamente**

Use `GlobalExceptionHandler` para centralizar o tratamento de erros.

### 5. **Documente seu código**

Use comentários JavaDoc para explicar métodos complexos:
```java
/**
 * Cria um novo produto aplicando regras de negócio.
 * 
 * @param product O produto a ser criado
 * @return O produto criado com ID gerado
 * @throws BusinessException Se o nome já existir
 */
```

### 6. **Teste sempre**

Teste cada endpoint após criar:
- ✅ Criar produto
- ✅ Listar produtos
- ✅ Buscar por ID
- ✅ Atualizar produto
- ✅ Deletar produto

---

## 🔧 Troubleshooting (Solução de Problemas)

### Problema 1: "'mvn' is not recognized" ou "mvn: command not found"

**Erro completo:**
```
mvn : The term 'mvn' is not recognized as the name of a cmdlet, function, script file, or operable program.
```

**Causa:**
- O Maven não está instalado no sistema
- Ou o Maven não está no PATH do sistema

**Solução Rápida (Recomendada):**
Use o **Maven Wrapper** que já vem com o projeto Spring Boot! Você **não precisa** instalar o Maven.

**Windows (PowerShell ou CMD):**
```bash
# Navegue até a pasta do projeto
cd C:\Dev\projeto-java\projeto_test

# Use o Maven Wrapper (note o .cmd no final)
.\mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
# Navegue até a pasta do projeto
cd /caminho/para/projeto

# Use o Maven Wrapper
./mvnw spring-boot:run
```

**Por que usar Maven Wrapper?**
- ✅ Não precisa instalar Maven
- ✅ Funciona em qualquer máquina
- ✅ Garante mesma versão do Maven para todos
- ✅ Já vem incluído no projeto

**Se realmente quiser instalar o Maven (opcional):**

1. **Windows:**
   - Baixe: [Maven Download](https://maven.apache.org/download.cgi)
   - Extraia em uma pasta (ex: `C:\Program Files\Apache\maven`)
   - Adicione ao PATH do sistema:
     - Variáveis de Ambiente → Path → Adicionar pasta `bin` do Maven
   - Reinicie o terminal
   - Teste: `mvn -version`

2. **Linux/Mac:**
   ```bash
   # Ubuntu/Debian
   sudo apt-get install maven
   
   # Mac (com Homebrew)
   brew install maven
   
   # Verificar
   mvn -version
   ```

**Mas lembre-se: NÃO É NECESSÁRIO! O wrapper funciona perfeitamente!**

### Problema 2: "release version 24 not supported" ou "release version X not supported"

**Erro completo:**
```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.14.1:compile (default-compile) on project projeto_test: Fatal error compiling: error: release version 24 not supported
```

**Causa:**
- O projeto está configurado para uma versão do Java que não é suportada pelo Maven Compiler Plugin padrão
- Versões muito novas do Java (24, 23, 22) podem precisar de configuração adicional

**Solução para Java 24:**

Se você quer usar **Java 24**, precisa configurar explicitamente o Maven Compiler Plugin:

1. **Abra o arquivo `pom.xml`** na raiz do projeto

2. **Adicione/Atualize a seção `<properties>`**:
   ```xml
   <properties>
       <java.version>24</java.version>
       <maven.compiler.source>24</maven.compiler.source>
       <maven.compiler.target>24</maven.compiler.target>
   </properties>
   ```

3. **Adicione o Maven Compiler Plugin na seção `<build><plugins>`**:
   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-maven-plugin</artifactId>
           </plugin>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-compiler-plugin</artifactId>
               <version>3.13.0</version>
               <configuration>
                   <source>24</source>
                   <target>24</target>
                   <release>24</release>
               </configuration>
           </plugin>
       </plugins>
   </build>
   ```

4. **Salve o arquivo** (`Ctrl+S`)

5. **Execute novamente**:
   ```bash
   .\mvnw.cmd spring-boot:run
   ```

**⚠️ IMPORTANTE - Requisitos para Java 24:**
- Você precisa ter o **JDK 24 instalado** no seu sistema
- Verifique com: `java -version`
- Se não tiver, baixe: [OpenJDK 24](https://jdk.java.net/24/) (se disponível) ou use uma versão LTS

**Solução Alternativa - Usar versão LTS (Recomendado):**

Se você não tem Java 24 ou está tendo problemas, use uma versão LTS:

1. **Altere para Java 21 (LTS)**:
   ```xml
   <properties>
       <java.version>21</java.version>
   </properties>
   ```

2. **Remova o maven-compiler-plugin** (não é necessário para versões LTS)

3. **Versões recomendadas:**
   - **Java 21** (LTS - Long Term Support) - ✅ **Mais recomendado** (mais recente)
   - **Java 17** (LTS) - ✅ Também recomendado
   - **Java 11** (LTS antiga) - Funciona, mas mais antiga

**💡 Dica**: Para projetos de aprendizado, recomendo usar **Java 21 (LTS)** que é mais estável e amplamente suportada. Java 24 é muito novo e pode ter problemas de compatibilidade com algumas bibliotecas.

### Problema 3: "Port 8080 already in use"

**Solução**: Altere a porta no `application.properties`:
```properties
server.port=8081
```

### Problema 2: "Cannot resolve symbol 'Lombok'"

**Solução**: 
1. Instale o plugin Lombok na sua IDE
2. Habilite annotation processing
3. Reinicie a IDE

### Problema 3: "Table 'products' doesn't exist"

**Solução**: Verifique se `spring.jpa.hibernate.ddl-auto=update` está no `application.properties`

### Problema 4: "Validation failed"

**Solução**: Verifique se os dados enviados estão corretos:
- `name` não pode estar vazio
- `priceInCents` deve ser positivo

### Problema 5: "Product not found"

**Solução**: Verifique se o ID existe. Liste todos os produtos primeiro para ver os IDs disponíveis.

---

## 📚 Recursos Adicionais

### Documentação Oficial

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Bean Validation](https://beanvalidation.org/)

### Tutoriais Recomendados

- [Spring Boot Tutorial - Baeldung](https://www.baeldung.com/spring-boot)
- [Spring Data JPA Tutorial](https://www.baeldung.com/spring-data-jpa-tutorial)

### Próximos Passos

1. ✅ Adicionar paginação
2. ✅ Implementar autenticação (Spring Security)
3. ✅ Adicionar testes unitários
4. ✅ Migrar para PostgreSQL
5. ✅ Adicionar documentação com Swagger

---

## ✅ Checklist Final

Antes de considerar o projeto completo, verifique:

- [ ] Model criado com validações
- [ ] Repository criado
- [ ] Service criado com todos os métodos CRUD
- [ ] Controller criado com todos os endpoints
- [ ] Exception Handler configurado
- [ ] Application.properties configurado
- [ ] Aplicação inicia sem erros
- [ ] Todos os endpoints funcionam
- [ ] Validações funcionam corretamente
- [ ] Tratamento de erros funciona

---

## 🎉 Parabéns!

Você criou uma API REST completa com Spring Boot! 

Este é um projeto base que pode ser expandido com:
- Autenticação e autorização
- Testes automatizados
- Documentação da API (Swagger)
- Integração com outros serviços
- Deploy em produção

**Continue praticando e explorando o Spring Boot!** 🚀

---

## 📞 Suporte

Se tiver dúvidas durante o desenvolvimento:

1. Consulte a documentação oficial
2. Pesquise no Stack Overflow
3. Revise este guia
4. Peça ajuda ao professor/instrutor

**Boa sorte com seu projeto!** 💪

