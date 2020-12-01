package br.com.viniciuspenha.gerenciadorpagamento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBoletoDTO {

    private Long automovelId;
    private String codigo;
    private LocalDate vencimento;
    private BigDecimal valor;
}