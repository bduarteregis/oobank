package br.com.estudo.oobank.service;

import br.com.estudo.oobank.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Executa {

    @Autowired
    public Conta conta;

    @Autowired
    public ArmazenaConta armazenaConta;

    public Conta criarConta(String titular,
                            int agencia,
                            int numero) {

        conta.titular = titular;
        conta.agencia = agencia;
        conta.numero = numero;
        armazenaConta.novaConta(titular, agencia, numero);
        return conta;

    }

    public Conta depositar(int agencia,
                     int numero,
                     double valor) {

        conta.saldo += valor;
        armazenaConta.atualizaSaldo(agencia, numero, conta.saldo);
        return conta;

    }

//    public Conta sacar(int agencia,
//                       int numero,
//                       double valor) {
//
//        conta.agencia = agencia;
//        conta.numero = numero;
//        conta.saldo = conta.saldo - valor;
//        return conta;
//
//    }

    public List<Conta> listaContas() {

        return armazenaConta.contas;

    }
}
