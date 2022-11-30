package TrabFinalPOO;

public class NaveFTL extends Espaconave{
    private double vmaxWarp;
    private double maxCarga;


    public NaveFTL(String nome, EspacoPorto localAtual, double vmaxWarp, double maxCarga){
        super(nome, localAtual);
        this.vmaxWarp = vmaxWarp;
        this.maxCarga = maxCarga;
    }

    @Override
    public String geraResumo(){
        return getNome() + ";" + getLocalAtual().getNumero() + ";" + vmaxWarp + ";" + maxCarga + ";";
    }

    @Override
    public boolean setTransporte(Transporte t){
        if(getTransporte()!=null || t.getCarga()>maxCarga) return false;
        setTransporteAtual(t);
        return true;
    }
    @Override
    public String toString(){
        String s = "Espaçonave FTL de nome "+getNome();
        Transporte t = getTransporte();
        if(t!=null) s+= "\n Transportando carga de "+t.getOrigem().getNome()+" a "+t.getDestino().getNome();
        else s+= "\n Localizado em " +getLocalAtual().getNome();
        s+="Com velocidade máxima de "+vmaxWarp+" Warp e carga máxima de "+maxCarga+"pessoas ou toneladas de material";
        return s;
    }
}
