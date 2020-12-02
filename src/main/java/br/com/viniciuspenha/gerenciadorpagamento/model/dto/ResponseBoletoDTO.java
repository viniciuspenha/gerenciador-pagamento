package br.com.viniciuspenha.gerenciadorpagamento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBoletoDTO {

    private UUID codigo;
    private LocalDate vencimento;
    private BigDecimal valor;
}