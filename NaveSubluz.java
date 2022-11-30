package TrabFinalPOO;

import java.util.Queue;

public class NaveSubluz extends Espaconave{
    private double vmaxImpulso;
    private String combustivel;

    public NaveSubluz(String nome, EspacoPorto localAtual, double vmaxImpulso, String combustivel){
        super(nome,localAtual);
        this.vmaxImpulso = vmaxImpulso;
        this.combustivel = combustivel;
    }
    @Override
    public boolean setTransporte(Transporte t){
        if(getTransporte()!=null) return false;
        setTransporteAtual(t);
        return true;
    }
    @Override
    public String toString(){
        String s = "Espaçonave Subluz de nome "+getNome();
        Transporte t = getTransporte();
        if(t!=null) s+= "\n Transportando carga de "+t.getOrigem().getNome()+" a "+t.getDestino().getNome();
        else s+= "\n Localizado em " +getLocalAtual().getNome();
        s+="Com velocidade máxima de "+vmaxImpulso+" Warp. Utiliza " +combustivel+" como combustível.";
        Queue<Transporte> historico = getHistorico();
        if(!historico.isEmpty()) {
            s+="\nEssa nave possui em seu histórico os transportes: ";
            for(Transporte transp: historico){
                s+= transp.getIdentificador()+"; ";
            }
        }
        return s;
    }
}
