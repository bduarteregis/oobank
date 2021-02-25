package br.com.estudo.oobank.model;

import org.springframework.stereotype.Component;

@Component

public class Conta {
    public String titular;
    public int agencia;
    public int numero;
    public double saldo;
}
