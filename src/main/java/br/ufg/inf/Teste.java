package br.ufg.inf;

import br.ufg.inf.models.*;
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
        supermercado.adicionaEmpregado(new Gerente("Gerente", 2570.32, supermercado));
        supermercado.adicionaEmpregado(new Funcionario("Funcionário 1", 0.2));
        supermercado.adicionaEmpregado(new Funcionario("Funcionário 2", 0.2));
        supermercado.adicionaEmpregado(new Funcionario("Funcionário 3", 0.2));
        supermercado.adicionaEmpregado(new Funcionario("Funcionário 4", 0.2));
        supermercado.adicionaEmpregado(new Funcionario("Funcionário 5", 0.2));
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
                    inicializaSupermercado();
                    System.out.println("Supermercado inicializado com dados padrões.");
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
                    Gerente gerente = supermercado.getGerente();
                    if (gerente == null) {
                        System.out.println("O supermercado ainda não possui Gerente. " +
                                "\nAdicione um Gerente ou inicialize o supermercado!");
                        limpaConsole();
                        break;
                    }
                    limpaConsole();
                    gerente.menu();
                    break;
                case MENU_CAIXA:
                    System.out.println("menu caixa");
                    limpaConsole();
                    Empregado e1 = new Funcionario("Paulo", 400);
                    Caixa c1 = new Caixa(1, e1);
                    c1.menu();
                    break;
            }
        } while (opcaoMenuInicial != 0);
    }
}
