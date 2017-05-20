package br.ufg.inf.support.exceptions;

public class VendaCanceladaException extends RuntimeException {

    public VendaCanceladaException() {
        super("A venda foi cancelada pelo usuário");
    }
}
