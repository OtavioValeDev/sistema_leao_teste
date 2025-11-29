package com.example.projeto_test.controller;

import com.example.projeto_test.model.Recibo;
import com.example.projeto_test.repository.ReciboRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recibo")
public class ReciboController {

    private final ReciboRepository reciboRepository;

    public ReciboController(ReciboRepository reciboRepository) {
        this.reciboRepository = reciboRepository;
    }

    @PostMapping("/pagar")
    public Recibo pagar(@RequestBody List<Recibo.ItemCompra> itens) {

        Recibo r = new Recibo()
                .gerar(
                        itens,
                        "Sem cebola",
                        "pix"
                );

        return reciboRepository.save(r);
    }
}
