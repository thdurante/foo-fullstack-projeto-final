package br.ufg.inf.models;

/**
 * Created by paulo on 18/05/17.
 */
public abstract class Empregado {

    protected int codigo;
    protected String nome;
    protected double salarioBase = 2000;

    public Empregado(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public abstract double getSalario();
}
