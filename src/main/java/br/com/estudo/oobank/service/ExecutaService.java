package br.com.estudo.oobank.service;

import br.com.estudo.oobank.endpoint.ViaCepClient;
import br.com.estudo.oobank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExecutaService {

    @Autowired
    public ViaCepClient viaCepClient;

    @Autowired
    public Armazenamento armazenamento;

    public Titular defineTitular(String nome,
                                 String cpf) throws Exception {
        return Titular.converte(nome, cpf);
    }

    public Endereco defineEndereco(String cep) {
        return viaCepClient.buscaCep(cep);
    }

    public ContaCorrente criaContaCorrente(Titular titular,
                                           int agencia,
                                           int numero) {

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.getTipo();
        contaCorrente.setTitular(titular);
        contaCorrente.setAgencia(agencia);
        contaCorrente.setNumero(numero);
        armazenamento.novaConta(contaCorrente);
        return contaCorrente;
    }

    public ContaPoupanca criaContaPoupanca(Titular titular,
                                           int agencia,
                                           int numero) {

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.getTipo();
        contaPoupanca.setTitular(titular);
        contaPoupanca.setAgencia(agencia);
        contaPoupanca.setNumero(numero);
        armazenamento.novaConta(contaPoupanca);
        return contaPoupanca;
    }

    public List<Conta> criaContas(Titular titular,
                                 int agencia,
                                 int numero) {
        List<Conta> contas = new ArrayList<>();
        contas.add(criaContaCorrente(titular, agencia, numero));
        contas.add(criaContaPoupanca(titular, agencia, numero));
        return contas;
    }

    public Conta deposito(String cpf,
                              String tipo,
                              double valor) {

        for (Conta conta : armazenamento.contas) {
            if (conta.getTitular().getCpf().equals(cpf) && conta.getTipo().equals(tipo)) {
                conta.setSaldo(conta.getSaldo() + valor);
                return conta;
            }
        }
        return null;
    }

    public Conta saque(String cpf,
                              String tipo,
                              double valor) {

        for (Conta conta : armazenamento.contas) {
            if (conta.getTitular().getCpf().equals(cpf) && conta.getTipo().equals(tipo)) {
                conta.setSaldo(conta.getSaldo() - valor);
                return conta;
            }
        }
        return null;
    }

}
