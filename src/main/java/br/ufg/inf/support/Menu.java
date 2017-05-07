package br.ufg.inf.support;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu {

    /*
    * Key: código da opção,
    * Value: Mensagem que aparece no menu
    * */
    protected Map<Integer, String> menu;

    public Menu() {
        this.menu = new HashMap<>();
    }

    public abstract void imprimeMenu();
}
