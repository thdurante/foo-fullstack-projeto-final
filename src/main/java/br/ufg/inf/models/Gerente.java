package br.ufg.inf.models;

import br.ufg.inf.support.ConsoleHelper;
import br.ufg.inf.support.MenuGerente;
import br.ufg.inf.support.UnidadeDeMedida;

import static br.ufg.inf.support.ConsoleHelper.limpaConsole;
import static br.ufg.inf.support.ConsoleHelper.validaOpcaoMenu;

public class Gerente extends Empregado {

    private double bonus;
    private Supermercado supermercado;
    private MenuGerente menu;
    private int opcaoMenu;

    public Gerente(String nome, double bonus, Supermercado supermercado) {
        super(nome);
        this.bonus = bonus;
        this.supermercado = supermercado;
        this.menu = new MenuGerente();
    }

    public double getSalario() {
        return super.salarioBase + this.bonus;
    }

    public void menu() {
        do {
            this.menu.imprimeMenu();
            opcaoMenu = ConsoleHelper.getInputInteiro();
            validaOpcaoMenu(MenuGerente.class, opcaoMenu);

            Estoque estoque = this.supermercado.getEstoque();

            switch (MenuGerente.Opcao.getOpcaoFromCodigo(opcaoMenu)) {
                case VOLTAR:
                    limpaConsole();
                    break;
                case LISTAR_PRODUTOS:
                    for (Produto p : estoque.getProdutos()) {
                        System.out.println("\n" + p + "\n");
                    }
                    limpaConsole();
                    break;
                case ADICIONAR_PRODUTO:
                    // Ler o código do produto, se achar o produto, setar quantidade a ser adicionada.
                    // Se não encontrar pelo código, cadastrar todos os outros atributos como um novo produto

                    limpaConsole();
                    break;
            }
        } while (opcaoMenu != 0);
    }

    public String toString() {
        return "GERENTE [" + this.codigo + "] ----------------------" +
                "\nNome: " + this.nome + " | Salário base: " + this.salarioBase + " | Salário: " + this.getSalario() +
                "\nBônus: " + this.bonus;
    }
}
