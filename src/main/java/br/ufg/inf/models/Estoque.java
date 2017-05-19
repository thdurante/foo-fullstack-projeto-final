package br.ufg.inf.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {

    private HashMap<String,Produto> produtos;

    public Estoque() {
        this.produtos = new HashMap<String,Produto>();
    }

    /**
     * retorna a quantidade de determinado Produto no estoque
     * @param codigoProduto código do Produto que se deseja saber a quantidade
     * @return quantidade do Produto no estoque
     */
    public double getQtdeProduto(String codigoProduto){
        double qtdeProduto = 0;
        Produto produto = produtos.get(codigoProduto);
        try{
            qtdeProduto = produto.getQuantidade();

        }catch (NullPointerException e){
            qtdeProduto = 0;
        }
        return qtdeProduto;
    }


    /**
     * vende uma certa quantidade de determinado produto
     * @param produto produto a ser vendido
     * @param quantidadeVendida quantidade a ser deduzida do total do produto
     */
    public void vendeProduto(Produto produto, double quantidadeVendida) {
        double quantidadeAtual = produto.getQuantidade();

        produto.setQuantidade(quantidadeAtual - quantidadeVendida);
    }

    /**
     * Adiciona produtos no estoque
     * @param produto tipo de produto a ser adicionado
     */
    public void adicionaProduto(Produto produto){
        String codigoProduto = produto.getCodigo();
        double qtdeProduto = 0;
        try{
            //Se já tem algum produto igual no estoque, apenas incrementa a quantidade
            qtdeProduto = this.produtos.get(codigoProduto).getQuantidade();
            qtdeProduto = qtdeProduto + produto.getQuantidade();
            produto.setQuantidade(qtdeProduto);
            produtos.replace(codigoProduto, produto);

            //Se não possui nenhum produto igual no estoque, apenas adiciona o produto
        }catch(NullPointerException e ){
            produtos.put(codigoProduto, produto);
        }

    }

    /**
     * retorna um objeto produto através de seu codigo
     * @param codigoProduto codigo do produto
     * @return objeto Produto
     */
    public Produto getProduto(String codigoProduto) {

        return produtos.get(codigoProduto);
    }


    public HashMap<String, Produto> getProdutos() {
        return produtos;
    }
}
