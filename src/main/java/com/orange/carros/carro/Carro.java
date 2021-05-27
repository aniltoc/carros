package com.orange.carros.carro;

import com.orange.carros.usuario.Usuario;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Long anoModelo;
    @ManyToOne
    private Usuario usuario;
    private String valor;
    private String combustivel;
    private String codigoFipe;
    @Enumerated(EnumType.STRING)
    private DiaRodizio diaRodizio;
    private boolean rodizioAtivo;

    public Carro(String marca, String modelo, Long anoModelo, Usuario usuario, String valor,
                 String combustivel, String codigoFipe) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.usuario = usuario;
        this.valor = valor;
        this.combustivel = combustivel;
        this.codigoFipe = codigoFipe;
        this.diaRodizio = retornaDiaRodizio(anoModelo);
    }

    @Deprecated
    public Carro() {
    }

    private DiaRodizio retornaDiaRodizio(Long anoModelo){
        String string = String.valueOf(anoModelo);
        Long finalAno = Long.valueOf(string.substring(string.length() - 1));
        if (finalAno == 0 || finalAno == 1 ){
            return DiaRodizio.SEGUNDA_FEIRA;
        }
        if (finalAno == 2 || finalAno == 3 ){
            return DiaRodizio.TERCA_FEIRA;
        }
        if (finalAno == 4 || finalAno == 5 ){
            return DiaRodizio.QUARTA_FEIRA;
        }
        if (finalAno == 6 || finalAno == 7 ){
            return DiaRodizio.QUINTA_FEIRA;
        }
        else {
            return DiaRodizio.SEXTA_FEIRA;
        }
    }

    private DiaRodizio toDiaRodizio(){
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        if(dayOfWeek == DayOfWeek.SUNDAY){
            return DiaRodizio.DOMINGO;
        }
        if(dayOfWeek == DayOfWeek.MONDAY){
            return DiaRodizio.SEGUNDA_FEIRA;
        }
        if(dayOfWeek == DayOfWeek.TUESDAY){
            return DiaRodizio.TERCA_FEIRA;
        }
        if(dayOfWeek == DayOfWeek.WEDNESDAY){
            return DiaRodizio.QUARTA_FEIRA;
        }
        if(dayOfWeek == DayOfWeek.THURSDAY){
            return DiaRodizio.QUINTA_FEIRA;
        }
        if(dayOfWeek == DayOfWeek.FRIDAY){
            return DiaRodizio.SEXTA_FEIRA;
        }
        else {
            return DiaRodizio.SABADO;
        }
    }

    public void setDiaRodizio(){
        DiaRodizio diaRodizio = toDiaRodizio();
        if (this.diaRodizio == diaRodizio){
            this.rodizioAtivo = true;
        }
        else {
            this.rodizioAtivo = false;
        }
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

    public Usuario getUsuario() {
        return usuario;
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
