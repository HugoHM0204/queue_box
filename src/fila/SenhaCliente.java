package fila;

public interface SenhaCliente {
    int getCodigo();
    int getProximoCodigo();
    String getPrefixo();
    default String getSenha() {
        return String.format("%s-%03d", getPrefixo(), getCodigo());
    }
}