package TrabFinalPOO;
public abstract class Transporte {

    private int identificador;

    private EspacoPorto origem;

    private EspacoPorto destino;
    public double distancia;

    private enum Estado {
        PENDENTE, TRANSPORTANDO, CANCELADO, FINALIZADO;
    }
    private Estado e;

    public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino) {
        this.identificador = identificador;
        this.origem = origem;
        this.destino = destino;
        distancia = calculaDistancia();
        e = Estado.PENDENTE;
    }

    public abstract double calculaDistancia();

    public abstract double calculaCusto();

    public EspacoPorto getDestino() {
        return destino;
    }

    public int getIdentificador(){
        return identificador;
    }

    public EspacoPorto getOrigem() {
        return origem;
    }

    public double getDistancia() {
        return distancia;
    }
}
