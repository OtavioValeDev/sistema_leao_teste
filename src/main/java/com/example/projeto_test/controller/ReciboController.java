package com.example.projeto_test.controller;

import com.example.projeto_test.model.Recibo;
import com.example.projeto_test.repository.ReciboRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recibo")
public class ReciboController {

    private final ReciboRepository reciboRepository;

    public ReciboController(ReciboRepository reciboRepository) {
        this.reciboRepository = reciboRepository;
    }

    // DTO simples para o payload
    public record PagamentoRequest(
            List<Recibo.ItemCompra> itens,
            String observacoes,
            String formaPagamento
    ) {}

    // POST /pagar → gera e salva
    @PostMapping("/pagar")
    public Recibo pagar(@RequestBody PagamentoRequest req) {
        Recibo recibo = new Recibo()
                .gerar(
                        req.itens(),
                        req.observacoes(),
                        req.formaPagamento()
                );

        return reciboRepository.save(recibo);
    }

    // GET /listar → lista todos os recibos
    @GetMapping("/listar")
    public List<Recibo> listar() {
        return reciboRepository.findAll();
    }

    // GET /{id} → busca recibo específico
    @GetMapping("/{id}")
    public Recibo buscar(@PathVariable Long id) {
        return reciboRepository.findById(id).orElse(null);
    }

    // DELETE /limpar → remove todos os recibos
    @DeleteMapping("/limpar")
    public String limpar() {
        reciboRepository.deleteAll();
        return "Recibos apagados.";
    }
}
