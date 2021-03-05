package br.com.estudo.oobank.service;

import br.com.estudo.oobank.model.Cliente;
import br.com.estudo.oobank.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class Operacoes {

    @Autowired
    public Armazenamento armazenamento;

    @Autowired
    public Executa executa;

    public Cliente novoCliente(String nome,
                               String cpf,
                               String cep,
                               int agencia,
                               int numero) {

        Cliente cliente = new Cliente();
        cliente.setTitular(executa.defineTitular(nome, cpf));
        cliente.setEndereco(executa.defineEndereco(cep));
        cliente.setContas(executa.criaContas(cliente.getTitular(), agencia, numero));
        armazenamento.novoCliente(cliente);
        return armazenamento.listaCliente(cpf);

    }

    public Conta listarConta(String cpf,
                                   String tipo) {
        return armazenamento.listaConta(cpf, tipo);
    }

    public List<Conta> listarContas(String cpf) {
        return armazenamento.listaContasCliente(cpf);
    }

    public Cliente listarCliente (String cpf) {
        return armazenamento.listaCliente(cpf);
    }

    public List<Cliente> listarClientes() {
        return armazenamento.listaClientes();
    }

    public Conta depositar(String cpf,
                           String tipo,
                           double valor) {

        return executa.deposito(cpf, tipo, valor);
    }

    public Conta sacar(String cpf,
                       String tipo,
                       double valor) {

        return executa.saque(cpf, tipo, valor);
    }

    public Conta transferir(String cpfA,
                            String tipoA,
                            String cpfB,
                            String tipoB,
                            double valor) {

        sacar(cpfA, tipoA, valor);
        depositar(cpfB, tipoB, valor);
        return armazenamento.listaConta(cpfA, tipoA);
    }

}
