package com.example.projeto_test.service;

import com.example.projeto_test.model.Recibo;
import com.example.projeto_test.model.Recibo.ItemCompra;
import com.example.projeto_test.repository.ReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    public Recibo createRecibo(List<ItemCompra> itens, String observacoes, String formaPagamento) {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Carrinho não pode estar vazio");
        }

        Recibo recibo = new Recibo();
        recibo.gerarRecibo(itens, observacoes, formaPagamento);
        return reciboRepository.save(recibo);
    }

    public List<Recibo> getAllRecibos() {
        return reciboRepository.findAll();
    }

    public Recibo getReciboById(Long id) {
        return reciboRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recibo not found"));
    }

    public Recibo getReciboByNumeroChamada(String numeroChamada) {
        return reciboRepository.findByNumeroChamada(numeroChamada)
                .orElseThrow(() -> new RuntimeException("Recibo not found"));
    }

    public void deleteAllRecibos() {
        reciboRepository.deleteAll();
    }
}