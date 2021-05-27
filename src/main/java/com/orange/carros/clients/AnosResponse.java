package com.orange.carros.clients;

public class AnosResponse {

    private String nome;
    private String codigo;

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "AnosResponse{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
