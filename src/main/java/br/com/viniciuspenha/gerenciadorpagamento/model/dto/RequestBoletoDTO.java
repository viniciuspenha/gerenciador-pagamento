package br.com.viniciuspenha.gerenciadorpagamento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBoletoDTO {

    @NotNull(message = "automovelId nao pode ser nulo")
    private Long automovelId;

    @Digits(integer = 10, fraction = 2, message = "Valor inválido. Seguir o padrão <10 dígitos>.<2 dígitos>")
    private BigDecimal valor;

    private LocalDate vencimento;
}