import fila.FilaCaixa;

import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private FilaCaixa fila = new FilaCaixa();

    private Scanner scan = new Scanner(System.in);

    public void init() {
        int op;

        while (true) {
            System.out.print("+==================================+\n\t\t Menu de Opções\n\n Opção 1 - Chamar próximo Cliente\n Opção 2 - Retirar Nova Senha\n\n+==================================+\nDigite a opção: ");
            op = scan.nextInt();

            if (op == 1) {
                proximo();
            } else if (op == 2) {
                retirarNovaSenha();
            } else {
                System.out.println("\nOpção Fornecido Inválida, finalizando a sessão atual do programa.\n\n+==================================+");
                break;
            }
        }
    }

    public void proximo() {
        Optional<String> proximo = fila.chamarProximo();
        if (proximo.isPresent()) {
            System.out.println("\nPróximo cliente da fila, senha: " + proximo.get() + ", se dirija ao caixa.\n\n+==================================+\n");
        } else {
            System.out.println("\nNão tem mais nenhum cliente na fila, aguarde o próximo cliente chegar.\n\n+==================================+\n");
        }
    }

    public void retirarNovaSenha() {
        System.out.print("\n+==================================+\nTem Prioridade?\n\n1 - Sim\n2 - Não\n\n+==================================+\nDigite a opção: ");

        int priority = scan.nextInt();
        boolean hasPrioridade;

        if (priority == 1) {
            hasPrioridade = true;
        } else if (priority == 2) {
            hasPrioridade = false;
        } else {
            System.out.println("\nOpção Fornecido Inválida, finalizando a sessão atual do programa.\n+==================================+\n");
            return;
        }

        System.out.println("\nSenha retirada: " + fila.adicionar(hasPrioridade) + "\n+==================================+\n");
    }
}
