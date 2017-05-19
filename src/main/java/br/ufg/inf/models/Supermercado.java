package br.ufg.inf.models;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    private String cnpj;
    private String nome;
    private Estoque estoque;
    private List<Empregado> empregados;

    public Supermercado(String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.estoque = new Estoque();
        this.empregados = new ArrayList<>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void adicionaEmpregado(Empregado empregado) {
        this.empregados.add(empregado);
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public Gerente getGerente() {
        Gerente gerente = null;
        for (Empregado e : this.empregados) {
            if(e.getClass() == Gerente.class) gerente = (Gerente) e;
        }
        return gerente;
    }
}
