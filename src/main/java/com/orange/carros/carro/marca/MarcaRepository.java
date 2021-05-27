package com.orange.carros.carro.marca;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository <Marca, Long> {
    boolean existsByNome(String nome);

    Optional<Marca> findByNome(String marca);
}
