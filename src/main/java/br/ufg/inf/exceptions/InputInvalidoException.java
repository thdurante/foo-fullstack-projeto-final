package br.ufg.inf.exceptions;

public class InputInvalidoException extends RuntimeException {

    public InputInvalidoException(String mensagem) {
        super(mensagem);
    }

    public InputInvalidoException() {
        super("Input inválido! Tente novamente: ");
    }
}
