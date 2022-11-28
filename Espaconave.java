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

    public String getNome(){
        return nome;
    }
}
