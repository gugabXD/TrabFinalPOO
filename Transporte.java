package TrabFinalPOO;
public abstract class Transporte {

    private int identificador;

    private EspacoPorto origem;

    private EspacoPorto destino;
    public double distancia;

    private enum Estado {
        PENDENTE, TRANSPORTANDO, CANCELADO, FINALIZADO;
    }

    public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino) {
        this.identificador = identificador;
        this.origem = origem;
        this.destino = destino;
        distancia = calculaDistancia();
        Estado e = Estado.PENDENTE;
    }

    public abstract double calculaDistancia();

    public abstract double calculaCusto();

    public EspacoPorto getDestino() {
        return destino;
    }

    public EspacoPorto getOrigem() {
        return origem;
    }

    public double getDistancia() {
        return distancia;
    }
}
