-- ============================================================================
-- DADOS INICIAIS - CARDÁPIO COMPLETO DA LANCHONETE SENHOR LEÃO
-- ============================================================================
-- Este arquivo é executado automaticamente pelo Spring Boot ao iniciar a aplicação
-- Todos os produtos do cardápio são inseridos no banco H2 em memória
-- ============================================================================

-- Limpar tabela existente (caso haja dados)
-- DELETE FROM products; -- Removido para evitar erro na primeira execução

-- ===========================================
-- 🥪 LANCHES
-- ===========================================
INSERT INTO products (name, price_in_cents) VALUES ('X-Burger', 2500);
INSERT INTO products (name, price_in_cents) VALUES ('X-Salada', 2200);
INSERT INTO products (name, price_in_cents) VALUES ('X-Bacon', 2800);
INSERT INTO products (name, price_in_cents) VALUES ('Frango Grelhado', 2400);
INSERT INTO products (name, price_in_cents) VALUES ('Sanduíche Natural', 1800);

-- ===========================================
-- 🌭 ESPECIAIS RÁPIDOS
-- ===========================================
INSERT INTO products (name, price_in_cents) VALUES ('Cachorro-Quente Tradicional', 1500);
INSERT INTO products (name, price_in_cents) VALUES ('Cachorro-Quente Duplo', 2000);

-- ===========================================
-- 🍟 PORÇÕES
-- ===========================================
INSERT INTO products (name, price_in_cents) VALUES ('Batata Frita (Pequena)', 1200);
INSERT INTO products (name, price_in_cents) VALUES ('Batata Frita (Média)', 1800);
INSERT INTO products (name, price_in_cents) VALUES ('Batata Frita (Grande)', 2400);
INSERT INTO products (name, price_in_cents) VALUES ('Batata com Cheddar e Bacon', 2800);
INSERT INTO products (name, price_in_cents) VALUES ('Onion Rings', 1600);
INSERT INTO products (name, price_in_cents) VALUES ('Frango Empanado Crocante', 2200);

-- ===========================================
-- 🍛 PRATOS FEITOS (PF)
-- ===========================================
INSERT INTO products (name, price_in_cents) VALUES ('PF de Frango', 3200);
INSERT INTO products (name, price_in_cents) VALUES ('PF de Bife Acebolado', 3500);
INSERT INTO products (name, price_in_cents) VALUES ('PF de Carne Moída', 3000);
INSERT INTO products (name, price_in_cents) VALUES ('PF de Omelete', 2800);

-- ===========================================
-- 🍝 PRATOS ESPECIAIS
-- ===========================================
INSERT INTO products (name, price_in_cents) VALUES ('Parmegiana de Frango', 3800);
INSERT INTO products (name, price_in_cents) VALUES ('Parmegiana de Carne', 4200);
INSERT INTO products (name, price_in_cents) VALUES ('Macarronada ao Sugo', 2800);
INSERT INTO products (name, price_in_cents) VALUES ('Macarronada Bolonhesa', 3200);
INSERT INTO products (name, price_in_cents) VALUES ('Estrogonofe de Frango', 3600);
INSERT INTO products (name, price_in_cents) VALUES ('Estrogonofe de Carne', 4000);

-- ===========================================
-- 🥗 LIGHT
-- ===========================================
INSERT INTO products (name, price_in_cents) VALUES ('Salada Completa', 2600);
INSERT INTO products (name, price_in_cents) VALUES ('Salada Caesar', 2900);

-- ===========================================
-- 🥟 SALGADOS
-- ===========================================
INSERT INTO products (name, price_in_cents) VALUES ('Coxinha (Frango)', 800);
INSERT INTO products (name, price_in_cents) VALUES ('Coxinha (Frango com Catupiry)', 900);
INSERT INTO products (name, price_in_cents) VALUES ('Risoles (Presunto e Queijo)', 700);
INSERT INTO products (name, price_in_cents) VALUES ('Risoles (Carne)', 800);
INSERT INTO products (name, price_in_cents) VALUES ('Enroladinho de Salsicha', 600);
INSERT INTO products (name, price_in_cents) VALUES ('Empada (Frango)', 1000);
INSERT INTO products (name, price_in_cents) VALUES ('Empada (Palmito)', 1100);
INSERT INTO products (name, price_in_cents) VALUES ('Empada (Camarão)', 1200);
INSERT INTO products (name, price_in_cents) VALUES ('Quibe Frito', 900);
INSERT INTO products (name, price_in_cents) VALUES ('Pastel Assado (Carne)', 800);
INSERT INTO products (name, price_in_cents) VALUES ('Pastel Assado (Queijo)', 700);
INSERT INTO products (name, price_in_cents) VALUES ('Pastel Assado (Pizza)', 900);
INSERT INTO products (name, price_in_cents) VALUES ('Pastel Assado (Frango)', 800);
INSERT INTO products (name, price_in_cents) VALUES ('Pastel Frito (Carne)', 700);
INSERT INTO products (name, price_in_cents) VALUES ('Pastel Frito (Queijo)', 600);
INSERT INTO products (name, price_in_cents) VALUES ('Pastel Frito (Pizza)', 800);
INSERT INTO products (name, price_in_cents) VALUES ('Pastel Frito (Frango)', 700);

-- ===========================================
-- 🥤 BEBIDAS
-- ===========================================
INSERT INTO products (name, price_in_cents) VALUES ('Refrigerante (Lata)', 600);
INSERT INTO products (name, price_in_cents) VALUES ('Refrigerante (600ml)', 800);
INSERT INTO products (name, price_in_cents) VALUES ('Suco Natural', 1000);
INSERT INTO products (name, price_in_cents) VALUES ('Água', 400);
INSERT INTO products (name, price_in_cents) VALUES ('Chá Gelado', 700);
