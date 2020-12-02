package br.com.viniciuspenha.gerenciadorpagamento.exception;

public class AutomovelNotFoundException extends Exception {

    public AutomovelNotFoundException() {
        super("Automovel nao encontrado!");
    }
}