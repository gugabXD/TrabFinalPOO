package TrabFinalPOO;

public class NaveFTLPessoa extends Espaconave{
    private double vmaxWarp;
    private int maxPessoas;
    public NaveFTLPessoa(String nome, EspacoPorto localAtual, double vmaxWarp, int maxPessoas){
        super(nome, localAtual);
        this.vmaxWarp = vmaxWarp;
        this.maxPessoas = maxPessoas;
    }
}