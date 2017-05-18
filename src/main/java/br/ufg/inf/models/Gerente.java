package br.ufg.inf.models;

/**
 * Created by paulo on 18/05/17.
 */
public class Gerente extends Empregado {
    private double bonus;

    public Gerente(int codigo, String nome, double bonus) {
        super(codigo, nome);
        this.bonus = bonus;
    }

    public double getSalario(){
        return super.salarioBase + this.bonus;
    }
}
