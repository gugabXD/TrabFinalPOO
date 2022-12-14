package TrabFinalPOO;
public abstract class Transporte {

    private int identificador;

    private EspacoPorto origem;

    private EspacoPorto destino;
    public double distancia;
    private Espaconave designada;

    enum Estado {
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
    public abstract String geraResumo();

    public abstract String geraResumoXML();

    public abstract double calculaDistancia();

    public abstract double calculaCusto();

    public abstract double getCarga();
    public abstract String toString();

    public void setNave(Espaconave e){
        designada = e;
    }
    public Espaconave getNave(){
        return designada;
    }
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

    public String getEstado() {
        return e.toString();
    }
    public void setEstado(int estado){
        switch(estado){
            case 1-> e = Estado.PENDENTE;
            case 2-> e = Estado.CANCELADO;
            case 3-> e = Estado.TRANSPORTANDO;
            case 4-> e = Estado.FINALIZADO;
        }
    }
    public boolean isPendente(){
        return e==Estado.PENDENTE;
    }
}
