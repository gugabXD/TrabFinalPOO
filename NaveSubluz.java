package TrabFinalPOO;

public class NaveSubluz extends Espaconave{
    private double vmaxImpulso;
    private String combustivel;

    public NaveSubluz(String nome, EspacoPorto localAtual, double vmaxImpulso, String combustivel){
        super(nome,localAtual);
        this.vmaxImpulso = vmaxImpulso;
        this.combustivel = combustivel;
    }
    public boolean setTransporte(Transporte t){
        if(getTransporte()!=null) return false;
        setTransporteAtual(t);
        return true;
    }
}
