package br.com.estudo.oobank.endpoint;

import br.com.estudo.oobank.service.executa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

    @Autowired
    public executa executa;

    @GetMapping("/oobank/criaConta/")
    public ResponseEntity criaConta(@RequestParam("titular") String titular,
                                    @RequestParam("agencia") int agencia,
                                    @RequestParam("numero") int numero,
                                    @RequestParam("saldo") double saldo) {
        return new ResponseEntity(executa.criarConta(titular, agencia, numero, saldo), HttpStatus.OK);
    }
}
