package br.com.estudo.oobank.service;

import br.com.estudo.oobank.model.Conta;
import br.com.estudo.oobank.model.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Executa {

    @Autowired
    public Conta conta;

    @Autowired
    public ArmazenaConta armazenaConta;

    @Autowired
    public Mensagem mensagens;

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

        for (Conta conta : listarContas()) {
            if (conta.agencia == agencia && conta.numero == numero) {
                conta.saldo += valor;
                armazenaConta.atualizaSaldo(agencia, numero, conta.saldo);
                return conta;
            }
        }
        return null;
    }

    public Conta sacar(int agencia,
                       int numero,
                       double valor) {

        for (Conta conta : listarContas()) {
            if (conta.agencia == agencia && conta.numero == numero && valor <= conta.saldo) {
                conta.saldo -= valor;
                armazenaConta.atualizaSaldo(agencia, numero, conta.saldo);
                return conta;
            }
        }
        return null;
    }

    public Conta transferir (int agenciaA,
                             int numeroA,
                             int agenciaB,
                             int numeroB,
                             double valor) {

        sacar(agenciaA, numeroA, valor);
        depositar(agenciaB, numeroB, valor);
        return armazenaConta.consultaConta(agenciaA, numeroA);
    }

    public List<Conta> listarContas() {

        return armazenaConta.contas;

    }
}
