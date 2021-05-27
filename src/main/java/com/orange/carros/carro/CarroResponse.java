package com.orange.carros.carro;

public class CarroResponse {

    private final String marca;
    private final String modelo;
    private final Long anoModelo;
    private final String nomeUsuario;
    private final String valor;
    private final String combustivel;
    private final String codigoFipe;
    private final DiaRodizio diaRodizio;
    private final boolean rodizioAtivo;

    public CarroResponse (Carro carro){
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.anoModelo = carro.getAnoModelo();
        this.nomeUsuario = carro.getUsuario().getNome();
        this.valor = carro.getValor();
        this.combustivel = carro.getCombustivel();
        this.codigoFipe = carro.getCodigoFipe();
        this.diaRodizio = carro.getDiaRodizio();
        this.rodizioAtivo = carro.isRodizioAtivo();
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getValor() {
        return valor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public DiaRodizio getDiaRodizio() {
        return diaRodizio;
    }

    public boolean isRodizioAtivo() {
        return rodizioAtivo;
    }
}
