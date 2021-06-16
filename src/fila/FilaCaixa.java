package fila;

import java.util.Optional;
import java.util.PriorityQueue;

public class FilaCaixa {
    private PriorityQueue<SenhaCliente> fila = new PriorityQueue<>();

    public FilaCaixa() {
    }

    public String adicionar(boolean hasPrioridade) {
        SenhaCliente cliente = hasPrioridade ? new ClientePrioridade() : new ClienteNormal();

        fila.offer(cliente);
        return cliente.getSenha();
    }

    public Optional<String> chamarProximo() {
        return fila.isEmpty() ? Optional.empty() : Optional.of(fila.poll().getSenha());
    }

    public Optional<String> previewProximo() {
        return fila.isEmpty() ? Optional.empty() : Optional.of(fila.peek().getSenha());
    }
}
