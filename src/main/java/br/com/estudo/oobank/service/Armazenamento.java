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
        Cliente novoCliente = new Cliente();
        novoCliente.setTitular(cliente.getTitular());
        novoCliente.setEndereco(cliente.getEndereco());
        novoCliente.setContas(cliente.getContas());
        clientes.add(novoCliente);
        return clientes;
    }

    public Conta novaConta(Conta conta) {
        conta.getTipo();
        conta.getTitular();
        conta.getAgencia();
        conta.getNumero();
        conta.getSaldo();
        contas.add(conta);
        return conta;
    }

    public Conta atualizaSaldo(String cpf,
                                     String tipo,
                                     double saldo) {
        for (Conta conta : contas) {
            if (conta.getTitular().getCpf().equals(cpf) && conta.getTipo().equals(tipo)) {
                conta.setSaldo(saldo);
                return conta;
            }
        }
        return null;
    }

    public List<Conta> listaConta(String cpf) {
        for (Conta conta : contas) {
            if (conta.getTitular().getCpf().equals(cpf)) {
                conta.getTipo();
                conta.getTitular();
                conta.getAgencia();
                conta.getNumero();
                conta.getSaldo();
                return contas;
            }
        }
        return null;
    }

    public List<Conta> listaContas() {
        for (Cliente cliente : clientes) {
            for (Conta conta : contas) {
                if (conta.getTitular() == cliente.getTitular()) {
                    return contas;
                }
            }
        }
        return null;
    }

    public Cliente listaCliente(String cpf) {
        for(Cliente cliente : clientes) {
            if (cliente.getTitular().getCpf().equals(cpf)) {
                cliente.getTitular();
                cliente.getEndereco();
                cliente.getContas();
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listaClientes() {
        for(Cliente cliente : clientes) {
            cliente.getTitular();
            cliente.getEndereco();
            cliente.getContas();
            return clientes;
        }
        return null;
    }

}
