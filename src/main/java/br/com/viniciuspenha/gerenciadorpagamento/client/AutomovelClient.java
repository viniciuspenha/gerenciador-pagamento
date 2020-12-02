package br.com.viniciuspenha.gerenciadorpagamento.client;

import br.com.viniciuspenha.gerenciadorpagamento.model.dto.cadastro.ResponseAutomovelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("gerenciador-cadastro")
public interface AutomovelClient {

    @GetMapping("/automovel/{id}")
    ResponseAutomovelDTO getAutomovelById(@PathVariable("id") Long id);
}