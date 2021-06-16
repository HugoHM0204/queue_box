package fila;

import java.util.LinkedList;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class FilaCaixa {
    private Queue<SenhaCliente> filaNormal = new LinkedList<>();
    private Queue<SenhaCliente> filaPrioridade = new LinkedList<>();

    private boolean priorityTurn = true;

    public FilaCaixa() {
    }

    public String adicionar(boolean hasPrioridade) {
        SenhaCliente cliente;

        if (hasPrioridade) {
            cliente = new ClientePrioridade();
            filaPrioridade.offer(cliente);
        } else {
            cliente = new ClienteNormal();
            filaNormal.offer(cliente);

        }
        return cliente.getSenha();
    }

    public boolean isPriorityTurn() {
        boolean aux = priorityTurn;

        priorityTurn = !priorityTurn;

        return aux;
    }

    public Optional<String> chamarProximo() {
        if (isPriorityTurn() && !filaPrioridade.isEmpty()) {
            return Optional.of(filaPrioridade.poll().getSenha());
        } else {
            return filaNormal.isEmpty() ? Optional.empty() : Optional.of(filaNormal.poll().getSenha());
        }
    }
}
