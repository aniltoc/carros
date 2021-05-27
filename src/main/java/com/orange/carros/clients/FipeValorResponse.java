package com.orange.carros.clients;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeValorResponse {

    @JsonProperty(value = "Valor")
    private String valor;
    @JsonProperty(value = "Marca")
    private String marca;
    @JsonProperty(value = "Modelo")
    private String modelo;
    @JsonProperty(value = "AnoModelo")
    private Long anoModelo;
    @JsonProperty(value = "Combustivel")
    private String combustivel;
    @JsonProperty(value = "CodigoFipe")
    private String codigoFipe;


    public String getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Long getAnoModelo() {
        return anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    @Override
    public String toString() {
        return "FipeValorResponse{" +
                "valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                '}';
    }
}
