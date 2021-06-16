import fila.FilaCaixa;
import fila.SenhaCliente;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Scanner;

public class App {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int op;

        FilaCaixa fila = new FilaCaixa();

        while (true) {

            System.out.println(" Opção 1 - Chamar próximo Cliente\n Opção 2 - Retirar Nova Senha");
            op = scan.nextInt();

            if (op == 1) {

                Optional<String> proximo = fila.chamarProximo();
                if (proximo.isPresent()) {
                    System.out.println("Próximo Cliente se Apresente\nSenha: " + proximo.get());
                } else {
                    System.out.println("Não tem nenhum ser humano na fila");
                }

            } else if (op == 2) {

                System.out.println("Tem Prioridade?\n1 - Sim\n2 - Não");
                int priority = scan.nextInt();
                boolean hasPrioridade;
                if (priority == 1) {

                    hasPrioridade = true;

                } else if (priority == 2) {

                    hasPrioridade = false;

                } else {

                    System.out.println("Opção fornecida inválida.");
                    continue;

                }

                System.out.println("Senha Retirada: " + fila.adicionar(hasPrioridade));

            } else {

                System.out.println("Finalizando a sessão atual do programa.");
                break;

            }
        }
    }
}
