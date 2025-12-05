# 🍔 Sistema de Gestão de Restaurante - Recibos Digitais

Sistema completo para gestão de restaurante com geração automática de recibos/notinhas digitais, similar aos sistemas de supermercado.

## 📋 Visão Geral

Este projeto implementa um **sistema completo de restaurante** com duas funcionalidades principais:

1. **CRUD de Produtos** - Gerenciamento do cardápio
2. **Sistema de Recibos** - Geração de notinhas digitais com números aleatórios

### 🎯 Funcionalidades Principais

- ✅ **Gerenciamento de Produtos**: Cadastrar, listar, atualizar e excluir itens do cardápio
- ✅ **Sistema de Pedidos**: Carrinho interativo para seleção de produtos
- ✅ **Geração de Recibos**: Recibos digitais com números de chamada aleatórios (4 dígitos)
- ✅ **Histórico de Vendas**: Consulta de todos os recibos emitidos
- ✅ **Interface Web Completa**: Sistema responsivo e intuitivo

---

## 🚀 Guia de Instalação e Execução

### Pré-requisitos

- **Java 21** ou superior
- **Maven** (ou use o Maven Wrapper incluído)

### Executando o Projeto

1. **Clone ou baixe o projeto**
2. **Navegue até a pasta do projeto**
3. **Execute o comando**:

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

4. **Aguarde a inicialização** - aparecerá a mensagem:
```
Started ProjetoTestApplication in X seconds
```

---

## 🖥️ Como Testar o Sistema

### 1. Acesse a Interface Principal

Abra seu navegador e vá para:
```
http://localhost:8080/recibos.html
```

### 2. Teste Completo - Do Cardápio ao Recibo

#### 📝 **Passo 1: Gerenciar Produtos (Funcionário)**

1. Clique na aba **"Gerenciar Produtos"**
2. **Cadastre produtos** no cardápio:
   - Nome: `Hambúrguer`
   - Preço: `1500` (em centavos = R$ 15,00)
   - Clique em **"Cadastrar"**

3. **Cadastre mais produtos**:
   - Nome: `Refrigerante`
   - Preço: `500` (R$ 5,00)
   - Nome: `Batata Frita`
   - Preço: `800` (R$ 8,00)

4. **Verifique os produtos** na lista abaixo

#### 🛒 **Passo 2: Fazer um Pedido (Cliente)**

1. Clique na aba **"Gerar Recibos"**
2. **Selecione produtos** clicando nos itens disponíveis:
   - Hambúrguer (clique uma vez)
   - Refrigerante (clique uma vez)
   - Batata Frita (clique uma vez)

3. **Ajuste quantidades** no carrinho se necessário

4. **Adicione observações** (opcional):
   - Ex: `"Sem cebola na batata, entregar sem gelo"`

5. **Escolha forma de pagamento**:
   - Dinheiro / Cartão / Pix

6. **Clique em "Gerar Recibo"**

#### 🧾 **Passo 3: Verificar o Recibo Gerado**

Após gerar o recibo, você verá:

```
RECIBO #1234

Data: [data/hora atual]

Itens:
Hambúrguer x1 = R$ 15,00
Refrigerante x1 = R$ 5,00
Batata Frita x1 = R$ 8,00

Total: R$ 28,00
Pagamento: Cartão
Obs: Sem cebola na batata, entregar sem gelo
```

