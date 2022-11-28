package TrabFinalPOO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cadastros {
    private ArrayList<Espaconave> cadEspNave;
    private ArrayList<Transporte> cadTransp;
    private ArrayList<EspacoPorto> cadEspPort;

    private Queue<Transporte> filaPendente;

    public Cadastros(){
        cadEspNave = new ArrayList<>();
        cadTransp = new ArrayList<>();
        cadEspPort = new ArrayList<>();
        filaPendente = new LinkedList<>();
        precadastraTerra();
    }

    public void precadastraTerra(){
        EspacoPorto Terra = new EspacoPorto(0000, "Terra", 0000, 0000, 0000 );
        cadEspPort.add (Terra);
    }

    public boolean cadastraesp(Espaconave e){
        for(Espaconave p : cadEspNave){
            if(p.getNome().equalsIgnoreCase(e.getNome())){
                return false;
            }
        }
        cadEspNave.add(e);
        return true;
    }

   public void cadastraTransp(Transporte t){
        cadTransp.add(t);
        filaPendente.add(t);
    }

    public boolean cadastraEspaçoPort(EspacoPorto e){
        for(EspacoPorto p : cadEspPort){
            if (p.getNumero() == e.getNumero()){
                return false;

            }
        }
        cadEspPort.add(e);
        return true;
    }

    public EspacoPorto procuraEspacoPorto(int identificador){
        for(EspacoPorto e: cadEspPort){
            if(e.getNumero()==identificador) return e;
        }
        return null;
    }

    public ArrayList<Transporte> consultaTransp(){
        ArrayList<Transporte> aux = new ArrayList<>();
        if(cadTransp.isEmpty()) return null;
        cadTransp.stream().forEach(t -> aux.add(t));
        return aux;
    }

    public boolean salvaDadosArquivo(String nomeArquivo) {
        String linha = "";

        try{
            FileWriter arq = new FileWriter(nomeArquivo);
            BufferedWriter bf = new BufferedWriter(arq);
            for(EspacoPorto p : cadEspPort){
                linha = (p.geraResumo() + "\n");
                bf.write(linha);
            }
            for(Espaconave e : cadEspNave){
                linha = (e.geraResumo() + "\n");
                bf.write(linha);
            }
            for(Transporte t : cadTransp){
                linha = (t.geraResumo() + "\n");
                bf.write(linha);
            }
            bf.close();
            return true;
        }
        catch (Exception e ){
            System.out.println("Não foi possível criar o arquivo.");
            return false;
        }
    }

    public Transporte procuraTransp(int ident){
        for(Transporte t: cadTransp){
            if(t.getIdentificador()==ident) return t;
        }
        return null;
    }

    public boolean associar(Transporte t){
        for(Espaconave e: cadEspNave){
            if(e.setTransporte(t)) return true;
        }
        return false;
    }

}


