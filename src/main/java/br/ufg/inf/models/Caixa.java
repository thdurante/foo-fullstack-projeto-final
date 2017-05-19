package br.ufg.inf.models;

import br.ufg.inf.support.ConsoleHelper;
import br.ufg.inf.support.MenuCaixa;

import static br.ufg.inf.support.ConsoleHelper.getInputString;
import static br.ufg.inf.support.ConsoleHelper.limpaConsole;
import static br.ufg.inf.support.ConsoleHelper.validaOpcaoMenu;

public class Caixa {
    private int numero;
    private Empregado empregado;
    private Supermercado supermercado;
    private boolean aberto;
    private MenuCaixa menu;
    private int opcaoMenu;

    public Caixa(int numero, Empregado empregado, Supermercado supermercado) {
        this.numero = numero;
        this.empregado = empregado;
        this.supermercado = supermercado;
        this.aberto = true;
        this.menu = new MenuCaixa();
    }

    public int getNumero() {
        return numero;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void fecharCaixa() {
        this.aberto = false;
    }

    public void menu() {
        do {
            this.menu.imprimeMenu();
            opcaoMenu = ConsoleHelper.getInputInteiro();
            validaOpcaoMenu(MenuCaixa.class, opcaoMenu);

            switch (MenuCaixa.OpcaoCaixa.getOpcaoFromCodigo(opcaoMenu)) {
                case VOLTAR:
                    limpaConsole();
                    break;
                case ALOCAR_FUNCIONARIO:
                    System.out.print("Informe o código do funcionário: ");
                    String codigo = getInputString();
                    Empregado empregado = this.supermercado.buscaEmpregadoPeloCodigo(codigo);

                    if (empregado == null) {
                        System.out.println("Nenhum empregado foi encontrado com o código informado. Tente novamente.");
                    } else if (this.supermercado.getEmpregadosNoCaixa().contains(empregado)) {
                        System.out.println("O empregado com o código informado já está alocado em um caixa. Tente novamente.");
                    } else {
                        this.empregado = empregado;
                        System.out.println("Empregado com o código " + empregado.getCodigo() + " foi alocado ao caixa de número " + this.numero + " com sucesso!");
                    }

                    limpaConsole();
                    break;
            }
        } while (opcaoMenu != 0);
    }
}
