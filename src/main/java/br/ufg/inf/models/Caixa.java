package br.ufg.inf.models;

import br.ufg.inf.support.ConsoleHelper;
import br.ufg.inf.support.MenuCaixa;

import static br.ufg.inf.support.ConsoleHelper.limpaConsole;

public class Caixa {
    private int numero;
    private Empregado empregado;
    private boolean aberto;
    private MenuCaixa menu;
    private int opcaoMenu;

    public Caixa(int numero, Empregado empregado) {
        this.numero = numero;
        this.empregado = empregado;
        this.aberto = true;
        this.menu = new MenuCaixa();
    }

    public int getNumero() {
        return numero;
    }

    public void fecharCaixa(){
        this.aberto = false;
    }

    public void menu(){
        do{
            this.menu.imprimeMenu();
            opcaoMenu = ConsoleHelper.getInputInteiro();
            limpaConsole();

        }while(opcaoMenu != 0);
    }
}
