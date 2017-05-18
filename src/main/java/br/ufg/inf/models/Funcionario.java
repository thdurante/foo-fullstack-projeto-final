package br.ufg.inf.models;

/**
 * Created by paulo on 18/05/17.
 */
public class Funcionario extends Empregado {

    private double comissao;
    private int numVendas = 0;

    public Funcionario(int codigo, String nome, double comissao) {
        super(codigo, nome);
        this.numVendas = 0;
        this.comissao = comissao;
    }

    public void addVenda(){
        this.numVendas = numVendas + 1;
    }

    public double getSalario(){
        return super.salarioBase + (this.comissao * numVendas);
    }
}
