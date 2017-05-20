package br.ufg.inf.support.exceptions;

public class InputInvalidoException extends RuntimeException {

    public InputInvalidoException(String mensagem) {
        super(mensagem);
    }

    public InputInvalidoException() {
        super("Input inválido! Tente novamente: ");
    }
}
