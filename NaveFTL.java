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
        if(getTransporte()!=null) return false;
        setTransporteAtual(t);
        return true;
    }
}
