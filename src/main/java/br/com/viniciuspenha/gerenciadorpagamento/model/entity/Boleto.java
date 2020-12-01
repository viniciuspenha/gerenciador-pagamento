package br.com.viniciuspenha.gerenciadorpagamento.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "boleto")
public class Boleto {

    @Id
    private UUID codigo;

    private Long automovelId;
    private Integer marcaId;
    private Integer modeloId;
    private BigDecimal valor;
    private LocalDate vencimento;

    @Enumerated(EnumType.STRING)
    private StatusBoleto status;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;
}