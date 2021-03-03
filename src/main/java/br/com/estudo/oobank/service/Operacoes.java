package br.com.estudo.oobank.service;

import br.com.estudo.oobank.model.Cliente;
import br.com.estudo.oobank.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    public Conta depositar(int agencia,
//                     int numero,
//                     double valor) {
//
//        for (Conta conta : listarContas()) {
//            if (conta.getAgencia() == agencia && conta.getNumero() == numero) {
//                conta.setSaldo(conta.getSaldo() + valor);
//                armazenaConta.atualizaSaldo(agencia, numero, conta.getSaldo());
//                return conta;
//            }
//        }
//        return null;
//    }

//    public Conta sacar(int agencia,
//                       int numero,
//                       double valor) {
//
//        for (Conta conta : listarContas()) {
//            if (conta.getAgencia() == agencia && conta.getNumero() == numero) {
//                conta.setSaldo(conta.getSaldo() - valor);
//                armazenaConta.atualizaSaldo(agencia, numero, conta.getSaldo());
//                return conta;
//            }
//        }
//        return null;
//    }

//    public Conta transferir(int agenciaA,
//                            int numeroA,
//                            int agenciaB,
//                            int numeroB,
//                            double valor) {
//
//        sacar(agenciaA, numeroA, valor);
//        depositar(agenciaB, numeroB, valor);
//        return armazenaConta.consulta(agenciaA, numeroA);
//    }

    public List<Conta> listarContas() {
        return armazenamento.listaContas();
    }
}
