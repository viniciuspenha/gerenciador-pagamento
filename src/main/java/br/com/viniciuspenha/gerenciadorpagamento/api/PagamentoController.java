package br.com.viniciuspenha.gerenciadorpagamento.api;

import br.com.viniciuspenha.gerenciadorpagamento.model.dto.RequestBoletoDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.dto.ResponseBoletoDTO;
import br.com.viniciuspenha.gerenciadorpagamento.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    private final BoletoService boletoService;

    @Autowired
    public PagamentoController(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    @PostMapping("/boleto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseBoletoDTO geraBoleto(@RequestBody RequestBoletoDTO requestBoletoDTO) {
        boletoService.geraBoleto(requestBoletoDTO);
        // mapear boleto para ResponseBoletoDTO
        return null;
    }
}