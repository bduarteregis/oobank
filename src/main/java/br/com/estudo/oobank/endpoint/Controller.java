package br.com.estudo.oobank.endpoint;

import br.com.estudo.oobank.service.Operacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

    @Autowired
    public Operacoes operacoes;

    @Autowired
    public ViaCepClient viaCepClient;

    @GetMapping("/oobank/gerente/novoCliente/")
    public ResponseEntity novoCliente(@RequestParam("nome") String nome,
                                    @RequestParam("cpf") String cpf,
                                    @RequestParam("cep") String cep,
                                    @RequestParam("agencia") int agencia,
                                    @RequestParam("numero") int numero) {
        return new ResponseEntity(operacoes.novoCliente(nome, cpf, cep, agencia, numero), HttpStatus.OK);
    }

    @GetMapping("/oobank/gerente/listaConta/")
    public ResponseEntity listaConta(@RequestParam("cpf") String cpf,
                                     @RequestParam("tipo") String tipo) {
        return new ResponseEntity(operacoes.listarConta(cpf, tipo), HttpStatus.OK);
    }

    @GetMapping("/oobank/gerente/listaContas/")
    public ResponseEntity listaContas(@RequestParam("cpf") String cpf) {
        return new ResponseEntity(operacoes.listarContas(cpf), HttpStatus.OK);
    }

    @GetMapping("/oobank/gerente/listaCliente/")
    public ResponseEntity listaCliente(@RequestParam("cpf") String cpf) {
        return new ResponseEntity(operacoes.listarCliente(cpf), HttpStatus.OK);
    }

    @GetMapping("/oobank/gerente/listaClientes/")
    public ResponseEntity listaClientes() {
        return new ResponseEntity(operacoes.listarClientes(), HttpStatus.OK);
    }

    @GetMapping("/oobank/deposita/")
    public ResponseEntity deposita(@RequestParam("cpf") String cpf,
                                   @RequestParam("tipo") String tipo,
                                   @RequestParam("valor") double valor) {
        return new ResponseEntity(operacoes.depositar(cpf, tipo, valor), HttpStatus.OK);
    }

    @GetMapping("/oobank/saca/")
    public ResponseEntity saca(@RequestParam("cpf") String cpf,
                                   @RequestParam("tipo") String tipo,
                                   @RequestParam("valor") double valor) {
        return new ResponseEntity(operacoes.sacar(cpf, tipo, valor), HttpStatus.OK);
    }

    @GetMapping("/oobank/transfere/")
    public ResponseEntity transfere(@RequestParam("cpfA") String cpfA,
                               @RequestParam("tipoA") String tipoA,
                               @RequestParam("cpfB") String cpfB,
                               @RequestParam("tipoB") String tipoB,
                               @RequestParam("valor") double valor) {
        return new ResponseEntity(operacoes.transferir(cpfA, tipoA, cpfB, tipoB, valor), HttpStatus.OK);
    }

}
