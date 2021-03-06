package br.ufg.inf.support;

public class MenuInicial extends Menu {

    public enum Opcao {
        SAIR(0),
        LISTAR_EMPREGADOS(1),
        LISTAR_PRODUTOS(2),
        CONSULTAR_PRECO_PRODUTO(3),
        MENU_GERENTE(4),
        MENU_CAIXA(5);

        private int codigo;

        Opcao(int codigo) {
            this.codigo = codigo;
        }

        public int getCodigo() {
            return codigo;
        }

        public static Opcao getOpcaoFromCodigo(int codigo) {
            for (Opcao o : Opcao.values()) {
                if (o.getCodigo() == codigo) return o;
            }

            return null;
        }
    }

    public MenuInicial() { }

    @Override
    public void imprimeMenu() {
        System.out.println("---------- MENU INICIAL ----------");

        for (Opcao o : Opcao.values()) {
            System.out.println(String.format("[%d] - %s", o.getCodigo(), o.toString()));
        }

        System.out.println("----------------------------------");
        System.out.print("Selecione a opção desejada: ");
    }
}
