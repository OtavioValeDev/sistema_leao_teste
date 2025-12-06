package com.example.projeto_test.service;

import com.example.projeto_test.model.Recibo;
import com.example.projeto_test.model.Recibo.ItemCompra;
import com.example.projeto_test.repository.ReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço de negócio para operações com recibos.
 *
 * Esta classe contém toda a lógica de negócio relacionada aos recibos,
 * incluindo geração de números aleatórios, cálculos de total e validações.
 * Atua como intermediário entre o controller e o repository.
 *
 * @author Sistema de Gestão de Restaurante
 * @version 1.0
 * @since 2025-01-01
 */
@Service
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    /**
     * Cria um novo recibo com itens de compra.
     *
     * Valida se há itens no carrinho, gera automaticamente o número
     * de chamada aleatório e calcula o total da venda.
     *
     * @param itens Lista de itens comprados
     * @param observacoes Observações especiais do cliente
     * @param formaPagamento Método de pagamento escolhido
     * @return Recibo criado e salvo no banco
     * @throws IllegalArgumentException Se o carrinho estiver vazio
     */
    public Recibo createRecibo(List<ItemCompra> itens, String observacoes, String formaPagamento) {
        return createRecibo(itens, observacoes, formaPagamento, "NORMAL");
    }

    /**
     * Cria um novo recibo com itens de compra e tipo de atendimento.
     *
     * Valida se há itens no carrinho, gera automaticamente o número
     * de chamada aleatório e calcula o total da venda.
     *
     * @param itens Lista de itens comprados
     * @param observacoes Observações especiais do cliente
     * @param formaPagamento Método de pagamento escolhido
     * @param tipoAtendimento Tipo de atendimento (NORMAL ou PREFERENCIAL)
     * @return Recibo criado e salvo no banco
     * @throws IllegalArgumentException Se o carrinho estiver vazio
     */
    public Recibo createRecibo(List<ItemCompra> itens, String observacoes, String formaPagamento, String tipoAtendimento) {
        if (itens == null || itens.isEmpty()) {
            if (!"PREFERENCIAL".equals(tipoAtendimento)) {
                throw new IllegalArgumentException("Carrinho não pode estar vazio");
            }
        }

        Recibo recibo = new Recibo();
        recibo.gerarRecibo(itens, observacoes, formaPagamento, tipoAtendimento);
        return reciboRepository.save(recibo);
    }

    /**
     * Retorna todos os recibos cadastrados.
     *
     * @return Lista completa de recibos
     */
    public List<Recibo> getAllRecibos() {
        return reciboRepository.findAll();
    }

    /**
     * Busca um recibo específico pelo ID.
     *
     * @param id Identificador único do recibo
     * @return Recibo encontrado
     * @throws RuntimeException Se o recibo não for encontrado
     */
    public Recibo getReciboById(@NonNull Long id) {
        return reciboRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recibo not found"));
    }

    /**
     * Busca um recibo pelo número de chamada (notinha).
     *
     * @param numeroChamada Número de 4 dígitos gerado aleatoriamente
     * @return Recibo encontrado
     * @throws RuntimeException Se o recibo não for encontrado
     */
    public Recibo getReciboByNumeroChamada(String numeroChamada) {
        return reciboRepository.findByNumeroChamada(numeroChamada)
                .orElseThrow(() -> new RuntimeException("Recibo not found"));
    }

    /**
     * Remove todos os recibos do sistema.
     *
     * Método utilitário para limpar o histórico em ambiente de desenvolvimento.
     */
    public void deleteAllRecibos() {
        reciboRepository.deleteAll();
    }
}