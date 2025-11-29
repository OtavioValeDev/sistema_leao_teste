package com.example.projeto_test.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private Double total;

    private String itens;

    private String observacoes;

    private String metodoPagamento;

    public Recibo() {}

//    METODO PRINCIPAL: GERA O RECIBO COMPLETO
    public Recibo gerar(
            List<ItemCompra> itensCompra,
            String observacoes,
            String metodoPagamento
    ) {
        this.dataHora = LocalDateTime.now();
        this.observacoes = observacoes;
        this.metodoPagamento = metodoPagamento;

        StringBuilder sb = new StringBuilder();
        double soma = 0;

        for (ItemCompra item : itensCompra) {
            double subtotal = item.produto.preco * item.quantidade;
            soma += subtotal;

            sb.append(item.quantidade)
              .append("x ")
              .append(item.produto.nome)
              .append(" (R$ ")
              .append(item.produto.preco)
              .append(")")
              .append(" | ");
        }

        this.total = soma;
        this.itens = sb.toString();

        return this;
    }

    // --------------------------------------------
    // CLASSE FILHA MINIMALISTA PARA ITEM COMPRA
    // --------------------------------------------
    public static class ItemCompra {
        public Produto produto;
        public int quantidade;

        public ItemCompra(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }

    // --------------------------------------------
    // CLASSE FILHA MINIMALISTA PARA PRODUTO
    // --------------------------------------------
    @Embeddable
    public static class Produto {
        public String nome;
        public double preco;

        public Produto() {}

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
