package br.com.estudo.oobank.service;

import br.com.estudo.oobank.model.Conta;
import org.springframework.stereotype.Service;

@Service

public class executa {

    public Conta criarConta(String titular,
                              int agencia,
                              int numero,
                              double saldo) {

        Conta conta = new Conta();
        conta.titular = titular;
        conta.agencia = agencia;
        conta.numero = numero;
        conta.saldo = saldo;

        return conta;

    }
}
