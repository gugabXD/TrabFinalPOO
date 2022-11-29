package TrabFinalPOO;

public class NaveFTL extends Espaconave{
    private double vmaxWarp;
    private double maxCarga;
    public NaveFTL(String nome, EspacoPorto localAtual, double vmaxWarp, double maxCarga){
        super(nome, localAtual);
        this.vmaxWarp = vmaxWarp;
        this.maxCarga = maxCarga;
    }
}
