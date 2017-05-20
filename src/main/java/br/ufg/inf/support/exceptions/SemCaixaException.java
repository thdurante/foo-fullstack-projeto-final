package br.ufg.inf.support.exceptions;

import br.ufg.inf.models.Supermercado;

/**
 * Created by paulo on 20/05/17.
 */
public class SemCaixaException extends Exception{
    public SemCaixaException(String mensagem){
        super(mensagem);
    };
}
