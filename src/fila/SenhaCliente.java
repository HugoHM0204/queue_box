package fila;

public interface SenhaCliente extends Comparable<SenhaCliente> {
    int getPrioridade();
    int getCodigo();
    int getProximoCodigo();
    String getPrefixo();
    default String getSenha() {
        return String.format("%s-%03d", getPrefixo(), getCodigo());
    }
}