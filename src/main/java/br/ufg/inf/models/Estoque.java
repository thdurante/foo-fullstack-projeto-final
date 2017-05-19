package br.ufg.inf.models;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionaProduto(Produto produto){
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto){
        this.produtos.remove(produto);
    }

    public Produto getProduto(int indice){
        return this.produtos.get(indice);
    }

    public Produto getProduto(String codigo) {
        Produto produto = null;
        for (Produto p : this.produtos) {
            if(p.getCodigo().equals(codigo)) produto = p;
        }
        return produto;
    }

    public int getIndice(Produto produto){
        return this.produtos.indexOf(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
