package br.ufg.inf.helpers;

import br.ufg.inf.support.MenuCaixa;
import br.ufg.inf.support.MenuGerente;
import br.ufg.inf.support.MenuInicial;
import br.ufg.inf.exceptions.InputInvalidoException;

import java.util.Scanner;

public class MenuHelper {
    private static Scanner scan = new Scanner(System.in);

    public static void limpaConsole() {
        System.out.println("\n");
    }

    public static int getInputInteiro() {
        while (!scan.hasNextInt()) {
            try {
                if (!scan.hasNextInt()) throw new InputInvalidoException();
            } catch (InputInvalidoException e) {
                System.out.println(e.getMessage());
                scan.next();
            }
        }

        return scan.nextInt();
    }

    public static double getInputDouble() {
        while (!scan.hasNextDouble()) {
            try {
                if (!scan.hasNextDouble()) throw new InputInvalidoException();
            } catch (InputInvalidoException e) {
                System.out.println(e.getMessage());
                scan.next();
            }
        }

        return scan.nextDouble();
    }

    public static String getInputString() {
        scan.nextLine();

        while (!scan.hasNextLine()) {
            System.out.print("Input inválido! Tente novamente: ");
            scan.next();
        }

        return scan.nextLine();
    }

    public static int validaOpcaoMenu(Class<?> clazz, int opcao) {
        String opcaoInvalida = "Opção inválida! Tente novamente: ";

        if (clazz == MenuInicial.class) {
            while (MenuInicial.Opcao.getOpcaoFromCodigo(opcao) == null) {
                System.out.print(opcaoInvalida);
                opcao = getInputInteiro();
            }
            return opcao;
        }
        else if (clazz == MenuCaixa.class) {
            while (MenuCaixa.OpcaoCaixa.getOpcaoFromCodigo(opcao) == null) {
                System.out.print(opcaoInvalida);
                opcao = getInputInteiro();
            }
            return opcao;
        }
        else if (clazz == MenuGerente.class) {
            while(MenuGerente.Opcao.getOpcaoFromCodigo(opcao) == null) {
                System.out.print(opcaoInvalida);
                opcao = getInputInteiro();
            }
            return opcao;
        }
        return 0;
    }
}
