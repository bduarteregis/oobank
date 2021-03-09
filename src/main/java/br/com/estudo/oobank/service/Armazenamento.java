package br.com.estudo.oobank.service;

import br.com.estudo.oobank.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class Armazenamento {

    public List<Conta> contas = new ArrayList<Conta>();

    public List<Cliente> clientes = new ArrayList<Cliente>();

    public List<Cliente> novoCliente(Cliente cliente) {
        if (cliente.getTitular().getCpf() != null) {
            Cliente novoCliente = new Cliente();
            novoCliente.setTitular(cliente.getTitular());
            novoCliente.setEndereco(cliente.getEndereco());
            novoCliente.setContas(cliente.getContas());
            clientes.add(novoCliente);
            return clientes;
        }
        return null;
    }

    public Conta novaConta(Conta conta) {
        contas.add(conta);
        return conta;
    }

    public Conta listaConta(String cpf,
                            String tipo) {
        for (Conta conta : contas) {
            if (conta.getTitular().getCpf().equals(cpf) && conta.getTipo().equals(tipo)) {
                return conta;
            }
        }
        return null;
    }

    public List<Conta> listaContasCliente(String cpf) {
        List<Conta> contasCliente = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getTitular().getCpf().equals(cpf)) {
                contasCliente = cliente.getContas();
                return contasCliente;
            }
        }
        return null;
    }

    public Cliente listaCliente(String cpf) {
        for(Cliente cliente : clientes) {
            if (cliente.getTitular().getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listaClientes() {
        return clientes;
    }

}
