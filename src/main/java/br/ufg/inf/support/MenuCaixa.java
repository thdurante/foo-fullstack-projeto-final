package br.ufg.inf.support;

/**
 * Created by paulo on 18/05/17.
 */
public class MenuCaixa extends Menu {

    public enum OpcaoCaixa {
        SAIR(0),
        VOLTAR(1),
        VENDER_CARTAO(2),
        VENDER_DINHEIRO(3);

        private int codigo;

        OpcaoCaixa(int codigo) {
            this.codigo = codigo;
        }

        public int getCodigo() {
            return codigo;
        }

        public static MenuCaixa.OpcaoCaixa getOpcaoFromCodigo(int codigo) {
            for (MenuCaixa.OpcaoCaixa o : MenuCaixa.OpcaoCaixa.values()) {
                if (o.getCodigo() == codigo) return o;
            }

            return null;
        }
    }


    @Override
    public void imprimeMenu() {
        System.out.println("---------- CAIXA ----------");

        for (MenuCaixa.OpcaoCaixa o : MenuCaixa.OpcaoCaixa.values()) {
            System.out.println(String.format("[%d] - %s", o.getCodigo(), o.toString()));
        }

        System.out.println("----------------------------------");
        System.out.print("Selecione a opção desejada: ");
    }
}
