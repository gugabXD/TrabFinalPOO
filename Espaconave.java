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

    public String getNome(){
        return nome;
    }
}
