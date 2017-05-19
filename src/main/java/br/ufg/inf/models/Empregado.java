package br.ufg.inf.models;

import java.util.UUID;

public abstract class Empregado {

    protected String codigo;
    protected String nome;
    protected double salarioBase = 2000;

    public Empregado(String nome){
        this.codigo = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double getSalario();
}
