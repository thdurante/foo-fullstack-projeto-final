package br.ufg.inf;

import br.ufg.inf.models.Supermercado;
import br.ufg.inf.support.Menu;
import br.ufg.inf.support.MenuInicial;

import java.util.Scanner;

public class Teste {

    private static Scanner scan = new Scanner(System.in);
    private static Supermercado supermercado = new Supermercado("66.643.683/0001-03", "Supermercado do Seu Zé");
    private static Menu menuInicial = new MenuInicial();
    private static int opcaoMenuInicial = 0;

    private static void limpaConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    private static int getInputInteiro() {
        while (!scan.hasNextInt()) {
            System.out.print("Input inválido! Tente novamente: ");
            scan.next();
        }

        return scan.nextInt();
    }

    private static void validaOpcaoMenu(Class<?> clazz) {
        String opcaoInvalida = "Opção inválida! Tente novamente: ";

        if (clazz == MenuInicial.class) {
            while (MenuInicial.Opcao.getOpcaoFromCodigo(opcaoMenuInicial) == null) {
                System.out.print(opcaoInvalida);
                opcaoMenuInicial = getInputInteiro();
            }
        }
    }

    private static void inicializaSupermercado() {

    }

    public static void main(String[] args) {
        do {
            menuInicial.imprimeMenu();
            opcaoMenuInicial = getInputInteiro();
            validaOpcaoMenu(MenuInicial.class);

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
