package br.com.estudo.oobank.model;

import org.springframework.stereotype.Component;

@Component

public enum Mensagem {

    saldoInferior("Valor de saque superior ao Saldo da conta.");

    public String exibe;

    Mensagem(String exibe) {
        this.exibe = exibe;
    }

}
