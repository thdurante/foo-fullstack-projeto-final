package br.ufg.inf.support;

import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner scan = new Scanner(System.in);

    public static void limpaConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public static int getInputInteiro() {
        while (!scan.hasNextInt()) {
            System.out.print("Input inválido! Tente novamente: ");
            scan.next();
        }

        return scan.nextInt();
    }

    public static double getInputDouble() {
        while (!scan.hasNextDouble()) {
            System.out.print("Input inválido! Tente novamente: ");
            scan.next();
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

    public static void validaOpcaoMenu(Class<?> clazz, int opcao) {
        String opcaoInvalida = "Opção inválida! Tente novamente: ";

        if (clazz == MenuInicial.class) {
            while (MenuInicial.Opcao.getOpcaoFromCodigo(opcao) == null) {
                System.out.print(opcaoInvalida);
                opcao = getInputInteiro();
            }
        }
        else if (clazz == MenuCaixa.class) {
            while (MenuCaixa.OpcaoCaixa.getOpcaoFromCodigo(opcao) == null) {
                System.out.print(opcaoInvalida);
                opcao = getInputInteiro();
            }
        }
        else if (clazz == MenuGerente.class) {
            while(MenuGerente.Opcao.getOpcaoFromCodigo(opcao) == null) {
                System.out.print(opcaoInvalida);
                opcao = getInputInteiro();
            }
        }
    }
}
