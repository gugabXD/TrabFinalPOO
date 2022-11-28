package TrabFinalPOO;

public class TransportePessoas extends Transporte{
    private int quantPessoas;

    public TransportePessoas(int identificador, EspacoPorto origem, EspacoPorto destino, int quantPessoas){
        super(identificador, origem, destino);
        this.quantPessoas = quantPessoas;
    }
    @Override
    public double calculaDistancia() {
        EspacoPorto origem = getOrigem();
        EspacoPorto destino = getDestino();
        double distsquare = Math.pow((origem.getCoordX()-destino.getCoordX()),2)+Math.pow((origem.getCoordY()-destino.getCoordY()),2)+Math.pow((origem.getCoordZ()-destino.getCoordZ()),2);
        return Math.sqrt(distsquare);
    }

    @Override
    public String geraResumo(){
        return quantPessoas + ";";
    }

    @Override
    public double calculaCusto() {
        double custoDist, custoTransp, fatorDist;
        double distancia = getDistancia();
        if(distancia<0.5) fatorDist = 1000000;
        else fatorDist = 100;
        custoDist = fatorDist * distancia;
        custoTransp = quantPessoas * 100;
        return custoDist * custoTransp;
    }
    @Override
    public String toString() {
        String s = "Transporte de pessoas para "+quantPessoas+"\n"+
                "De origem em: "+getOrigem().toString()+"E destino em: "+getDestino().toString()+
                "Distancia de "+getDistancia()+" anos luz e custo de "+calculaCusto()+" C$\n"+
                "Estado: "+getEstado()+"\n";
        //if(getEstado()!=Estado.PENDENTE) s+= getNave().toString();
        return s;
    }
}
