package br.ufg.inf.models;

import br.ufg.inf.support.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static br.ufg.inf.support.MenuHelper.*;
import static br.ufg.inf.support.TipoVenda.CARTAO;
import static br.ufg.inf.support.TipoVenda.DINHEIRO;

public class Caixa {
    private int numero;
    private Funcionario funcionario;
    private Supermercado supermercado;
    private List<Venda> vendas;
    private MenuCaixa menu;
    private int opcaoMenu;
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Caixa(int numero, Funcionario funcionario, Supermercado supermercado) {
        this.numero = numero;
        this.funcionario = funcionario;
        this.supermercado = supermercado;
        this.vendas = new ArrayList<>();
        this.menu = new MenuCaixa();
    }

    public int getNumero() {
        return numero;
    }

    public Empregado getFuncionario() {
        return funcionario;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void adicionaVenda(Venda venda) {
        this.vendas.add(venda);
    }

    private boolean podeEfetuarVenda() {
        if (this.funcionario == null) {
            System.out.println("Este caixa ainda não possui um funcionário alocado para efetuar a venda. Tente novamente após alocar um.");
            return false;
        } else {
            return true;
        }
    }

    private void efetuaVenda(TipoVenda tipoVenda) {

        if (podeEfetuarVenda()) {
            Venda venda = new Venda(this, tipoVenda);
            String codigo = "";

            do {
                codigo = ProdutoHelper.getInputCodigo();

                if (codigo.equals("")) break;

                Produto produto = this.supermercado.getEstoque().getProduto(codigo);

                while (produto == null || produto.getQuantidade() == 0) {
                    System.out.println("O produto com o código informado não está disponível. Tente novamente.");
                    System.out.println("Para encerrar a venda, aperte ENTER");
                    codigo = ProdutoHelper.getInputCodigo();

                    if (codigo.equals("")) break;

                    produto = this.supermercado.getEstoque().getProduto(codigo);
                }

                if (codigo.equals("")) break;

                UnidadeDeMedida unidade = produto.getUnidadeDeMedida();
                double quantidade = ProdutoHelper.getInputQuantidade(unidade);

                while (produto.getQuantidade() < quantidade) {
                    System.out.println("O máximo de unidades/quilos disponíveis para o produto é " + produto.getQuantidade());
                    System.out.println("Para encerrar a venda, digite -1");
                    quantidade = ProdutoHelper.getInputQuantidade(unidade);

                    if (quantidade == -1) break;
                }

                if (quantidade == -1) break;

                supermercado.getEstoque().vendeProduto(produto, quantidade);
                venda.adicionaProduto(produto, quantidade);
            } while (!codigo.equals(""));

            venda.finaliza();

            if (venda.getValorTotal() == 0) {
                System.out.println("A venda foi cancelada pelo usuário.");
                return;
            }

            this.adicionaVenda(venda);
            this.funcionario.adicionaVenda(venda);
            System.out.println("O valor total da venda foi de " + formatter.format(venda.getValorTotal()));

            if (tipoVenda == DINHEIRO) {
                System.out.print("Informe a quantia paga pelo cliente: ");
                double quantiaPagaCliente = getInputDouble();
                calculaTroco(venda, quantiaPagaCliente);
            }
        }
    }

    private void calculaTroco(Venda venda, double quantiaPagaCliente) {
        double custoTotalProdutos = venda.getValorTotal();
        double troco = quantiaPagaCliente - custoTotalProdutos;
        System.out.println("O valor do troco é " + formatter.format(troco));
    }

    public void menu() {
        do {
            this.menu.imprimeMenu();
            opcaoMenu = MenuHelper.getInputInteiro();
            opcaoMenu = validaOpcaoMenu(MenuCaixa.class, opcaoMenu);

            switch (MenuCaixa.OpcaoCaixa.getOpcaoFromCodigo(opcaoMenu)) {
                case VOLTAR:
                    limpaConsole();
                    break;
                case VENDER_CARTAO:
                    efetuaVenda(CARTAO);
                    limpaConsole();
                    break;
                case VENDER_DINHEIRO:
                    efetuaVenda(DINHEIRO);
                    limpaConsole();
                    break;
                case ALOCAR_FUNCIONARIO:
                    System.out.print("Informe o código do funcionário: ");
                    String codigo = getInputString();
                    Funcionario funcionario = (Funcionario) this.supermercado.buscaEmpregadoPeloCodigo(codigo);

                    if (funcionario == null) {
                        System.out.println("Nenhum funcionario foi encontrado com o código informado. Tente novamente.");
                    } else if (this.supermercado.getEmpregadosNoCaixa().contains(funcionario)) {
                        System.out.println("O funcionario com o código informado já está alocado em um caixa. Tente novamente.");
                    } else {
                        this.funcionario = funcionario;
                        System.out.println("Empregado com o código " + funcionario.getCodigo() + " foi alocado ao caixa de número " + this.numero + " com sucesso!");
                    }

                    limpaConsole();
                    break;
            }
        } while (opcaoMenu != 0);
    }
}
