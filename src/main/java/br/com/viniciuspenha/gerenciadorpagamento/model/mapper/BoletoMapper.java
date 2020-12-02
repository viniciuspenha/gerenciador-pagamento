package br.com.viniciuspenha.gerenciadorpagamento.model.mapper;

import br.com.viniciuspenha.gerenciadorpagamento.model.dto.RequestBoletoDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.dto.ResponseBoletoDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.dto.cadastro.ResponseAutomovelDTO;
import br.com.viniciuspenha.gerenciadorpagamento.model.entity.Boleto;
import br.com.viniciuspenha.gerenciadorpagamento.model.entity.BoletoStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class BoletoMapper {

    public Boleto toBoleto(RequestBoletoDTO requestBoletoDTO, ResponseAutomovelDTO automovel) {
        return Boleto.builder()
                .codigo(UUID.randomUUID())
                .automovelId(automovel.getId())
                .valor(requestBoletoDTO.getValor() != null ? requestBoletoDTO.getValor() : automovel.getValor())
                .vencimento(requestBoletoDTO.getVencimento() != null ? requestBoletoDTO.getVencimento() : this.geraVencimentoBoleto())
                .status(BoletoStatus.CRIADO)
                .build();
    }

    public ResponseBoletoDTO toResponseBoletoDTO(Boleto boleto) {
        return new ResponseBoletoDTO(
                boleto.getCodigo(),
                boleto.getVencimento(),
                boleto.getValor()
        );
    }

    private LocalDate geraVencimentoBoleto() {
        return LocalDate.now().plusDays(5);
    }
}