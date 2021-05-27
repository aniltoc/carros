package com.orange.carros.carro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findAllByUsuarioId(Long usuarioId);
}
