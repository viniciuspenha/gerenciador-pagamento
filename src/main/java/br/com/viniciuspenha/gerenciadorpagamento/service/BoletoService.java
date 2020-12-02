package br.com.viniciuspenha.gerenciadorpagamento.service;

import br.com.viniciuspenha.gerenciadorpagamento.client.AutomovelClient;
import br.com.viniciuspenha.gerenciadorpagamento.exception.AutomovelNotFoundException;
import br.com.viniciuspenha.gerenciadorpagamento.model.dto.RequestBoletoDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.dto.cadastro.ResponseAutomovelDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.entity.Boleto;
import br.com.viniciuspenha.gerenciadorpagamento.model.entity.BoletoStatus;
import br.com.viniciuspenha.gerenciadorpagamento.model.mapper.BoletoMapper;
import br.com.viniciuspenha.gerenciadorpagamento.repository.BoletoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Service
public class BoletoService {

    private final BoletoRepository boletoRepository;
    private final AutomovelClient automovelClient;
    private final BoletoMapper boletoMapper;

    @Autowired
    public BoletoService(BoletoRepository boletoRepository, AutomovelClient automovelClient, BoletoMapper boletoMapper) {
        this.boletoRepository = boletoRepository;
        this.automovelClient = automovelClient;
        this.boletoMapper = boletoMapper;
    }
    
    public Boleto geraBoleto(RequestBoletoDTO requestBoletoDTO) throws AutomovelNotFoundException {
        log.info("BoletoService.geraBoleto - requestBoletoDTO {}", requestBoletoDTO);

        try {
            ResponseAutomovelDTO automovel = automovelClient.getAutomovelById(requestBoletoDTO.getAutomovelId());
            log.info("BoletoService.geraBoleto - automovel encontradp {}", automovel);
            Boleto boleto = boletoMapper.toBoleto(requestBoletoDTO, automovel);
            return boletoRepository.save(boleto);
        } catch (Exception e) {
            log.error("exception", e);
            throw new AutomovelNotFoundException();
        }
    }
}