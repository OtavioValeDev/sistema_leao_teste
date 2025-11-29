package com.example.projeto_test.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacoes;
    private String formaPagamento;
    private double total;

    @ElementCollection
    private List<ItemCompra> itens = new ArrayList<>();

    // Classe interna para representar itens
    @Embeddable
    public static class ItemCompra {
        private String nome;
        private int quantidade;
        private double preco;

        public ItemCompra() {}

        public ItemCompra(String nome, int quantidade, double preco) {
            this.nome = nome;
            this.quantidade = quantidade;
            this.preco = preco;
        }

        public double subtotal() {
            return quantidade * preco;
        }
    }

    // Método para gerar o recibo completo
    public Recibo gerar(List<ItemCompra> itens, String observacoes, String formaPagamento) {
        this.itens = itens;
        this.observacoes = observacoes;
        this.formaPagamento = formaPagamento;

        this.total = itens.stream()
                .mapToDouble(ItemCompra::subtotal)
                .sum();

        return this;
    }

    public Long getId() { return id; }
    public double getTotal() { return total; }
    public String getObservacoes() { return observacoes; }
    public String getFormaPagamento() { return formaPagamento; }
    public List<ItemCompra> getItens() { return itens; }
}
