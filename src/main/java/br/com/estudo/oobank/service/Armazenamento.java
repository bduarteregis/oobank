package br.com.estudo.oobank.service;

import br.com.estudo.oobank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    public List<Conta> novaConta(Titular titular,
                                 int agencia,
                                 int numero) {
        Conta conta = new Conta();
        conta.setTitular(titular);
        conta.setAgencia(agencia);
        conta.setNumero(numero);
        contas.add(conta);
        return contas;
    }

//    public List<Conta> atualizaSaldo(int agencia,
//                                     int numero,
//                                     double saldo) {
//        for(Conta conta : contas) {
//            if (conta.getAgencia() == agencia && conta.getNumero() == numero) {
//                conta.setSaldo(saldo);
//                return contas;
//            }
//        }
//        return null;
//    }

    public List<Conta> listaConta(Titular titular) {
        for(Cliente cliente : clientes) {
            if (cliente.getTitular() == titular) {
                return cliente.getContas();
            }
        }
        return null;
    }

    public List<Conta> listaContas() {
        for (Cliente cliente : clientes) {
            return cliente.getContas();
        }
        return null;
    }

    public Cliente listaCliente(String cpf) {
        for(Cliente cliente : clientes) {
            if (cliente.getTitular().getCpf() == cpf) {
                cliente.getTitular();
                cliente.getEndereco();
                cliente.getContas();
                return cliente;
            }
        }
        return null;
    }


}
