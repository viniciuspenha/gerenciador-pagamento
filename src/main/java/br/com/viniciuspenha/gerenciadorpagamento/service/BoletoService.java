package br.com.viniciuspenha.gerenciadorpagamento.service;

import br.com.viniciuspenha.gerenciadorpagamento.model.dto.RequestBoletoDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.entity.Boleto;
import br.com.viniciuspenha.gerenciadorpagamento.repository.BoletoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BoletoService {

    private final BoletoRepository boletoRepository;

    @Autowired
    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }
    
    public Boleto geraBoleto(RequestBoletoDTO requestBoletoDTO) {
        log.info("BoletoService.geraBoleto - requestBoletoDTO {}", requestBoletoDTO);
        //chamar metodo para validar existencia do automovel
        new Boleto();
        return boletoRepository.save(new Boleto());
    }
}