package TrabFinalPOO;

public class TransporteMaterial extends Transporte{
    private String descricao;
    private double carga;

    public TransporteMaterial(int identificador, EspacoPorto origem, EspacoPorto destino, String descricao, double carga){
        super(identificador, origem, destino);
        this.descricao = descricao;
        this.carga = Math.abs(carga);
    }
    @Override
    public String geraResumo(){
        if(!isPendente()) {
            return getIdentificador()+ ":" + getOrigem().getNumero()+ ":" + getDestino().getNumero() + ":" + carga + ":" + descricao + ":" + getEstado() + ":" + getNave().getNome();
        }
        return getIdentificador()+ ":" + getOrigem().getNumero()+ ":" + getDestino().getNumero() + ":"+ carga + ":" + descricao + ":" + getEstado();
    }
    @Override
    public String geraResumoXML(){
        return "<identificador>" + getIdentificador() + "</identificador>" + "\n" + "<origem>" + getOrigem().getNumero() + "</origem>" + "\n" + "<destino>" + getDestino().getNumero() + "</destino>"+ "\n" + "<descricao>" + descricao + "</descricao>" + "\n" + "<carga>" + carga + "</carga>";
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

    @Override
    public String toString() {
        String s = "Transporte de material: "+descricao+ " com carga de "+carga+" toneladas"+", de número "+getIdentificador()+"\n"+
                "De origem em: "+getOrigem().toString()+"\nE destino em: "+getDestino().toString()+
                "\nDistancia de "+getDistancia()+" anos luz e custo de "+calculaCusto()+" C$\n"+
                "Estado: "+getEstado()+"\n";
                if(!isPendente()) s+= "Designado para a nave: " + getNave().getNome() +"\n";
        return s;
    }

    @Override
    public double getCarga() {
        return carga;
    }

}
