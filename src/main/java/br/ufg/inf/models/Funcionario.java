package br.ufg.inf.models;

public class Funcionario extends Empregado {

    private double comissao;
    private int numVendas = 0;

    public Funcionario(String nome, double comissao) {
        super(nome);
        this.numVendas = 0;
        this.comissao = comissao;
    }

    public void addVenda(){
        this.numVendas = numVendas + 1;
    }

    public double getSalario(){
        return super.salarioBase + (this.comissao * numVendas);
    }

    public String toString() {
        return "FUNCIONÁRIO [" + this.codigo + "] ----------------------" +
                "\nNome: " + this.nome + " | Salário base: " + this.salarioBase + " | Salário: " + this.getSalario() +
                "\nComissão: " + this.comissao + " | Número de vendas: " + this.numVendas;
    }
}
