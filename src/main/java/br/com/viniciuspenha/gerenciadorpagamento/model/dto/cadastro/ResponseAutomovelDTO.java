package br.com.viniciuspenha.gerenciadorpagamento.model.dto.cadastro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAutomovelDTO {

    private Long id;
    private String marca;
    private String modelo;
    private BigDecimal valor;
    private LocalDateTime dataCadastro;
}