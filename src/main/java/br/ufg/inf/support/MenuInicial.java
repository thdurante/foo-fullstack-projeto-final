package br.ufg.inf.support;

import java.util.Map;

public class MenuInicial extends Menu {

    public enum Opcao {
        SAIR(0),
        INICIALIZAR_SUPERMERCADO(1),
        ADICIONAR_GERENTE(2),
        ADICIONAR_FUNCIONARIO(3),
        LISTAR_EMPREGADOS(4),
        MENU_GERENTE(5),
        MENU_CAIXA(6);

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
