package io.github.lucasfrancobn.soap_api.feign;

import io.github.lucasfrancobn.soap_api.dto.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping(value = "/{cep}/xml/", consumes = "application/xml")
    ViaCepResponse buscarEnderecoPorCep(@PathVariable String cep);
}
