package com.example.projeto_test.repository;

import com.example.projeto_test.model.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ReciboRepository extends JpaRepository<Recibo, Long> {

    Optional<Recibo> findByNumeroChamada(String numeroChamada);
}