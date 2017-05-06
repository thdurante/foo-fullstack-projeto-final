package br.ufg.inf.models;

public class Supermercado {

    private String cnpj;
    private String nome;
    private Estoque estoque;

    public Supermercado(String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.estoque = new Estoque();
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }
}
