package br.com.estudo.oobank.endpoint;

import br.com.estudo.oobank.service.Executa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

    @Autowired
    public Executa executa;

    @GetMapping("/oobank/criaConta/")
    public ResponseEntity criaConta(@RequestParam("titular") String titular,
                                    @RequestParam("agencia") int agencia,
                                    @RequestParam("numero") int numero) {
        return new ResponseEntity(executa.criarConta(titular, agencia, numero), HttpStatus.OK);
    }

    @GetMapping("/oobank/deposita/")
    public ResponseEntity deposita(@RequestParam("agencia") int agencia,
                                   @RequestParam("numero") int numero,
                                   @RequestParam("valor") double valor) {
        return new ResponseEntity(executa.depositar(agencia, numero, valor), HttpStatus.OK);
    }

//    @GetMapping("/oobank/saca/")
//    public ResponseEntity saca(@RequestParam("agencia") int agencia,
//                                @RequestParam("numero") int numero,
//                                @RequestParam("valor") double valor) {
//        return new ResponseEntity(executa.sacar(agencia, numero, valor), HttpStatus.OK);
//    }

    @GetMapping("/oobank/gerente/listaContas")
    public ResponseEntity listaContas() {
        return new ResponseEntity(executa.listaContas(), HttpStatus.OK);
    }
}
