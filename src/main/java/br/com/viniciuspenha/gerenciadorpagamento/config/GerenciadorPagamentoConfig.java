package br.com.viniciuspenha.gerenciadorpagamento.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
@EnableJpaAuditing
public class GerenciadorPagamentoConfig {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}