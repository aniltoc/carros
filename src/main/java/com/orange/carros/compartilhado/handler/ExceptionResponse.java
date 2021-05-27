package com.orange.carros.compartilhado.handler;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private final String campo;
    private final String mensagem;
    private final String status;
    private final LocalDateTime timeStamp = LocalDateTime.now();

    public ExceptionResponse(String campo, String mensagem, String status) {
        this.campo = campo;
        this.mensagem = mensagem;
        this.status = status;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
