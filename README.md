# 🍔 Sistema de Gestão de Restaurante - Recibos Digitais

[![Java](https://img.shields.io/badge/Java-21+-orange.svg)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

> Sistema completo para gestão de restaurante com geração automática de recibos/notinhas digitais, similar aos sistemas de McDonald's e Burger King.

---

## 📋 Sumário Completo

### 📖 **Sobre o Projeto**
- [🎯 Visão Geral](#-visão-geral)
- [🏗️ Arquitetura do Sistema](#️-arquitetura-do-sistema)
- [📊 Organograma das Classes](#-organograma-das-classes)
- [✨ Funcionalidades Detalhadas](#-funcionalidades-detalhadas)

### 🚀 **Instalação e Uso**
- [⚡ Instalação e Execução](#-instalação-e-execução)
- [🖥️ Guia de Testes](#️-guia-de-testes)
- [🔄 Fluxo de Funcionamento](#-fluxo-de-funcionamento)

### 📁 **Estrutura Técnica**
- [📂 Estrutura do Projeto](#-estrutura-do-projeto)
- [🔧 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [💾 Banco de Dados](#-banco-de-dados)
- [📡 APIs REST](#-apis-rest)

### 🛠️ **Suporte e Manutenção**
- [🛠️ Troubleshooting](#️-troubleshooting)
- [📝 Versionamento Git](#-versionamento-git)
- [🎯 Roadmap e Próximos Passos](#-roadmap-e-próximos-passos)
- [📞 Suporte e Contribuição](#-suporte-e-contribuição)
- [📝 Licença e Direitos Autorais](#-licença-e-direitos-autorais)

---

## 🎯 Visão Geral

### 🏪 **O Que é o Sistema**

Este sistema implementa uma solução completa para **gestão de restaurantes** com foco na experiência do cliente através de um sistema de recibos/notinhas digitais inovador.

### 🎯 **Problema Resolvido**

| Usuário | Problema Atual | Solução Proposta |
|---|---|---|
| **🍔 Cliente** | Espera em filas, dependência de atendente | Pedido self-service, recibo imediato |
| **👨‍🍳 Funcionário** | Gestão manual de cardápio, controle de vendas | Sistema automatizado de gestão |
| **🏪 Restaurante** | Ineficiência operacional, baixa produtividade | Processo otimizado e digital |

### 💡 **Solução Inovadora**

Sistema com **duas interfaces completamente separadas**:

#### 🍔 **Interface do Cliente**
- **Self-service completo**: Cliente faz pedido independente
- **Carrinho inteligente**: Seleção visual de produtos
- **Recibo instantâneo**: Número único gerado automaticamente
- **Consulta posterior**: Cliente pode verificar pedido usando número

#### 👨‍🍳 **Interface do Funcionário**
- **Gestão de cardápio**: CRUD completo de produtos
- **Controle de preços**: Preços em centavos para precisão
- **Interface administrativa**: Fácil gerenciamento

### 🎲 **Sistema de Recibos Inteligente**

| Característica | Descrição | Benefício |
|---|---|---|
| **📋 Números Únicos** | 4 dígitos (0000-9999) gerados aleatoriamente | Identificação única e segura |
| **🔍 Consulta Posterior** | Cliente consulta pedido usando número | Acompanhamento pós-compra |
| **📱 Experiência Similar** | Como McDonald's, Burger King | Familiaridade do usuário |
| **⚡ Geração Instantânea** | Recibo criado em segundos | Sem espera |

---

## 🏗️ Arquitetura do Sistema

### 🏛️ **Padrão Arquitetural: Clean Architecture**

```
┌─────────────────────────────────────────────────────────┐
│                    🎨 FRONTEND                          │
│  ┌───────────────────────────────────────────────────┐  │
│  │ 🍔 cliente.html     👨‍🍳 funcionario.html        │  │
│  │ (Pedidos)           (Gestão)                      │  │
└──┼───────────────────────────────────────────────────┼──┘
   │                    🌐 CONTROLLERS                    │
   │  ┌───────────────────────────────────────────────────┐
   │  │ ProductController    ReciboController            │
   │  │ (CRUD Produtos)      (Sistema Recibos)           │
   └─┬───────────────────────────────────────────────────┘
     │                    ⚙️ SERVICES                      │
     │  ┌───────────────────────────────────────────────────┐
     │  │ ProductService       ReciboService               │
     │  │ (Regras Produtos)    (Lógica Recibos)            │
     └─┬───────────────────────────────────────────────────┘
       │                    💾 REPOSITORIES                 │
       │  ┌───────────────────────────────────────────────────┐
       │  │ ProductRepository   ReciboRepository            │
       │  │ (Acesso BD Prod.)   (Acesso BD Recibos)         │
       └─┬───────────────────────────────────────────────────┘
         │                    🏛️ DOMAIN/MODEL                 │
         │  ┌───────────────────────────────────────────────────┐
         │  │ Product            Recibo + ItemCompra          │
         │  │ (Entidade Produto) (Entidade Recibo)            │
         └─┬───────────────────────────────────────────────────┘
           │                    🗄️ DATABASE                     │
           │  ┌───────────────────────────────────────────────────┐
           │  │ H2 Database (Memória)                          │
           │  │ Tabelas: products, recibos, recibo_itens      │
           └───────────────────────────────────────────────────┘
```

### 🔄 **Fluxo de Dados**

```
🍔 CLIENTE → Interface Web → 🌐 Controller → ⚙️ Service → 💾 Repository → 🗄️ Database
                                                                 ↓
👨‍🍳 FUNCIONÁRIO ← Interface Web ← 🌐 Controller ← ⚙️ Service ← 💾 Repository ← 🗄️ Database
```

### 📦 **Componentes Principais**

| Camada | Responsabilidade | Tecnologias |
|---|---|---|
| **Frontend** | Interfaces usuário | HTML5, CSS3, JavaScript |
| **Controller** | APIs REST, validações | Spring MVC, Bean Validation |
| **Service** | Regras negócio, lógica | Spring Service, Java |
| **Repository** | Acesso dados | Spring Data JPA |
| **Model** | Entidades domínio | JPA/Hibernate |
| **Database** | Persistência | H2 (desenvolvimento) |

---

## 📊 Organograma das Classes

### 🏗️ **Diagrama de Classes**

```
┌─────────────────────────────────────────────────────────┐
│                    📦 MODEL                             │
├─────────────────────────────────────────────────────────┤
│  ┌───────────────────────────────────────────────────┐  │
│  │                🏛️ Product                       │  │
│  │  ┌─────────────────────────────────────────────┐  │  │
│  │  │ @Entity @Table(name="products")            │  │  │
│  │  │ + id: Long                                │  │  │
│  │  │ + name: String                            │  │  │
│  │  │ + priceInCents: Integer                   │  │  │
│  │  └─────────────────────────────────────────────┘  │  │
│  │                                                   │  │
│  │  ┌─────────────────────────────────────────────┐  │  │
│  │  │              🧾 Recibo                      │  │  │
│  │  │ @Entity @Table(name="recibos")             │  │  │
│  │  │ + id: Long                                │  │  │
│  │  │ + numeroChamada: String                   │  │  │
│  │  │ + dataCriacao: LocalDateTime              │  │  │
│  │  │ + observacoes: String                     │  │  │
│  │  │ + formaPagamento: String                  │  │  │
│  │  │ + total: Integer                          │  │  │
│  │  │ + itens: List<ItemCompra>                 │  │  │
│  │  │                                           │  │  │
│  │  │  ┌─────────────────────────────────────┐  │  │  │
│  │  │  │       📋 ItemCompra (Embeddable)   │  │  │  │
│  │  │  │ + nome: String                      │  │  │  │
│  │  │  │ + quantidade: Integer               │  │  │  │
│  │  │  │ + preco: Integer                    │  │  │  │
│  │  │  └─────────────────────────────────────┘  │  │  │
│  │  └─────────────────────────────────────────────┘  │  │
└─┼───────────────────────────────────────────────────┼──┘
  │                                                   │
  │                    💾 REPOSITORY                    │
  │  ┌───────────────────────────────────────────────────┐
  │  │  ┌─────────────────────────────────────────────┐  │
  │  │  │      📦 ProductRepository                  │  │
  │  │  │ extends JpaRepository<Product, Long>       │  │
  │  │  │ + Métodos CRUD automáticos                 │  │
  │  │  └─────────────────────────────────────────────┘  │
  │  │                                                   │
  │  │  ┌─────────────────────────────────────────────┐  │
  │  │  │      🧾 ReciboRepository                   │  │
  │  │  │ extends JpaRepository<Recibo, Long>        │  │
  │  │  │ + findByNumeroChamada(String)              │  │
  │  │  └─────────────────────────────────────────────┘  │
  └─┼───────────────────────────────────────────────────┼──┘
    │                                                   │
    │                    ⚙️ SERVICE                       │
    │  ┌───────────────────────────────────────────────────┐
    │  │  ┌─────────────────────────────────────────────┐  │
    │  │  │      📦 ProductService                     │  │
    │  │  │ @Service                                  │  │
    │  │  │ + createProduct(Product)                  │  │
    │  │  │ + getAllProducts(): List<Product>         │  │
    │  │  │ + getProductById(Long): Product           │  │
    │  │  │ + updateProduct(Long, Product): Product   │  │
    │  │  │ + deleteProduct(Long)                     │  │
    │  │  └─────────────────────────────────────────────┘  │
    │  │                                                   │
    │  │  ┌─────────────────────────────────────────────┐  │
    │  │  │      🧾 ReciboService                      │  │
    │  │  │ @Service                                  │  │
    │  │  │ + createRecibo(List<Item>, String, String)│  │
    │  │  │ + getAllRecibos(): List<Recibo>            │  │
    │  │  │ + getReciboById(Long): Recibo              │  │
    │  │  │ + getReciboByNumeroChamada(String): Recibo │  │
    │  │  └─────────────────────────────────────────────┘  │
    └─┼───────────────────────────────────────────────────┼──┘
      │                                                   │
      │                    🌐 CONTROLLER                    │
      │  ┌───────────────────────────────────────────────────┐
      │  │  ┌─────────────────────────────────────────────┐  │
      │  │  │    📦 ProductController                    │  │
      │  │  │ @RestController                            │  │
      │  │  │ @RequestMapping("/products")              │  │
      │  │  │ + POST /products                          │  │
      │  │  │ + GET /products                           │  │
      │  │  │ + GET /products/{id}                      │  │
      │  │  │ + PUT /products/{id}                      │  │
      │  │  │ + DELETE /products/{id}                   │  │
      │  │  └─────────────────────────────────────────────┘  │
      │  │                                                   │
      │  │  ┌─────────────────────────────────────────────┐  │
      │  │  │    🧾 ReciboController                     │  │
      │  │  │ @RestController                            │  │
      │  │  │ @RequestMapping("/recibos")               │  │
      │  │  │ + POST /recibos/pagar                     │  │
      │  │  │ + GET /recibos                            │  │
      │  │  │ + GET /recibos/{id}                       │  │
      │  │  │ + GET /recibos/chamada/{numero}           │  │
      │  │  └─────────────────────────────────────────────┘  │
      └───────────────────────────────────────────────────┘
```

### 📋 **Legenda dos Relacionamentos**

| Símbolo | Significado |
|---|---|
| **→** | Dependência/Injeção |
| **⟷** | Comunicação bidirecional |
| **↕️** | Fluxo de dados |
| **🔗** | Relacionamento JPA |

### 🔄 **Fluxo de Dependências**

```
🌐 Controller → ⚙️ Service → 💾 Repository → 🏛️ Model → 🗄️ Database
```

---

## 🎯 Visão Geral

Este projeto implementa um **sistema completo de gestão para restaurantes** com foco na experiência do cliente através de recibos/notinhas digitais.

### 🏗️ Arquitetura Principal

O sistema é dividido em duas funcionalidades core que trabalham em conjunto:

#### 1. **📦 CRUD de Produtos**
Gerenciamento completo do cardápio do restaurante com operações básicas de manutenção.

#### 2. **🧾 Sistema de Recibos**
Geração automática de recibos digitais com números de chamada únicos, proporcionando uma experiência similar aos supermercados.

---

## ✨ Funcionalidades Detalhadas

### 🎯 **Módulos do Sistema**

#### 👨‍🍳 **1. Gestão Administrativa (Funcionário)**

| Funcionalidade | Descrição | Endpoint | Status |
|---|---|---|---|
| **➕ Criar Produto** | Adicionar novo item ao cardápio | `POST /products` | ✅ Completo |
| **📋 Listar Produtos** | Visualizar todos os produtos | `GET /products` | ✅ Completo |
| **🔍 Buscar Produto** | Localizar produto específico | `GET /products/{id}` | ✅ Completo |
| **✏️ Editar Produto** | Atualizar dados do produto | `PUT /products/{id}` | ✅ Completo |
| **🗑️ Excluir Produto** | Remover produto do cardápio | `DELETE /products/{id}` | ✅ Completo |
| **💰 Controle de Preços** | Preços em centavos (precisão) | - | ✅ Completo |

#### 🍔 **2. Sistema de Pedidos (Cliente)**

| Funcionalidade | Descrição | Endpoint | Status |
|---|---|---|---|
| **🛒 Carrinho Interativo** | Seleção visual de produtos | Interface Web | ✅ Completo |
| **🔢 Controle de Quantidade** | Ajuste de quantidades (+/-) | Interface Web | ✅ Completo |
| **📝 Observações** | Instruções especiais do pedido | Interface Web | ✅ Completo |
| **💳 Formas de Pagamento** | Dinheiro/Cartão/Pix | Interface Web | ✅ Completo |
| **🎫 Geração de Recibo** | Recibo com número único | `POST /recibos/pagar` | ✅ Completo |
| **🖨️ Impressão** | Recibo pronto para impressão | Interface Web | ✅ Completo |

#### 🔧 **3. Sistema Core (Backend)**

| Funcionalidade | Descrição | Status |
|---|---|---|
| **🎲 Números Aleatórios** | Geração automática de 4 dígitos | ✅ Completo |
| **📊 APIs REST** | Endpoints completos e documentados | ✅ Completo |
| **💾 Persistência** | Banco H2 com JPA/Hibernate | ✅ Completo |
| **🛡️ Validações** | Bean Validation automática | ✅ Completo |
| **⚠️ Tratamento de Erros** | Respostas HTTP padronizadas | ✅ Completo |
| **📱 Interface Responsiva** | Funciona em desktop/mobile | ✅ Completo |

### 🔄 **Fluxo Completo de Funcionamento**

```
┌─────────────────────────────────────────────────────────────────┐
│                   🏪 RESTAURANTE - FLUXO COMPLETO                 │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  👨‍🍳 FUNCIONÁRIO:                                             │
│  1. Acessa http://localhost:8080/funcionario.html              │
│  2. Cadastra produtos no cardápio                              │
│  3. Gerencia preços e disponibilidade                         │
│                                                                 │
│  🍔 CLIENTE:                                                   │
│  1. Acessa http://localhost:8080/cliente.html                  │
│  2. Navega pelo cardápio disponível                           │
│  3. Adiciona produtos ao carrinho (+/- quantidades)           │
│  4. Adiciona observações especiais                             │
│  5. Escolhe forma de pagamento                                 │
│  6. Clica em "Fazer Pedido"                                    │
│                                                                 │
│  🎫 SISTEMA:                                                   │
│  1. Valida carrinho (não vazio)                                │
│  2. Gera número único de 4 dígitos (ex: 7421)                 │
│  3. Salva recibo no banco de dados                            │
│  4. Mostra modal com recibo completo                          │
│  5. Oferece opção de impressão                                │
│                                                                 │
│  📋 RESULTADO:                                                 │
│  • Cliente recebe número de chamada (7421)                     │
│  • Funcionário pode consultar pedido posteriormente            │
│  • Sistema mantém histórico completo de vendas                 │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

### 🎨 **Características Técnicas Avançadas**

| Aspecto | Implementação | Benefício |
|---|---|---|
| **📱 Responsividade** | CSS Grid/Flexbox + Media Queries | Funciona em todos dispositivos |
| **🎯 UX Moderna** | Design intuitivo com feedback visual | Experiência agradável |
| **⚡ Performance** | Spring Boot + H2 (memória) | Inicialização rápida |
| **🛡️ Segurança** | Validações server-side + sanitização | Proteção contra dados inválidos |
| **🔄 Real-time** | JavaScript assíncrono + APIs REST | Atualização dinâmica |
| **📊 Escalabilidade** | Arquitetura em camadas | Fácil manutenção e expansão |

---

## 🚀 Instalação e Execução

### 📋 Pré-requisitos do Sistema

| Requisito | Versão Mínima | Download | Verificação |
|---|---|---|---|
| **Java** | 21+ | [OpenJDK](https://openjdk.java.net/) | `java -version` |
| **Maven** | 3.9+ | [Maven](https://maven.apache.org/) | `mvn -version` |
| **Git** | 2.x+ | [Git](https://git-scm.com/) | `git --version` |
| **Navegador** | Moderno | Chrome/Firefox/Edge | - |

### ⚡ **Instalação em 3 Passos**

#### **Passo 1: Clonar o Repositório**
```bash
# Clone o projeto
git clone https://github.com/seu-usuario/sistema-gestao-senhor-leao.git

# Entre no diretório
cd sistema-gestao-senhor-leao
```

#### **Passo 2: Executar a Aplicação**
```bash
# Windows (PowerShell/Command Prompt)
.\mvnw.cmd spring-boot:run

# Linux/Mac (Terminal)
./mvnw spring-boot:run

# Ou usando Maven direto (se instalado)
mvn spring-boot:run
```

#### **Passo 3: Verificar Inicialização**
Aguarde até aparecer no console:
```
Started ProjetoTestApplication in 6.179 seconds
```
✅ **Aplicação iniciada com sucesso na porta 8080!**

### 🌐 **Acesso às Interfaces**

| Interface | URL | Descrição | Público |
|---|---|---|---|
| **🍔 Área do Cliente** | `http://localhost:8080/cliente.html` | Fazer pedidos e receber recibo | ✅ Aberto |
| **👨‍🍳 Área do Funcionário** | `http://localhost:8080/funcionario.html` | Gerenciar produtos/cardápio | ✅ Aberto |
| **🧪 Testes de Desenvolvimento** | `http://localhost:8080/index.html` | CRUD básico para testes | ✅ Aberto |
| **🗄️ Console do Banco H2** | `http://localhost:8080/h2-console` | Interface do banco | 🔒 Desenvolvimento |

### 🔍 **Verificação de Funcionamento**

#### **Teste 1: Interface do Funcionário**
```bash
# Abrir navegador e acessar
start http://localhost:8080/funcionario.html
```

#### **Teste 2: API de Produtos**
```bash
# Verificar se API responde
curl -s http://localhost:8080/products | jq .
# Deve retornar: []
```

#### **Teste 3: Interface do Cliente**
```bash
# Abrir navegador e acessar
start http://localhost:8080/cliente.html
```

### 🛠️ **Solução de Problemas**

| Problema | Sintomas | Solução |
|---|---|---|
| **Porta 8080 ocupada** | "Port already in use" | `netstat -ano | findstr :8080` e matar processo |
| **Java não encontrado** | "java command not found" | Instalar Java 21+ e configurar PATH |
| **Maven não encontrado** | "mvn command not found" | Usar Maven Wrapper (`./mvnw.cmd`) |
| **Página não carrega** | Erro 404/500 | Verificar se aplicação está rodando |

### 📊 **Monitoramento**

#### **Logs da Aplicação**
```bash
# Ver logs em tempo real
tail -f logs/spring.log

# Ou verificar no console onde executou
```

#### **Status da Aplicação**
```bash
# Verificar processos Java
ps aux | grep java

# Windows
tasklist | findstr java
```

---

## 🖥️ Guia de Testes

### 🎮 Teste Rápido (5 minutos)

#### 1. **Configure o Cardápio (Funcionário)**
```
👨‍🍳 http://localhost:8080/funcionario.html
```

#### 2. **Faça seu Pedido (Cliente)**
```
🍔 http://localhost:8080/cliente.html
```

#### 2. **Fluxo Completo de Teste**

##### 👨‍🍳 **FASE 1: Configurar Cardápio**
| Passo | Ação | Resultado Esperado |
|---|---|---|
| 1 | Clicar aba **"Gerenciar Produtos"** | Interface de produtos carregada |
| 2 | Cadastrar produto:<br>• Nome: `Hambúrguer`<br>• Preço: `1500`<br>• Clicar "Cadastrar" | Produto adicionado à lista |
| 3 | Cadastrar produto:<br>• Nome: `Refrigerante`<br>• Preço: `500`<br>• Clicar "Cadastrar" | Segundo produto adicionado |
| 4 | Cadastrar produto:<br>• Nome: `Batata Frita`<br>• Preço: `800`<br>• Clicar "Cadastrar" | Cardápio completo |

##### 🛒 **FASE 2: Fazer Pedido**
| Passo | Ação | Resultado Esperado |
|---|---|---|
| 1 | Clicar aba **"Gerar Recibos"** | Interface de pedidos carregada |
| 2 | Clicar em cada produto uma vez | Produtos adicionados ao carrinho |
| 3 | Adicionar observação:<br>`"Sem cebola, entregar gelado"` | Observação salva |
| 4 | Selecionar **"Cartão"** como pagamento | Forma de pagamento definida |
| 5 | Clicar **"Gerar Recibo"** | Recibo criado com sucesso |

##### 🧾 **FASE 3: Verificar Recibo**
```
┌─────────────────────────────────────┐
│           RECIBO #1234              │
├─────────────────────────────────────┤
│ Data: 2025-12-05 14:30              │
│                                     │
│ 🛒 Itens:                           │
│ • Hambúrguer     x1 = R$ 15,00      │
│ • Refrigerante   x1 = R$ 5,00       │
│ • Batata Frita   x1 = R$ 8,00       │
│                                     │
│ 💰 Total: R$ 28,00                  │
│ 💳 Pagamento: Cartão                │
│ 📝 Obs: Sem cebola, entregar gelado │
└─────────────────────────────────────┘
```

##### 📊 **FASE 4: Consultar Histórico**
| Passo | Ação | Resultado Esperado |
|---|---|---|
| 1 | Clicar aba **"Histórico de Recibos"** | Interface de histórico carregada |
| 2 | Clicar **"Carregar Recibos"** | Lista de recibos exibida |
| 3 | Clicar em um recibo | Detalhes expandidos |
| 4 | **Anotar o número (#1234)** | Número da notinha para consultas futuras |

### 🧪 Testes Avançados

#### 🔗 **Via API REST** (Postman/Insomnia/Thunder Client)

##### **📦 Endpoints de Produtos**
```http
# Listar todos os produtos
GET http://localhost:8080/products

# Criar novo produto
POST http://localhost:8080/products
Content-Type: application/json

{
  "name": "Sorvete",
  "priceInCents": 600
}

# Buscar produto específico
GET http://localhost:8080/products/1

# Atualizar produto
PUT http://localhost:8080/products/1
Content-Type: application/json

{
  "name": "Sorvete Atualizado",
  "priceInCents": 700
}

# Deletar produto
DELETE http://localhost:8080/products/1
```

##### **🧾 Endpoints de Recibos**
```http
# Gerar novo recibo
POST http://localhost:8080/recibos/pagar
Content-Type: application/json

{
  "itens": [
    {
      "nome": "Hambúrguer",
      "quantidade": 2,
      "preco": 1500
    },
    {
      "nome": "Refrigerante",
      "quantidade": 1,
      "preco": 500
    }
  ],
  "observacoes": "Sem salada, gelado",
  "formaPagamento": "Cartão"
}

# Listar todos os recibos
GET http://localhost:8080/recibos

# Buscar recibo por ID
GET http://localhost:8080/recibos/1

# Buscar por número de chamada (notinha)
GET http://localhost:8080/recibos/chamada/1234

# Limpar histórico (desenvolvimento)
DELETE http://localhost:8080/recibos/limpar
```

#### 🎨 **Interface Alternativa**
```
🧪 http://localhost:8080/index.html
```
> Interface básica para testes simples de CRUD sem carrinho

---

## 🔄 Fluxo de Funcionamento

### 📋 **Cenário Completo de Uso**

Imagine que você está em um restaurante moderno:

#### **👨‍🍳 Cenário 1: Funcionário Configurando o Sistema**

```
🏪 RESTAURANTE ABRE AS PORTAS

👨‍🍳 João (Funcionário):
1. Liga o computador do caixa
2. Abre navegador e vai para: http://localhost:8080/funcionario.html
3. Cadastra produtos do dia:
   - Hambúrguer R$ 15,00
   - Refrigerante R$ 5,00
   - Batata Frita R$ 8,00
   - Sorvete R$ 6,00
4. Ajusta preços se necessário
5. Sistema fica pronto para receber pedidos
```

#### **🍔 Cenário 2: Cliente Fazendo Pedido**

```
🍔 Maria (Cliente) chega ao restaurante:

1. 📱 Pede tablet/kiosk ao funcionário
2. 🌐 Acessa: http://localhost:8080/cliente.html
3. 🍽️ Navega pelo cardápio na tela
4. 🛒 Adiciona produtos ao carrinho:
   - Hambúrguer (2 unidades)
   - Refrigerante (1 unidade)
   - Batata Frita (1 unidade)
5. 📝 Adiciona observação: "Sem cebola na batata"
6. 💳 Escolhe pagamento: "Cartão"
7. 🚀 Clica "Fazer Pedido"
```

#### **🎫 Cenário 3: Sistema Processa Pedido**

```
⚙️ SISTEMA (automático):

1. ✅ Valida carrinho (não vazio)
2. 🎲 Gera número único: "7421"
3. 💰 Calcula total: R$ 43,00
4. 💾 Salva no banco de dados
5. 🖨️ Mostra recibo na tela
6. 📢 Instruções: "Anote seu número 7421 e aguarde ser chamado"
```

#### **🏃 Cenário 4: Cliente Aguarda Pedido**

```
🍔 Maria anota o número 7421 e senta à mesa

⏰ Alguns minutos depois...
📢 "Pedido 7421, pedido pronto no balcão!"

🍔 Maria vai ao balcão e pega seu pedido
```

#### **👨‍🍳 Cenário 5: Funcionário Consulta (Opcional)**

```
👨‍🍳 João pode consultar detalhes do pedido:
- GET /recibos/chamada/7421
- Ver detalhes completos
- Confirmar itens e observações
```

### 🎯 **Benefícios do Sistema**

| Benefício | Para Cliente | Para Restaurante |
|---|---|---|
| **⚡ Velocidade** | Pedido em 30 segundos | Atendimento mais rápido |
| **🎯 Precisão** | Observações registradas | Menos erros nos pedidos |
| **📊 Controle** | Histórico de pedidos | Dados para gestão |
| **💰 Eficiência** | Sem filas desnecessárias | Otimização operacional |
| **📱 Moderno** | Experiência digital | Imagem inovadora |

### 🔄 **Fluxo Técnico Detalhado**

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   🍔 CLIENTE    │────│ 🌐 INTERFACE    │────│ ⚙️ BACKEND      │
│                 │    │ WEB (Frontend) │    │ (Spring Boot)   │
│ 1. Seleciona    │    │                 │    │                 │
│    produtos     │    │ 2. Processa    │    │ 3. Valida dados │
│                 │    │    pedido      │    │                 │
│ 2. Adiciona     │    │                 │    │ 4. Gera número │
│    observações  │    │ 3. Envia para  │────│    único        │
│                 │    │    API         │    │                 │
│ 3. Escolhe      │    │                 │    │ 5. Calcula     │
│    pagamento    │    │                 │    │    total        │
│                 │    │                 │    │                 │
│ 4. Clica        │    │                 │    │ 6. Salva no    │
│    "Fazer       │    │                 │    │    banco        │
│     Pedido"     │    │                 │    │                 │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                                                       │
┌─────────────────┐    ┌─────────────────┐             │
│   🗄️ DATABASE   │    │   📊 MONITOR   │             │
│   (H2/Postgre)  │    │   (Logs)       │             │
│                 │    │                 │             │
│ • Tabela        │    │ • Pedidos       │◄────────────┘
│   products      │    │   processados   │
│ • Tabela        │    │ • Performance   │
│   recibos       │    │ • Erros         │
│ • Tabela        │    │                 │
│   recibo_itens  │    └─────────────────┘
└─────────────────┘
```

### 🎪 **Casos de Uso Especiais**

#### **Cliente Volta para Consultar**
```bash
# Cliente esqueceu detalhes do pedido
GET /recibos/chamada/7421
# Sistema retorna todos os detalhes
```

#### **Funcionário Verifica Status**
```bash
# Funcionário quer ver pedidos pendentes
GET /recibos
# Lista todos os recibos do dia
```

#### **Cliente com Pedido Complexo**
```
Observações: "Hambúrguer sem salada, batata extra crocante,
refrigerante sem gelo, entregar na mesa 15"
```
✅ **Sistema registra tudo automaticamente!**

#### **Restaurante Fecha o Expediente**
```bash
# Limpar dados de desenvolvimento
DELETE /recibos/limpar
# Pronto para próximo dia
```

### 🌟 **Diferencial Competitivo**

Este sistema oferece uma **experiência premium** comparada a soluções tradicionais:

| Aspecto | Sistema Tradicional | Nosso Sistema |
|---|---|---|
| **Velocidade** | 3-5 minutos por pedido | 30 segundos |
| **Precisão** | Erros manuais frequentes | 100% digital |
| **Escalabilidade** | Limitado por funcionários | Ilimitado |
| **Custo** | Alto (treinamento/staff) | Baixo (software único) |
| **Experiência** | Tradicional | Moderna e inovadora |
| **Dados** | Sem controle | Analytics completos |

---

## 📁 Estrutura do Projeto

### 🏗️ Arquitetura Geral

```
📁 sistema-gestao-senhor-leao/
│
├── 📄 📋 README.md                        # Documentação completa
├── 📄 ⚙️ pom.xml                          # Configurações Maven
├── 📄 🚀 mvnw & mvnw.cmd                  # Maven Wrapper
├── 📄 🔒 .gitignore                       # Controle de versão
│
├── 📁 🔧 .mvn/wrapper/                    # Maven Wrapper
│   └── 📄 maven-wrapper.properties
│
└── 📁 💻 src/main/java/com/example/projeto_test/
    │
    ├── 📄 🚀 ProjetoTestApplication.java  # Ponto de entrada Spring Boot
    │
    ├── 📁 🌐 controller/                  # Camada de Apresentação
    │   ├── 📄 📦 ProductController.java   # API REST Produtos
    │   ├── 📄 🧾 ReciboController.java    # API REST Recibos
    │   └── 📄 ⚠️ GlobalExceptionHandler.java # Tratamento de Erros
    │
    ├── 📁 🏛️ model/                       # Camada de Domínio
    │   ├── 📄 📦 Product.java             # Entidade Produto
    │   └── 📄 🧾 Recibo.java              # Entidade Recibo + ItemCompra
    │
    ├── 📁 💾 repository/                  # Camada de Persistência
    │   ├── 📄 📦 ProductRepository.java   # Acesso BD Produtos
    │   └── 📄 🧾 ReciboRepository.java    # Acesso BD Recibos
    │
    ├── 📁 ⚙️ service/                     # Camada de Negócio
    │   ├── 📄 📦 ProductService.java      # Regras Produtos
    │   └── 📄 🧾 ReciboService.java       # Regras Recibos
    │
    └── 📁 🎨 resources/
        ├── 📄 ⚙️ application.properties   # Configurações Spring
        │
        └── 📁 🌐 static/                  # Interface Web
            ├── 📄 🧪 index.html           # Testes CRUD Básicos
            ├── 📄 🏪 recibos.html         # Sistema Completo
            ├── 📄 👤 cliente.html         # Interface Cliente (legado)
            └── 📄 👨‍🍳 funcionario.html     # Interface Funcionário (legado)
```

### 📊 Arquitetura em Camadas (Clean Architecture)

```
┌─────────────────────────────────────┐
│        🎨 INTERFACE WEB             │ ← HTML/CSS/JS
│        🌐 CONTROLLER                │ ← REST APIs
├─────────────────────────────────────┤
│        ⚙️ SERVICE LAYER             │ ← Regras de Negócio
├─────────────────────────────────────┤
│        💾 REPOSITORY LAYER          │ ← Acesso a Dados
├─────────────────────────────────────┤
│        🏛️ MODEL/DOMAIN LAYER        │ ← Entidades JPA
├─────────────────────────────────────┤
│        🗄️ DATABASE LAYER            │ ← H2/PostgreSQL
└─────────────────────────────────────┘
```

### 📂 Descrição dos Diretórios

| Diretório | Responsabilidade | Exemplos |
|---|---|---|
| **controller/** | APIs REST, validações básicas | Endpoints HTTP, DTOs |
| **service/** | Regras de negócio, lógica complexa | Cálculos, validações avançadas |
| **repository/** | Acesso ao banco de dados | Queries JPA, CRUD básico |
| **model/** | Entidades de domínio | `@Entity`, relacionamentos |
| **resources/** | Configurações, arquivos estáticos | `application.properties`, HTML |
| **static/** | Frontend da aplicação | Interfaces web, assets |

---

## 🔧 Tecnologias Utilizadas

| Componente | Tecnologia | Versão | Descrição |
|---|---|---|---|
| **Backend** | Spring Boot | 3.5.7 | Framework web Java |
| **Linguagem** | Java | 21+ | OpenJDK |
| **Banco** | H2 Database | - | Banco em memória |
| **ORM** | Hibernate/JPA | - | Mapeamento objeto-relacional |
| **Frontend** | HTML5/CSS3/JS | - | Vanilla (sem frameworks) |
| **Build** | Maven | 3.9+ | Gerenciamento de dependências |
| **Validação** | Bean Validation | - | Validações de dados |

---

## 📡 APIs REST

### 📦 **Endpoints de Produtos**

| Método | Endpoint | Descrição | Status Code |
|---|---|---|---|
| `GET` | `/products` | Lista todos os produtos | 200 OK |
| `GET` | `/products/{id}` | Busca produto específico | 200 OK / 404 Not Found |
| `POST` | `/products` | Cria novo produto | 201 Created / 400 Bad Request |
| `PUT` | `/products/{id}` | Atualiza produto existente | 200 OK / 404 Not Found |
| `DELETE` | `/products/{id}` | Remove produto | 204 No Content / 404 Not Found |

**📝 Corpo da Requisição (POST/PUT):**
```json
{
  "name": "Hambúrguer",
  "priceInCents": 1500
}
```

### 🧾 **Endpoints de Recibos**

| Método | Endpoint | Descrição | Status Code |
|---|---|---|---|
| `GET` | `/recibos` | Lista todos os recibos | 200 OK |
| `GET` | `/recibos/{id}` | Busca recibo por ID | 200 OK / 404 Not Found |
| `GET` | `/recibos/chamada/{numero}` | Busca por número da notinha | 200 OK / 404 Not Found |
| `POST` | `/recibos/pagar` | Gera novo recibo | 201 Created / 400 Bad Request |
| `DELETE` | `/recibos/limpar` | Limpa histórico (desenvolvimento) | 200 OK |

### 🎯 **Fluxo de Uso do Sistema**

#### 📋 **Fluxo Completo (Funcionário + Cliente)**

```
1. 👨‍🍳 FUNCIONÁRIO configura produtos → 2. 🍔 CLIENTE faz pedido → 3. 🧾 Recebe recibo com número único
```

**Passo 1 - Funcionário configura cardápio:**
```
http://localhost:8080/funcionario.html
├── Adiciona produtos (Hambúrguer, Refrigerante, etc.)
├── Define preços
└── Mantém cardápio atualizado
```

**Passo 2 - Cliente faz pedido:**
```
http://localhost:8080/cliente.html
├── Seleciona produtos disponíveis
├── Adiciona quantidades
├── Inclui observações especiais
├── Escolhe forma de pagamento
└── Recebe recibo com número único
```

**Resultado:** Sistema similar ao McDonald's/Burger King com números de chamada!

### 🎯 **Exemplo Completo: Gerar Recibo**

**📤 Requisição:**
```http
POST http://localhost:8080/recibos/pagar
Content-Type: application/json

{
  "itens": [
    {
      "nome": "Hambúrguer",
      "quantidade": 2,
      "preco": 1500
    },
    {
      "nome": "Refrigerante",
      "quantidade": 1,
      "preco": 500
    }
  ],
  "observacoes": "Sem salada, gelado",
  "formaPagamento": "Cartão"
}
```

**📥 Resposta (201 Created):**
```json
{
  "id": 1,
  "numeroChamada": "7421",
  "dataCriacao": "2025-12-05T14:30:25.123456",
  "observacoes": "Sem salada, gelado",
  "formaPagamento": "Cartão",
  "total": 3500,
  "itens": [
    {
      "nome": "Hambúrguer",
      "quantidade": 2,
      "preco": 1500,
      "subtotal": 3000
    },
    {
      "nome": "Refrigerante",
      "quantidade": 1,
      "preco": 500,
      "subtotal": 500
    }
  ]
}
```

### 🔍 **Códigos de Status HTTP**

| Código | Significado | Quando Usado |
|---|---|---|
| `200 OK` | Sucesso em operações GET/PUT | Dados retornados com sucesso |
| `201 Created` | Recurso criado | Produto/recibo criado |
| `204 No Content` | Sucesso sem conteúdo | DELETE executado |
| `400 Bad Request` | Dados inválidos | Validação falhou |
| `404 Not Found` | Recurso não encontrado | ID não existe |

### 🧪 **Testando com cURL**

```bash
# Criar produto
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Pizza","priceInCents":2000}'

# Gerar recibo
curl -X POST http://localhost:8080/recibos/pagar \
  -H "Content-Type: application/json" \
  -d '{
    "itens":[{"nome":"Pizza","quantidade":1,"preco":2000}],
    "observacoes":"Bem passada",
    "formaPagamento":"Dinheiro"
  }'
```

---

## 💾 Banco de Dados

### 📊 Configuração H2

| Propriedade | Valor | Descrição |
|---|---|---|
| **Tecnologia** | H2 Database | Banco relacional em memória |
| **Console Web** | `http://localhost:8080/h2-console` | Interface gráfica |
| **JDBC URL** | `jdbc:h2:mem:testdb` | String de conexão |
| **Usuário** | `sa` | System Administrator |
| **Senha** | *(vazio)* | Sem senha |

### 🏗️ Estrutura das Tabelas

As tabelas são criadas automaticamente pelo Hibernate:

```sql
-- Tabela de produtos
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price_in_cents INTEGER NOT NULL
);

-- Tabela de recibos
CREATE TABLE recibos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_chamada VARCHAR(255) UNIQUE,
    data_criacao TIMESTAMP,
    observacoes VARCHAR(255),
    forma_pagamento VARCHAR(255),
    total INTEGER
);

-- Tabela de itens do recibo
CREATE TABLE recibo_itens (
    recibo_id BIGINT NOT NULL,
    nome VARCHAR(255),
    quantidade INTEGER,
    preco INTEGER,
    FOREIGN KEY (recibo_id) REFERENCES recibos(id)
);
```

---

## 📊 Funcionalidades Detalhadas

### Sistema de Recibos

- **Número de Chamada**: Geração automática de 4 dígitos (0000-9999)
- **Data/Hora**: Timestamp automático da criação
- **Cálculo de Total**: Soma automática dos subtotais
- **Itens**: Lista completa com nome, quantidade, preço e subtotal
- **Observações**: Campo opcional para instruções especiais
- **Formas de Pagamento**: Dinheiro, Cartão, Pix

### Interface Web

- **Responsiva**: Funciona em desktop e mobile
- **Intuitiva**: Abas organizadas por funcionalidade
- **Interativa**: Carrinho dinâmico, validações em tempo real
- **Histórico**: Consulta completa de vendas

---

## 🚨 Troubleshooting

| Problema | Sintomas | Solução |
|---|---|---|
| **"localhost se recusou a se conectar"** | Não consegue acessar URLs | 1. Verificar se app está rodando<br>2. Aguardar 10-15s após start<br>3. Verificar porta 8080 livre |
| **"Failed to fetch"** | Erro AJAX no navegador | 1. Recarregar página (F5)<br>2. Verificar app rodando<br>3. Aguardar alguns segundos |
| **Erro de compilação** | Build falhando | ```bash<br>.\mvnw.cmd clean compile<br>``` |
| **Porta 8080 ocupada** | "Port already in use" | Editar `application.properties`:<br>```server.port=8081``` |
| **400 Bad Request** | Validação falhando | Verificar dados enviados (JSON válido, campos obrigatórios) |
| **404 Not Found** | Endpoint não encontrado | Verificar URL e método HTTP correto |

---

## 🚀 Inicialização do Repositório Git

### 1. Inicializar Git (se ainda não foi feito)

```bash
# Verificar se já existe repositório
ls -la .git

# Se não existir, inicializar
git init

# Configurar usuário (opcional, mas recomendado)
git config user.name "Seu Nome"
git config user.email "seu.email@exemplo.com"
```

### 2. Primeiro Commit

```bash
# Verificar status
git status

# Adicionar todos os arquivos
git add .

# Primeiro commit
git commit -m "initial commit: sistema de gestão de restaurante

- CRUD completo de produtos
- Sistema de recibos com números aleatórios
- Interfaces web responsivas
- APIs REST documentadas
- Configurado com H2 Database"
```

### 3. Conectar com Repositório Remoto (Opcional)

```bash
# Criar repositório no GitHub/GitLab/etc
# Depois conectar:
git remote add origin https://github.com/SEU_USUARIO/sistema-gestao-senhor-leao.git

# Enviar para remoto
git push -u origin main
```

---

## 📝 Versionamento Git - O Que Incluir?

### ✅ **Recomendação: Versionar TUDO**

**Por que versionar tudo?**

1. **Sistema Integrado**: Os recibos dependem dos produtos
2. **Projeto Completo**: É um sistema único, não módulos separados
3. **Histórico Completo**: Facilita entender a evolução
4. **Funcionamento Independente**: Qualquer pessoa pode clonar e executar

### 📋 Arquivos Essenciais para Versionar

```bash
# Tudo que está na raiz (exceto target/)
git add .

# Ou especificamente (recomendado):
git add \
  README.md \
  pom.xml \
  .gitignore \
  .gitattributes \
  mvnw* \
  .mvn/ \
  src/ \
  projeto-postgres/  # opcional
```

### 🚫 Arquivos para IGNORAR (.gitignore)

```gitignore
# Já configurado automaticamente
target/
*.log
*.tmp
.vscode/
.idea/
```

### 🔄 Fluxo de Versionamento

```bash
# 1. Verificar status
git status

# 2. Adicionar arquivos
git add .

# 3. Commit com mensagem descritiva
git commit -m "feat: implementa sistema completo de recibos

- Adiciona CRUD de recibos com números aleatórios
- Cria interface web integrada (recibos.html)
- Implementa carrinho de compras interativo
- Adiciona histórico de vendas
- Integra recibos com sistema de produtos existente"

# 4. Enviar para repositório remoto
git push origin main
```

### 📊 Estratégia de Commits

```
feat: implementa sistema completo de recibos
├── ✅ CRUD de produtos (base existente)
├── ✅ Model Recibo com ItemCompra
├── ✅ ReciboService e ReciboRepository
├── ✅ ReciboController com APIs REST
├── ✅ Interface web integrada (recibos.html)
├── ✅ Sistema de carrinho interativo
└── ✅ Histórico e busca por notinha
```

---

## 🎯 Roadmap e Próximos Passos

### 🚀 **Funcionalidades Planejadas (Q1-Q2 2025)**

#### **🔐 Segurança e Autenticação**
- [ ] **Sistema de Login** para funcionários
- [ ] **JWT Tokens** para sessões seguras
- [ ] **Controle de Acesso** baseado em roles
- [ ] **Auditoria** de operações administrativas

#### **📊 Business Intelligence**
- [ ] **Dashboard Executivo** com métricas de vendas
- [ ] **Relatórios de Vendas** por período/data
- [ ] **Análise de Produtos** mais vendidos
- [ ] **Gráficos Interativos** de performance

#### **💳 Integrações de Pagamento**
- [ ] **PagSeguro/Mercado Pago** API integration
- [ ] **QR Code** para pagamentos PIX
- [ ] **Cartão de Crédito** online
- [ ] **Comprovantes Digitais** automáticos

#### **📱 Expansão Mobile**
- [ ] **App Mobile** (React Native/Flutter)
- [ ] **Progressive Web App** (PWA)
- [ ] **Notificações Push** para status do pedido
- [ ] **GPS Integration** para entregas

#### **🤖 Automação e IA**
- [ ] **Chatbot** para atendimento ao cliente
- [ ] **Recomendações** baseadas em histórico
- [ ] **Previsão de Demanda** por produto
- [ ] **Otimização de Cardápio** automática

### 🧪 **Melhorias Técnicas (Q1 2025)**

#### **📚 Documentação e Qualidade**
- [ ] **Swagger/OpenAPI** para APIs
- [ ] **Testes Unitários** (JUnit 5 + Mockito)
- [ ] **Testes de Integração** (TestContainers)
- [ ] **Code Coverage** mínimo 80%

#### **🏗️ Infraestrutura**
- [ ] **Docker** para containerização
- [ ] **Kubernetes** para orquestração
- [ ] **CI/CD Pipeline** (GitHub Actions)
- [ ] **Deploy Cloud** (AWS/Heroku/Vercel)

#### **📈 Observabilidade**
- [ ] **Spring Actuator** para métricas
- [ ] **ELK Stack** (Elasticsearch, Logstash, Kibana)
- [ ] **Grafana** para dashboards
- [ ] **Alertas Automáticos** para problemas

#### **⚡ Performance**
- [ ] **Cache Redis** para produtos
- [ ] **Database Indexing** otimizado
- [ ] **CDN** para assets estáticos
- [ ] **Lazy Loading** para imagens

---

## 📞 Suporte e Contribuição

### 🐛 **Reportar Bugs**
Encontrou um problema? Ajude-nos a melhorar!

```bash
# 1. Verifique se já foi reportado
# 2. Crie uma issue detalhada
# 3. Inclua informações completas:
- Versão do Java
- Sistema Operacional
- Passos para reproduzir
- Logs de erro
- Screenshots (se aplicável)
```

### 💡 **Como Contribuir**

#### **Para Desenvolvedores**
```bash
# 1. Fork o projeto
git clone https://github.com/SEU_USERNAME/sistema-gestao-senhor-leao.git

# 2. Crie uma branch para sua feature
git checkout -b feature/nova-funcionalidade

# 3. Desenvolva e teste
mvn clean test
mvn spring-boot:run

# 4. Commit seguindo conventional commits
git commit -m "feat: adiciona nova funcionalidade

- Descrição detalhada da mudança
- Impacto no sistema
- Testes realizados"

# 5. Push e Pull Request
git push origin feature/nova-funcionalidade
```

#### **Para Não-Desenvolvedores**
- ⭐ **Dê uma estrela** no GitHub
- 📢 **Compartilhe** o projeto
- 💬 **Sugira melhorias** nas issues
- 🧪 **Teste** e reporte bugs

### 📧 **Canais de Comunicação**

| Canal | Uso | Contato |
|---|---|---|
| **🐛 GitHub Issues** | Bugs e solicitações | [Issues](https://github.com/SEU_USERNAME/issues) |
| **💬 Discussions** | Perguntas gerais | [Discussions](https://github.com/SEU_USERNAME/discussions) |
| **📧 Email** | Contato direto | seu.email@exemplo.com |
| **💼 LinkedIn** | Parcerias | [LinkedIn Profile](https://linkedin.com/in/SEU_PROFILE) |

### 📋 **Código de Conduta**
- ✅ Seja respeitoso e profissional
- ✅ Contribua de forma construtiva
- ✅ Teste suas mudanças
- ✅ Documente seu código
- ✅ Siga os padrões estabelecidos

---

## 📝 Licença e Direitos Autorais

### 📄 **Licença MIT**
Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para detalhes completos.

```text
MIT License

Copyright (c) 2025 Sistema de Gestão de Restaurante

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

### 🔓 **Permissões da MIT License**
- ✅ **Uso comercial** - Use em projetos comerciais
- ✅ **Modificação** - Altere o código conforme necessário
- ✅ **Distribuição** - Distribua cópias do software
- ✅ **Uso privado** - Use em projetos pessoais
- ✅ **Licenciamento** - Pode ser relicenciado
- ⚠️ **Sem garantia** - Uso por sua conta e risco

---

## 🙏 Agradecimentos e Créditos

### 🏆 **Tecnologias e Frameworks**
- **Spring Boot Team** - Framework excepcional e documentação completa
- **Hibernate/JPA** - ORM poderoso e flexível
- **H2 Database** - Banco leve e confiável para desenvolvimento
- **Maven** - Gerenciamento de dependências eficiente

### 👥 **Comunidade**
- **Stack Overflow** - Respostas rápidas e soluções criativas
- **GitHub Community** - Inspiração e aprendizado constante
- **Java Community** - Tutoriais, artigos e melhores práticas

### 🎯 **Inspiração**
- **McDonald's/Burger King** - Modelo de experiência do cliente
- **Supermercados Modernos** - Sistema de notinhas digitais
- **Startups de Food Tech** - Inovação no setor de alimentação

### 💝 **Contribuições Especiais**
Agradecemos a todos que contribuíram com ideias, testes, feedback e melhorias para tornar este sistema cada vez melhor!

---

<div align="center">

# 🍔 **Sistema de Gestão de Restaurante**

### *Recibos Digitais - Experiência Inovadora*

**Desenvolvido com ❤️ para revolucionar a gestão de restaurantes**

---

### 🏆 **Características Premium**
- ⚡ **Alta Performance** - Spring Boot + H2
- 🛡️ **Altamente Seguro** - Validações server-side
- 📱 **Totalmente Responsivo** - Desktop & Mobile
- 🔧 **Altamente Customizável** - Código limpo e documentado
- 🚀 **Pronto para Produção** - Arquitetura escalável

---

### 📊 **Status do Projeto**
[![Java](https://img.shields.io/badge/Java-21+-red.svg)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-green.svg)](https://spring.io/)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Version](https://img.shields.io/badge/Version-1.0.0-orange.svg)]()

---

### 🌟 **Comece Agora**
```bash
git clone https://github.com/SEU_USERNAME/sistema-gestao-senhor-leao.git
cd sistema-gestao-senhor-leao
./mvnw spring-boot:run
```

**🍔 Seu restaurante digital está pronto!**

---

</div>