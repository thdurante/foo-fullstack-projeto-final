package br.ufg.inf.models;

import br.ufg.inf.support.TipoVenda;

import java.util.*;

public class Venda {

    private Caixa caixa;
    private double valorTotal;
    private TipoVenda tipoVenda;
    private Map<Produto, Double> produtosVendidos;
    private Date data;

    public Venda(Caixa caixa, TipoVenda tipoVenda) {
        this.caixa = caixa;
        this.tipoVenda = tipoVenda;
        this.valorTotal = 0;
        this.produtosVendidos = new HashMap<>();
        this.data = new Date();
    }

    public void adicionaProduto(Produto produto, double quantidade) {
        this.produtosVendidos.put(produto, quantidade);
    }

    public void finaliza() {
        for (Map.Entry<Produto, Double> produtoVendido : this.produtosVendidos.entrySet()) {
            this.valorTotal += produtoVendido.getKey().getValor() * produtoVendido.getValue();
        }
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public TipoVenda getTipoVenda() {
        return tipoVenda;
    }

    public Date getData() {
        return data;
    }
}
