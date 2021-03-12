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
    public ExecutaService executaService;

    public Cliente novoCliente(String nome,
                               String cpf,
                               String cep,
                               int agencia,
                               int numero) throws Exception {

        Cliente cliente = new Cliente();
//        if (Objects.isNull(cpf)) {
//            throw new Exception("Erro cpf");
//        }
        cliente.setTitular(executaService.defineTitular(nome, cpf));
        cliente.setEndereco(executaService.defineEndereco(cep));
        cliente.setContas(executaService.criaContas(cliente.getTitular(), agencia, numero));
        armazenamento.novoCliente(cliente);
        return armazenamento.listaCliente(cpf);

    }

    public Conta listarConta(String cpf,
                                   String tipo) {
        return armazenamento.listaConta(cpf, tipo);
    }

    public List<Conta> listarContasCliente(String cpf) {
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

        return executaService.deposito(cpf, tipo, valor);
    }

    public Conta sacar(String cpf,
                       String tipo,
                       double valor) {

        return executaService.saque(cpf, tipo, valor);
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
