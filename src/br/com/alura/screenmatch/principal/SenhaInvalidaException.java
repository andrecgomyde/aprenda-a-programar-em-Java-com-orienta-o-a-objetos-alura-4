package br.com.alura.screenmatch.principal;

public class SenhaInvalidaException extends RuntimeException {

    public SenhaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
