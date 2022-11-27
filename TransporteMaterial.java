package TrabFinalPOO;

public class TransporteMaterial extends Transporte{
    private String descricao;
    private double carga;

    public TransporteMaterial(int identificador, EspacoPorto origem, EspacoPorto destino, String descricao, double carga){
        super(identificador, origem, destino);
        this.descricao = descricao;
        this.carga = carga;
    }

    @Override
    public double calculaDistancia() {
        EspacoPorto origem = getOrigem();
        EspacoPorto destino = getDestino();
        double distsquare = Math.pow((origem.getCoordX()-destino.getCoordX()),2)+Math.pow((origem.getCoordY()-destino.getCoordY()),2)+Math.pow((origem.getCoordZ()-destino.getCoordZ()),2);
        return Math.sqrt(distsquare);
    }

    @Override
    public double calculaCusto() {
        double custoDist, custoTransp, fatorDist;
        double distancia = getDistancia();
        if(distancia<0.5) fatorDist = 1000000;
        else fatorDist = 100;
        custoDist = fatorDist * distancia;
        custoTransp = carga * 500;
        return custoDist * custoTransp;
    }
}