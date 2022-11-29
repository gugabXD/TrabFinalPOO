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
    public boolean setTransporte(Transporte t){
        if(t instanceof TransportePessoas || getTransporte()!=null) return false;
        setTransporteAtual(t);
        return true;
    }
}
