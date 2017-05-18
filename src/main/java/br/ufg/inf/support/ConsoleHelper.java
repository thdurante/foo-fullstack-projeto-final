package br.ufg.inf.support;

import java.util.Scanner;

/**
 * Created by paulo on 18/05/17.
 */
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

    public static void validaOpcaoMenu(Class<?> clazz, int opcaoMenuInicial) {
        String opcaoInvalida = "Opção inválida! Tente novamente: ";

        if (clazz == MenuInicial.class) {
            while (MenuInicial.Opcao.getOpcaoFromCodigo(opcaoMenuInicial) == null) {
                System.out.print(opcaoInvalida);
                opcaoMenuInicial = getInputInteiro();
            }
        }
    }
}
