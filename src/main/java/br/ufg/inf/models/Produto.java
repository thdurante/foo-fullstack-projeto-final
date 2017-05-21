package br.ufg.inf.models;

import java.util.UUID;

public class Produto {

    private String codigo;
    private String nome;
    private double valor;
    private UnidadeDeMedida unidadeDeMedida;
    private double quantidade;

    public Produto(String nome, double valor, UnidadeDeMedida unidadeDeMedida, double quantidade) {
        this.codigo = UUID.randomUUID().toString();
        this.nome = nome;
        this.valor = valor;
        this.unidadeDeMedida = unidadeDeMedida;
        this.quantidade = quantidade;
    }



    public Produto(String nome, double valor, UnidadeDeMedida unidadeDeMedida) {
        this.codigo = UUID.randomUUID().toString();
        this.nome = nome;
        this.valor = valor;
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\nPRODUTO [" + this.codigo + "] ----------------------" +
                "\nNome: " + this.nome + " | " +  "R$: " + this.valor + " | " + "Medida: " + this.unidadeDeMedida + " | " + "Qtd: " + this.quantidade + "\n";
    }

}
