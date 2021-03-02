package br.com.estudo.oobank.endpoint;

import br.com.estudo.oobank.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")

public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    Endereco buscaCep(@PathVariable String cep);

}
