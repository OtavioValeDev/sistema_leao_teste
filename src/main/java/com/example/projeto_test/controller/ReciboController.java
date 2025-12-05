package com.example.projeto_test.controller;

import com.example.projeto_test.model.Recibo;
import com.example.projeto_test.service.ReciboService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recibos")
public class ReciboController {

    private final ReciboService reciboService;

    public ReciboController(ReciboService reciboService) {
        this.reciboService = reciboService;
    }

    public record PagamentoRequest(
            List<Recibo.ItemCompra> itens,
            String observacoes,
            String formaPagamento
    ) {}

    @PostMapping("/pagar")
    public ResponseEntity<Recibo> pagar(@RequestBody PagamentoRequest req) {
        try {
            Recibo recibo = reciboService.createRecibo(req.itens(), req.observacoes(), req.formaPagamento());
            return ResponseEntity.status(HttpStatus.CREATED).body(recibo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Recibo>> listar() {
        List<Recibo> recibos = reciboService.getAllRecibos();
        return ResponseEntity.ok(recibos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recibo> buscarPorId(@PathVariable Long id) {
        try {
            Recibo recibo = reciboService.getReciboById(id);
            return ResponseEntity.ok(recibo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/chamada/{numero}")
    public ResponseEntity<Recibo> buscarPorNumeroChamada(@PathVariable String numero) {
        try {
            Recibo recibo = reciboService.getReciboByNumeroChamada(numero);
            return ResponseEntity.ok(recibo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/limpar")
    public ResponseEntity<String> limpar() {
        reciboService.deleteAllRecibos();
        return ResponseEntity.ok("Recibos deletados com sucesso.");
    }
}