package br.ufg.inf.support;

import static br.ufg.inf.support.MenuCaixa.OpcaoCaixa.VENDER_CARTAO;
import static br.ufg.inf.support.MenuCaixa.OpcaoCaixa.VENDER_DINHEIRO;

public enum TipoVenda {
    CARTAO(VENDER_CARTAO.getCodigo()),
    DINHEIRO(VENDER_DINHEIRO.getCodigo());

    private int codigo;

    TipoVenda(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoPeloCodigo(int codigo) {
        if (codigo == CARTAO.codigo) {
            return "Cartão";
        } else {
            return "Dinheiro";
        }
    }

    public String toString() {
        return this.getTipoPeloCodigo(codigo);
    }
}
