package com.orange.carros.clients;

public class ModelosResponse {

    private String nome;
    private Long codigo;

    public String getNome() {
        return nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "ModelosResponse{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
