package br.com.estudo.oobank.model;

import java.util.Map;
import java.util.Objects;

public class Titular {

    private String nome;
    private String cpf;


    private Titular(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public static Titular converte(Map<String, String> map) throws Exception {
        return new Titular(map.get("nome"), map.get("cpf")).valida();
    }

    public static Titular converte(String nome, String cpf) throws Exception {
        return new Titular(nome, cpf).valida();
    }

    private Titular valida() throws Exception{
        if (Objects.isNull(this.cpf)) {
            throw new Exception("Erro cpf");
        }
        if (Objects.isNull(this.nome)){
            throw new Exception("Erro nome");
        }

        return this;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}
