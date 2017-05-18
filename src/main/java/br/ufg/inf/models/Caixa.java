package br.ufg.inf.models;

import br.ufg.inf.support.Menu;
import br.ufg.inf.support.MenuCaixa;

/**
 * Created by paulo on 18/05/17.
 */
public class Caixa {
    private int numero;
    private Empregado empregado;
    private boolean aberto;
    private MenuCaixa menu;

    public Caixa(int numero, Empregado empregado) {
        this.numero = numero;
        this.empregado = empregado;
        this.aberto = true;
        this.menu = new MenuCaixa();
    }

    public void fecharCaixa(){
        this.aberto = false;
    }

    public void exibeMenu(){
        this.menu.imprimeMenu();
    }



}
