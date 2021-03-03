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

//    @GetMapping("/oobank/deposita/")
//    public ResponseEntity deposita(@RequestParam("agencia") int agencia,
//                                   @RequestParam("numero") int numero,
//                                   @RequestParam("valor") double valor) {
//        return new ResponseEntity(executa.depositar(agencia, numero, valor), HttpStatus.OK);
//    }

//    @GetMapping("/oobank/saca/")
//    public ResponseEntity saca(@RequestParam("agencia") int agencia,
//                               @RequestParam("numero") int numero,
//                               @RequestParam("valor") double valor) {
//        return new ResponseEntity(executa.sacar(agencia, numero, valor), HttpStatus.OK);
//    }

//    @GetMapping("/oobank/transfere/")
//    public ResponseEntity transfere(@RequestParam("agenciaA") int agenciaA,
//                               @RequestParam("numeroA") int numeroA,
//                               @RequestParam("agenciaB") int agenciaB,
//                               @RequestParam("numeroB") int numeroB,
//                               @RequestParam("valor") double valor) {
//        return new ResponseEntity(executa.transferir(agenciaA, numeroA, agenciaB, numeroB, valor), HttpStatus.OK);
//    }

    @GetMapping("/oobank/gerente/listaContas")
    public ResponseEntity listaContas() {
        return new ResponseEntity(operacoes.listarContas(), HttpStatus.OK);
    }
}
