package br.ufg.inf;

import br.ufg.inf.models.Supermercado;
import br.ufg.inf.support.Menu;
import br.ufg.inf.support.MenuInicial;

import java.util.Scanner;

import static br.ufg.inf.support.ConsoleHelper.getInputInteiro;
import static br.ufg.inf.support.ConsoleHelper.limpaConsole;
import static br.ufg.inf.support.ConsoleHelper.validaOpcaoMenu;

public class Teste {

    private static Supermercado supermercado = new Supermercado("66.643.683/0001-03", "Supermercado do Seu Zé");
    private static Menu menuInicial = new MenuInicial();
    private static int opcaoMenuInicial = 0;

    private static void inicializaSupermercado() {

    }

    public static void main(String[] args) {
        do {
            menuInicial.imprimeMenu();
            opcaoMenuInicial = getInputInteiro();
            validaOpcaoMenu(MenuInicial.class, opcaoMenuInicial);

            switch (MenuInicial.Opcao.getOpcaoFromCodigo(opcaoMenuInicial)) {
                case SAIR:
                    System.out.println("saindo");
                    limpaConsole();
                    break;
                case INICIALIZAR_SUPERMERCADO:
                    System.out.println("inicializando supermercado");
                    limpaConsole();
                    break;
                case ADICIONAR_GERENTE:
                    System.out.println("adicionando gerente");
                    limpaConsole();
                    break;
                case ADICIONAR_FUNCIONARIO:
                    System.out.println("adicionando funcionario");
                    limpaConsole();
                    break;
                case LISTAR_EMPREGADOS:
                    System.out.println("listando empregados");
                    limpaConsole();
                    break;
                case MENU_GERENTE:
                    System.out.println("menu gerente");
                    limpaConsole();
                    break;
                case MENU_CAIXA:
                    System.out.println("menu caixa");
                    limpaConsole();
                    break;
            }
        } while (opcaoMenuInicial != 0);
    }
}
