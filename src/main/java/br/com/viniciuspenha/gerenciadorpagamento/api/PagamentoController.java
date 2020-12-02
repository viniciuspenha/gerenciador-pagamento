package br.com.viniciuspenha.gerenciadorpagamento.api;

import br.com.viniciuspenha.gerenciadorpagamento.exception.AutomovelNotFoundException;
import br.com.viniciuspenha.gerenciadorpagamento.model.dto.RequestBoletoDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.dto.ResponseBoletoDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.mapper.BoletoMapper;
import br.com.viniciuspenha.gerenciadorpagamento.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    private final BoletoService boletoService;
    private final BoletoMapper boletoMapper;

    @Autowired
    public PagamentoController(BoletoService boletoService, BoletoMapper boletoMapper) {
        this.boletoService = boletoService;
        this.boletoMapper = boletoMapper;
    }

    @PostMapping("/boleto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseBoletoDTO geraBoleto(@RequestBody RequestBoletoDTO requestBoletoDTO) throws AutomovelNotFoundException {
        return boletoMapper.toResponseBoletoDTO(boletoService.geraBoleto(requestBoletoDTO));
    }
}