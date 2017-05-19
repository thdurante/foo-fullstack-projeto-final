package br.ufg.inf.models;

import br.ufg.inf.support.ConsoleHelper;
import br.ufg.inf.support.MenuGerente;

import static br.ufg.inf.support.ConsoleHelper.limpaConsole;
import static br.ufg.inf.support.ConsoleHelper.validaOpcaoMenu;

public class Gerente extends Empregado {

    private double bonus;
    private Supermercado supermercado;
    private MenuGerente menu;
    private int opcaoMenu;

    public Gerente(String nome, double bonus, Supermercado supermercado) {
        super(nome);
        this.bonus = bonus;
        this.supermercado = supermercado;
        this.menu = new MenuGerente();
    }

    public double getSalario(){
        return super.salarioBase + this.bonus;
    }

    public void menu(){
        do{
            this.menu.imprimeMenu();
            opcaoMenu = ConsoleHelper.getInputInteiro();
            validaOpcaoMenu(MenuGerente.class, opcaoMenu);
            limpaConsole();

        }while(opcaoMenu != 0);
    }
}
