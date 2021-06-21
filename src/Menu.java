import fila.FilaCaixa;

import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private FilaCaixa fila = new FilaCaixa();

    private Scanner scan = new Scanner(System.in);

    String str = "=";
    String repeated = str.repeat(35);

    public void init() {
        int op;

        while (true) {
            System.out.print("+" + repeated + "+" + "\n\t\t Menu de Opções\n\n Opção 1 - Chamar próximo Cliente\n Opção 2 - Retirar Nova Senha\n\n" + "+" + repeated + "+\n" + "Digite a opção: ");
            op = scan.nextInt();

            if (op == 1) {
                proximo();
            } else if (op == 2) {
                retirarNovaSenha();
            } else {
                System.out.println("\nOpção Fornecido Inválida, finalizando a sessão atual do programa.\n\n" + "+" + repeated + "+");
                break;
            }
        }
    }

    public void proximo() {
        Optional<String> proximo = fila.chamarProximo();
        if (proximo.isPresent()) {
            System.out.println("\nPróximo cliente da fila, senha: " + proximo.get() + ", se dirija ao caixa.\n\n" + "+" + repeated + "+" + "\n");
        } else {
            System.out.println("\nNão tem mais nenhum cliente na fila, aguarde o próximo cliente chegar.\n\n" + "+" + repeated + "+" + "\n");
        }
    }

    public void retirarNovaSenha() {
        System.out.print("\n+" + repeated + "+" + "\n\t\tTem Prioridade?\n\n1 - Sim\n2 - Não\n\n" + "+" + repeated + "+\n" + "Digite a opção: ");

        int priority = scan.nextInt();
        boolean hasPrioridade;

        if (priority == 1) {
            hasPrioridade = true;
        } else if (priority == 2) {
            hasPrioridade = false;
        } else {
            System.out.println("\nOpção Fornecido Inválida, finalizando a sessão atual do programa.\n" + "+" + repeated + "+\n");
            return;
        }

        System.out.println("\nSenha retirada: " + fila.adicionar(hasPrioridade) + "\n" + "+" + repeated + "+\n");
    }
}
