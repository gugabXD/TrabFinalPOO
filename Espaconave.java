package TrabFinalPOO;

import java.util.LinkedList;
import java.util.Queue;

public class Espaconave{

    private String nome;

    private EspacoPorto localAtual;

    private Queue<Transporte> historico;

    private Transporte transporteAtual;

    public Espaconave(String nome, EspacoPorto localAtual) {
        this.nome = nome;
        this.localAtual = localAtual;
        historico = new LinkedList<>();
    }

    public String geraResumo(){
        return nome + ";" + localAtual.getNumero() + ";";
    }

    public String geraResumoXML(){
        return "<nome>" + nome + "</nome>"  + "\n" + "<LocalAtualNumero>" + localAtual.getNumero() + "</LocalAtualNumero>";
    }

    public String getNome(){
        return nome;
    }
    public void setTransporteAtual(Transporte t){
        transporteAtual = t;
        historico.add(t);
    }
    public Transporte getTransporte(){
        return transporteAtual;
    }

    public boolean setTransporte(Transporte t){
        return false;
    }
    public void removeTransporte(){
        transporteAtual = null;
    }

    public String toString() {
        return "";
    }
    public EspacoPorto getLocalAtual() {
        return localAtual;
    }
    public void setLocalAtual(EspacoPorto e){
        localAtual = e;
    }

    public Queue<Transporte> getHistorico() {
        Queue<Transporte> aux = new LinkedList<>();
        aux.addAll(historico);
        return aux;
    }
}
