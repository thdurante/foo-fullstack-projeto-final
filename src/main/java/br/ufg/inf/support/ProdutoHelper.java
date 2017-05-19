package br.ufg.inf.support;

import java.util.Scanner;

import static br.ufg.inf.support.ConsoleHelper.getInputDouble;
import static br.ufg.inf.support.ConsoleHelper.getInputInteiro;

public class ProdutoHelper {

    private static Scanner scan = new Scanner(System.in);

    public static String getInputCodigo() {
        System.out.print("\nDigite o código do produto: ");
        return scan.nextLine();
    }

    public static String getInputNome() {
        System.out.print("\nDigite o nome do produto: ");
        String nome = scan.nextLine();
        while(nome.equals("")) {
            System.out.print("Não pode ser vazio!");
            nome = scan.nextLine();
        }
        return nome;
    }
    
    public static double getInputValor() {
        System.out.print("\nDigite o valor do produto: ");
        return ConsoleHelper.getInputDouble();
    }

    public static UnidadeDeMedida getInputUnidade() {
        System.out.print("\nDigite a unidade de medida do produto ['QUILO' ou 'UNIDADE']: ");
        String unidade = scan.nextLine();
        while(unidade.equals("") || !unidade.equals("UNIDADE") || unidade.equals("QUILO")) {
            System.out.println("Não pode ser vazio! Valores aceitos ['QUILO' ou 'UNIDADE']: ");

            unidade = scan.nextLine();
            if (unidade.equals("UNIDADE") || unidade.equals("QUILO")) break;
        }
        return UnidadeDeMedida.valueOf(unidade);
    }

    public static double getInputQuantidade(UnidadeDeMedida unidade) {
        System.out.print("\nDigite a quantidade do produto: ");

        if (unidade == UnidadeDeMedida.QUILO) {
            double qtd = getInputDouble();
            return qtd;
        } else if (unidade == UnidadeDeMedida.UNIDADE) {
            int qtd = getInputInteiro();
            return qtd;
        }
        return 0;
    }
}