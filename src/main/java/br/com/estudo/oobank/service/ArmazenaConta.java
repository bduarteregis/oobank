package br.com.estudo.oobank.service;

import br.com.estudo.oobank.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component

public class ArmazenaConta {

    public List<Conta> contas = new ArrayList<Conta>();

    public List<Conta> novaConta(String titular, int agencia, int numero) {
        Conta conta = new Conta();
        conta.titular = titular;
        conta.agencia = agencia;
        conta.numero = numero;
        contas.add(conta);
        return contas;
    }

    public List<Conta> atualizaSaldo(int agencia, int numero, double saldo) {
        for(Conta conta : contas) {
            if (conta.agencia == agencia && conta.numero == numero) {
                conta.saldo = saldo;
            }
        }
        return contas;
    }

    public Conta consultaConta (int agencia, int numero) {
        for(Conta conta : contas) {
            if (conta.agencia == agencia && conta.numero == numero) {
                return conta;
            }
        }
        return null;
    }
}
