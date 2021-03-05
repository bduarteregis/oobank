package br.com.estudo.oobank.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TitularTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void criarClasse() {
        Map<String, String> titularMap = new HashMap<>();
        titularMap.put("nome", "Teste");
        titularMap.put("cpf", "99999999999");

        Titular titular = null;
        try {
            titular = Titular.converte(titularMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("99999999999", titular.getCpf() );
        assertEquals("Teste", titular.getNome());
    }

    @Test
    public void criarClasseSemNome() {
        Assertions.assertThrows(Exception.class, () ->{
            Map<String, String> titularMap = new HashMap<>();
            titularMap.put("cpf", "99999999999");
            Titular.converte(titularMap);
        });
    }

    @Test
    public void criarClasseSemCPF() {
        Assertions.assertThrows(Exception.class, () ->{
            Map<String, String> titularMap = new HashMap<>();
            titularMap.put("nome", "Teste");
            Titular.converte(titularMap);
        });
    }
}