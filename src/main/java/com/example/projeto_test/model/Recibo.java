package com.example.projeto_test.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "recibos")
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroChamada;

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    private String observacoes;
    private String formaPagamento;
    private Integer total;

    @ElementCollection
    @CollectionTable(name = "recibo_itens", joinColumns = @JoinColumn(name = "recibo_id"))
    private List<ItemCompra> itens = new ArrayList<>();

    @Embeddable
    public static class ItemCompra {
        private String nome;
        private Integer quantidade;
        private Integer preco;

        public ItemCompra() {}

        public ItemCompra(String nome, Integer quantidade, Integer preco) {
            this.nome = nome;
            this.quantidade = quantidade;
            this.preco = preco;
        }

        public Integer getSubtotal() {
            return quantidade * preco;
        }

        // Getters e Setters
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
        public Integer getQuantidade() { return quantidade; }
        public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
        public Integer getPreco() { return preco; }
        public void setPreco(Integer preco) { this.preco = preco; }
    }

    public Recibo() {}

    public void gerarRecibo(List<ItemCompra> itens, String observacoes, String formaPagamento) {
        this.itens = itens != null ? itens : new ArrayList<>();
        this.observacoes = observacoes;
        this.formaPagamento = formaPagamento;
        this.dataCriacao = LocalDateTime.now();
        this.numeroChamada = String.format("%04d", new Random().nextInt(10000));

        this.total = this.itens.stream()
                .mapToInt(ItemCompra::getSubtotal)
                .sum();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroChamada() { return numeroChamada; }
    public void setNumeroChamada(String numeroChamada) { this.numeroChamada = numeroChamada; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }
    public List<ItemCompra> getItens() { return itens; }
    public void setItens(List<ItemCompra> itens) { this.itens = itens; }
}