package br.ufg.inf.exceptions;

public class VendaCanceladaException extends RuntimeException {

    public VendaCanceladaException() {
        super("A venda foi cancelada pelo usuário");
    }
}
