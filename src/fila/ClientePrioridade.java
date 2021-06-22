package fila;

public class ClientePrioridade implements SenhaCliente {
    private static final String PREFIXO = "PRI";
    private static int codigoAtual = 0;

    private int codigo;

    ClientePrioridade() {
        codigo = this.getProximoCodigo();
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public int getProximoCodigo() {
        return codigoAtual++;
    }

    @Override
    public String getPrefixo() {
        return PREFIXO;
    }
}
