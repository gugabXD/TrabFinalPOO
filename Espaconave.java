package TrabFinalPOO;

import java.util.ArrayList;

public class Espaconave{

    private String nome;

    private EspacoPorto localAtual;

    private ArrayList<Transporte> historico;

    public Espaconave(String nome, EspacoPorto localAtual) {
        this.nome = nome;
        this.localAtual = localAtual;
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
}
