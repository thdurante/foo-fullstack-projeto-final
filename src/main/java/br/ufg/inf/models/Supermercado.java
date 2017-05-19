package br.ufg.inf.models;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    private String cnpj;
    private String nome;
    private Estoque estoque;
    private List<Empregado> empregados;
    private List<Caixa> caixas;

    public Supermercado(String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.estoque = new Estoque();
        this.empregados = new ArrayList<>();
        this.caixas = new ArrayList<>();
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

    public void adicionaCaixa(Caixa caixa) {
        this.caixas.add(caixa);
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public List<Caixa> getCaixas() {
        return caixas;
    }

    public Gerente getGerente() {
        Gerente gerente = null;
        for (Empregado e : this.empregados) {
            if(e.getClass() == Gerente.class) gerente = (Gerente) e;
        }
        return gerente;
    }

    public void listaEmpregados() {
        if (this.getEmpregados().size() == 0) {
            System.out.println("O supermercado ainda não possui empregados. Inicialize-o e tente novamente.");
            return;
        }

        for (Empregado empregado : this.getEmpregados()) {
            System.out.println("\n" + empregado + "\n");
        }
    }

    public Caixa buscaCaixaPeloNumero(int numeroCaixa) {
        Caixa caixaEncontrado = null;

        for (Caixa caixa : this.getCaixas()) {
            if (caixa.getNumero() == numeroCaixa) {
                caixaEncontrado = caixa;
            }
        }

        return caixaEncontrado;
    }
}
