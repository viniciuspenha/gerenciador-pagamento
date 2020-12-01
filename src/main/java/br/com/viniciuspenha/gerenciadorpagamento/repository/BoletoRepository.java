package br.com.viniciuspenha.gerenciadorpagamento.repository;

import br.com.viniciuspenha.gerenciadorpagamento.model.entity.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, UUID> {


}