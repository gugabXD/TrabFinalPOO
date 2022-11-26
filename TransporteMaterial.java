package TrabFinalPOO;

public class TransporteMaterial extends Transporte{
    private String descricao;
    private int carga;

    public TransporteMaterial(int identificador, EspacoPorto origem, EspacoPorto destino, String descricao, int carga){
        super(identificador, origem, destino);
        this.descricao = descricao;
        this.carga = carga;
    }

    @Override
    public double calculaDistancia() {
        return 0;
    }

    @Override
    public double calculaCusto() {
        return 0;
    }
}
