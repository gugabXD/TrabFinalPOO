package TrabFinalPOO;
public abstract class Transporte {

    private int identificador;

    private EspacoPorto origem;

    private EspacoPorto destino;

    private enum estado {
        PENDENTE, TRANSPORTANDO, CANCELADO, FINALIZADO;
    }

    public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino) {
        this.identificador = identificador;
        this.origem = origem;
        this.destino = destino;
    }

    public abstract double calculaDistancia();

    public abstract double calculaCusto();

}
