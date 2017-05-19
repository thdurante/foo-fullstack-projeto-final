package br.ufg.inf.models;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Empregado {

    private double comissao;
    private List<Venda> vendas;

    public Funcionario(String nome, double comissao) {
        super(nome);
        this.comissao = comissao;
        this.vendas = new ArrayList<>();
    }

    public double getSalario() {
        return super.salarioBase + (this.comissao * this.vendas.size());
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void adicionaVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public String toString() {
        return "FUNCIONÁRIO [" + this.codigo + "] ----------------------" +
                "\nNome: " + this.nome + " | Salário base: " + this.salarioBase + " | Salário: " + this.getSalario() +
                "\nComissão: " + this.comissao + " | Número de vendas: " + this.vendas.size();
    }
}
