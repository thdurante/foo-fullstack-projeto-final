package br.ufg.inf.support;

public class MenuGerente extends Menu {

    public enum Opcao {
        VOLTAR(0),
        LISTAR_PRODUTOS(1),
        ADICIONAR_PRODUTO(2),
        RELATORIO_ESTOQUE(3),
        RELATORIO_VENDAS(4);

        private int codigo;

        Opcao(int codigo) {
            this.codigo = codigo;
        }

        public int getCodigo() {
            return codigo;
        }

        public static MenuGerente.Opcao getOpcaoFromCodigo(int codigo) {
            for (MenuGerente.Opcao o : MenuGerente.Opcao.values()) {
                if (o.getCodigo() == codigo) return o;
            }

            return null;
        }
    }

    public MenuGerente() { }

    @Override
    public void imprimeMenu() {
        System.out.println("---------- MENU GERENTE ----------");

        for (MenuGerente.Opcao o : MenuGerente.Opcao.values()) {
            System.out.println(String.format("[%d] - %s", o.getCodigo(), o.toString()));
        }

        System.out.println("----------------------------------");
        System.out.print("Selecione a opção desejada: ");
    }
}
