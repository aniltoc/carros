package com.orange.carros.carro;

import com.orange.carros.clients.FipeValorResponse;
import com.orange.carros.usuario.Usuario;

import javax.validation.constraints.NotBlank;

public class NovoCarroRequest {

    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String ano;

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }

    public Carro toModel(Usuario usuario, FipeValorResponse fipeValorResponse) {
        return new Carro(fipeValorResponse.getMarca(), fipeValorResponse.getModelo(), fipeValorResponse.getAnoModelo(),
                usuario, fipeValorResponse.getValor(), fipeValorResponse.getCombustivel(), fipeValorResponse.getCodigoFipe());
    }
}
