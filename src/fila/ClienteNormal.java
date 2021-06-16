package fila;

public class ClienteNormal implements SenhaCliente {
    private static final String PREFIXO = "NOR";
    private static int codigoAtual = 0;

    private int codigo;

    ClienteNormal() {
        this.codigo = this.getProximoCodigo();
    }

    @Override
    public int getPrioridade() {
        return 1;
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

    @Override
    public int compareTo(SenhaCliente o) {
        if (o.getPrioridade() == this.getPrioridade()) {

            return this.getCodigo() - o.getCodigo();

        }

        return o.getPrioridade() - this.getPrioridade();
    }
}
