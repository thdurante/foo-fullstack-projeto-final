package br.ufg.inf.models;

/**
 * Created by paulo on 18/05/17.
 */
public class Caixa {
    private int numero;
    private Empregado empregado;
    private boolean aberto;

    public Caixa(int numero, Empregado empregado) {
        this.numero = numero;
        this.empregado = empregado;
        this.aberto = true;
    }

    public void fecharCaixa(){
        this.aberto = false;
    }



}
