package br.ufg.inf.models;

import br.ufg.inf.support.MenuHelper;
import br.ufg.inf.support.MenuGerente;
import br.ufg.inf.support.ProdutoHelper;
import br.ufg.inf.support.UnidadeDeMedida;
import java.util.List;

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
            opcaoMenu = validaOpcaoMenu(MenuGerente.class, opcaoMenu);

            Estoque estoque = this.supermercado.getEstoque();

            switch (MenuGerente.Opcao.getOpcaoFromCodigo(opcaoMenu)) {
                case VOLTAR:
                    limpaConsole();
                    break;
                case LISTAR_PRODUTOS:
                    System.out.println(ProdutoHelper.getListagemDeProdutos(estoque));
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

                case RELATORIO_ESTOQUE:
                    System.out.println("\n\n========================== ESTOQUE INICIAL ==========================");
                    System.out.println(supermercado.getEstoqueInicial());

                    System.out.println("\n\n=========================== ESTOQUE FINAL ===========================");
                    System.out.println(ProdutoHelper.getListagemDeProdutos(estoque));
                    limpaConsole();
                    break;

                case RELATORIO_VENDAS:
                    List<Caixa> listaCaixas = supermercado.getCaixas();
                    int contSemVendas = 0;
                    if(listaCaixas.size() > 0){

                        for(Caixa cx: listaCaixas){
                            System.out.println("\n\n");

                            List<Venda> listaVendas = cx.getVendas();
                            if(listaVendas.size() > 0){
                                System.out.println("VENDAS NO CAIXA "+cx.getNumero() );
                                System.out.println("========================================");
                                for(Venda venda: listaVendas){
                                    System.out.println("Responsável pela venda: "+cx.getFuncionario().getNome());
                                    System.out.println("Pagamento: "+venda.getTipoVenda());
                                    System.out.println("Valor: R$"+ venda.getValorTotal());
                                    System.out.println("Data: "+ venda.getData());
                                    System.out.println("----------------------------------------");
                                }
                            }else{
                                contSemVendas++;
                            }

                        }

                        if(contSemVendas >= listaCaixas.size()){
                            System.out.println("O supermercado ainda não fez nenhuma venda!");
                            System.out.println("\n");
                        }

                    } else{
                        System.out.println("O supermercado ainda não possui caixas");
                    }

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
