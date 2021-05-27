package com.orange.carros.carro.marca;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigo;

    public Marca(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    @Deprecated
    public Marca() {
    }

    public String getCodigo() {
        return codigo;
    }
}