**📋 Memorize o número do recibo (#1234)** - este é o número da "notinha"!

#### 📚 **Passo 4: Consultar Histórico**

1. Clique na aba **"Histórico de Recibos"**
2. Clique em **"Carregar Recibos"**
3. Você verá todos os recibos emitidos
4. **Clique nos recibos** para expandir e ver detalhes

---

## 🔍 Testes Adicionais

### Via API REST (Postman/Insomnia)

#### Produtos
```bash
# Listar produtos
GET http://localhost:8080/products

# Criar produto
POST http://localhost:8080/products
{
  "name": "Sorvete",
  "priceInCents": 600
}

# Atualizar produto
PUT http://localhost:8080/products/1
{
  "name": "Sorvete Atualizado",
  "priceInCents": 700
}

# Deletar produto
DELETE http://localhost:8080/products/1
```

#### Recibos
```bash
# Gerar recibo
POST http://localhost:8080/recibos/pagar
{
  "itens": [
    {
      "nome": "Hambúrguer",
      "quantidade": 2,
      "preco": 1500
    }
  ],
  "observacoes": "Sem salada",
  "formaPagamento": "Dinheiro"
}

# Listar recibos
GET http://localhost:8080/recibos

# Buscar por número de chamada (notinha)
GET http://localhost:8080/recibos/chamada/1234

# Limpar histórico
DELETE http://localhost:8080/recibos/limpar
```

### Interface de Testes Básica

Para testes mais simples, acesse:
```
http://localhost:8080/index.html
```

Esta interface permite operações básicas de CRUD sem o sistema de carrinho.

---

## 📁 Estrutura Completa do Projeto

```
📁 sistema-gestao-senhor-leao/
│
├── 📄 README.md                           # Este arquivo
├── 📄 pom.xml                             # Configuração Maven
├── 📄 mvnw & mvnw.cmd                     # Maven Wrapper
├── 📄 .gitignore                          # Arquivos ignorados pelo Git
├── 📄 .gitattributes                      # Atributos Git
│
├── 📁 .mvn/wrapper/                       # Maven Wrapper
│   └── 📄 maven-wrapper.properties
│
├── 📁 projeto-postgres/                   # [OPCIONAL] Versão PostgreSQL
│   ├── 📄 pom.xml
│   └── 📁 src/...                        # Estrutura similar
│
└── 📁 src/main/java/com/example/projeto_test/
    │
    ├── 📄 ProjetoTestApplication.java     # Classe principal Spring Boot
    │
    ├── 📁 controller/                     # Camada de apresentação
    │   ├── 📄 ProductController.java      # CRUD produtos (REST API)
    │   ├── 📄 ReciboController.java       # Sistema recibos (REST API)
    │   └── 📄 GlobalExceptionHandler.java # Tratamento de erros
    │
    ├── 📁 model/                          # Camada de domínio
    │   ├── 📄 Product.java                # Entidade Produto
    │   └── 📄 Recibo.java                 # Entidade Recibo + ItemCompra
    │
    ├── 📁 repository/                     # Camada de persistência
    │   ├── 📄 ProductRepository.java      # JPA Repository produtos
    │   └── 📄 ReciboRepository.java       # JPA Repository recibos
    │
    ├── 📁 service/                        # Camada de negócio
    │   ├── 📄 ProductService.java         # Lógica produtos
    │   └── 📄 ReciboService.java          # Lógica recibos
    │
    └── 📁 resources/
        ├── 📄 application.properties      # Configurações Spring
        │
        └── 📁 static/                     # Arquivos estáticos (frontend)
            ├── 📄 index.html             # Interface básica de testes
            ├── 📄 recibos.html           # Interface completa do sistema
            ├── 📄 cliente.html           # Interface cliente (antiga)
            └── 📄 funcionario.html       # Interface funcionário (antiga)
```

### 📊 Arquitetura em Camadas

```
┌─────────────────┐
│   Controller    │ ← REST APIs, validações básicas
├─────────────────┤
│    Service      │ ← Lógica de negócio, validações complexas
├─────────────────┤
│  Repository     │ ← Acesso ao banco de dados
├─────────────────┤
│     Model       │ ← Entidades JPA, regras de domínio
├─────────────────┤
│   Database      │ ← H2 (desenvolvimento) / PostgreSQL (produção)
└─────────────────┘
```

---

## 💾 Banco de Dados

- **Tecnologia**: H2 Database (em memória)
- **Console**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuário**: `sa`
- **Senha**: *(vazio)*

As tabelas são criadas automaticamente pelo Hibernate.

---

## 🔧 Tecnologias Utilizadas

- **Backend**: Spring Boot 3.5.7
- **Banco**: H2 Database
- **ORM**: Hibernate/JPA
- **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
- **Build**: Maven
- **Java**: OpenJDK 21+

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

### "localhost se recusou a se conectar"

**Solução**:
1. Verifique se a aplicação está rodando
2. Aguarde 10-15 segundos após executar `spring-boot:run`
3. Confirme que não há outro processo usando a porta 8080

### "Failed to fetch" no navegador

**Causa**: Requisições AJAX falhando
**Solução**:
1. Recarregue a página (F5)
2. Verifique se a aplicação está rodando
3. Tente novamente após alguns segundos

### Erro de compilação

**Solução**:
```bash
# Limpar e recompilar
.\mvnw.cmd clean compile
```

### Porta 8080 ocupada

**Alterar porta no `application.properties`**:
```
server.port=8081
```

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

## 🎯 Próximos Passos

- [ ] Autenticação de usuários (Spring Security)
- [ ] Relatórios de vendas
- [ ] Integração com sistemas de pagamento
- [ ] API REST documentada (Swagger)
- [ ] Deploy em produção
- [ ] Testes automatizados

---

## 📞 Suporte

Para dúvidas ou problemas:

1. Verifique este README
2. Teste as APIs via Postman
3. Consulte os logs da aplicação
4. Abra uma issue no repositório

---

## 📝 Licença

Este projeto é open source e está disponível sob a licença MIT.

---

**🍔 Desenvolvido com ❤️ para demonstrar conceitos de Spring Boot e desenvolvimento web!**