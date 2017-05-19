package br.ufg.inf.models;

import br.ufg.inf.support.MenuHelper;
import br.ufg.inf.support.MenuGerente;
import br.ufg.inf.support.ProdutoHelper;
import br.ufg.inf.support.UnidadeDeMedida;

import java.util.Collection;
import java.util.HashMap;

import static br.ufg.inf.support.MenuHelper.*;

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
            opcaoMenu = MenuHelper.getInputInteiro();
            validaOpcaoMenu(MenuGerente.class, opcaoMenu);

            Estoque estoque = this.supermercado.getEstoque();

            switch (MenuGerente.Opcao.getOpcaoFromCodigo(opcaoMenu)) {
                case VOLTAR:
                    limpaConsole();
                    break;
                case LISTAR_PRODUTOS:
                    HashMap produtos = estoque.getProdutos();
                    Collection<Produto> listaProdutos = produtos.values();
                    for (Produto p : listaProdutos) {
                        System.out.println(p);
                    }
                    limpaConsole();
                    break;
                case ADICIONAR_PRODUTO:
                    String codigoProduto = ProdutoHelper.getInputCodigo();
                    Produto produto = estoque.getProduto(codigoProduto);

                    if (produto != null) {
                        System.out.print(produto);
                        System.out.print("\nQuantidade do produto a ser adicionada " + produto.getUnidadeDeMedida() + ": ");

                        if (produto.getUnidadeDeMedida() == UnidadeDeMedida.QUILO) {
                            double qtd = getInputDouble();
                            produto.setQuantidade(produto.getQuantidade() + qtd);
                        } else if (produto.getUnidadeDeMedida() == UnidadeDeMedida.UNIDADE) {
                            int qtd = getInputInteiro();
                            produto.setQuantidade(produto.getQuantidade() + qtd);
                        }
                    } else {
                        System.out.println("\nProduto não encontrado!");

                        String nome;
                        double valor;
                        UnidadeDeMedida unidade;
                        double quantidade;

                        nome = ProdutoHelper.getInputNome();
                        valor = ProdutoHelper.getInputValor();
                        unidade = ProdutoHelper.getInputUnidade();
                        quantidade = ProdutoHelper.getInputQuantidade(unidade);

                        estoque.adicionaProduto(new Produto(nome, valor, unidade, quantidade));
                        System.out.println("Produto adicionado com sucesso!");
                    }

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
