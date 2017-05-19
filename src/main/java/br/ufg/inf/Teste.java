package br.ufg.inf;

import br.ufg.inf.models.*;
import br.ufg.inf.support.Menu;
import br.ufg.inf.support.MenuInicial;
import br.ufg.inf.support.UnidadeDeMedida;

import static br.ufg.inf.support.MenuHelper.*;

public class Teste {

    private static Supermercado supermercado = new Supermercado("66.643.683/0001-03", "Supermercado do Seu Zé");
    private static Menu menuInicial = new MenuInicial();
    private static int opcaoMenuInicial = 0;

    private static void inicializaSupermercado() {
        Funcionario funcionarioCaixa1 = new Funcionario("Funcionário 1", 0.2);
        Funcionario funcionarioCaixa2 = new Funcionario("Funcionário 2", 0.2);
        Funcionario funcionarioCaixa3 = new Funcionario("Funcionário 3", 0.2);

        // Empregados
        supermercado.adicionaEmpregado(new Gerente("Gerente", 2570.32, supermercado));
        supermercado.adicionaEmpregado(funcionarioCaixa1);
        supermercado.adicionaEmpregado(funcionarioCaixa2);
        supermercado.adicionaEmpregado(funcionarioCaixa3);
        supermercado.adicionaEmpregado(new Funcionario("Funcionário 4", 0.2));
        supermercado.adicionaEmpregado(new Funcionario("Funcionário 5", 0.2));

        // Caixas
        supermercado.adicionaCaixa(new Caixa(1, funcionarioCaixa1, supermercado));
        supermercado.adicionaCaixa(new Caixa(2, funcionarioCaixa2, supermercado));
        supermercado.adicionaCaixa(new Caixa(3, funcionarioCaixa3, supermercado));

        // Produtos
        Estoque estoque = supermercado.getEstoque();

        estoque.adicionaProduto(new Produto("Shampoo", 12.4, UnidadeDeMedida.UNIDADE, 100));
        estoque.adicionaProduto(new Produto("Laranja", 4.66, UnidadeDeMedida.QUILO, 24));
        estoque.adicionaProduto(new Produto("Azeitona em conserva", 17.5, UnidadeDeMedida.UNIDADE, 13));
        estoque.adicionaProduto(new Produto("Sabão em pó", 13.99, UnidadeDeMedida.UNIDADE, 50));
        estoque.adicionaProduto(new Produto("Banana", 2.75, UnidadeDeMedida.QUILO, 56.9));


        supermercado.setaEstoqueInicial(estoque);
    }

    public static void main(String[] args) {
        do {
            inicializaSupermercado();
            menuInicial.imprimeMenu();
            opcaoMenuInicial = getInputInteiro();
            opcaoMenuInicial = validaOpcaoMenu(MenuInicial.class, opcaoMenuInicial);

            switch (MenuInicial.Opcao.getOpcaoFromCodigo(opcaoMenuInicial)) {
                case SAIR:
                    System.out.println("saindo");
                    limpaConsole();
                    break;
                case LISTAR_EMPREGADOS:
                    supermercado.listaEmpregados();
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
                    System.out.print("Informe o número do caixa: ");
                    int numeroCaixa = getInputInteiro();
                    Caixa caixa = supermercado.buscaCaixaPeloNumero(numeroCaixa);

                    if (caixa == null) {
                        System.out.println("Não foi encontrado nenhum caixa com o número informado. " +
                                "\nPor favor, verifique o número e tente novamente.");
                        limpaConsole();
                        break;
                    }

                    limpaConsole();
                    caixa.menu();
                    break;
            }
        } while (opcaoMenuInicial != 0);
    }
}
