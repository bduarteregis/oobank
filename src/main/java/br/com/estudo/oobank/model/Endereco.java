package br.com.estudo.oobank.model;

import org.springframework.stereotype.Component;

@Component

public class Endereco extends Titular{

    public String cep;
    public String logradouro;
    public String bairro;
    public String localidade;
    public String uf;

}
