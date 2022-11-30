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
        EspacoPorto Terra = new EspacoPorto(0, "Terra", 0, 0, 0 );
        cadEspPort.add (Terra);
    }

    public boolean cadastraEspNav(Espaconave e){
        for(Espaconave p : cadEspNave){
            if(p.getNome().equalsIgnoreCase(e.getNome())){
                return false;
            }
        }
        cadEspNave.add(e);
        return true;
    }

   public boolean cadastraTransp(Transporte t){
        for(Transporte transp: cadTransp){
            if(t.getIdentificador()==transp.getIdentificador()) return false;
        }
        cadTransp.add(t);
        filaPendente.add(t);
        return true;
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
    public ArrayList<Espaconave> consultaESPNAVE(){
        ArrayList<Espaconave> aux = new ArrayList<>();
        if(cadEspNave.isEmpty()) return null;
        cadEspNave.stream().forEach(t -> aux.add(t));
        return aux;
    }
    public ArrayList<EspacoPorto> consultaESPPORTO(){
        ArrayList<EspacoPorto> aux = new ArrayList<>();
        if(cadEspPort.isEmpty()) return null;
        cadEspPort.stream().forEach(t -> aux.add(t));
        return aux;
    }

    public boolean salvaDadosArquivoCSV(String nomeArquivo) {
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

    public boolean salvaDadosArquivoXML(String nomeArquivo) {
        String linha = "";

        try{
            FileWriter arq = new FileWriter(nomeArquivo);
            BufferedWriter bf = new BufferedWriter(arq);
            bf.write("-<EspacoPorto>" + "\n");
            for(EspacoPorto p : cadEspPort){
                linha = (p.geraResumoXML() + "\n");
                bf.write(linha);
            }
            bf.write("-<Espaconave>" + "\n");
            for(Espaconave e : cadEspNave){
                linha = (e.geraResumoXML() + "\n");
                bf.write(linha);
            }
            bf.write("-<Transporte>" + "\n");
            for(Transporte t : cadTransp){
                linha = (t.geraResumoXML() + "\n");
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
    //removendo o transporte que esta incorretamente na fila de pendentes
    public void removePendente(Transporte t){
        Queue<Transporte> aux = new LinkedList();
        Transporte temp = null;
        while(!filaPendente.isEmpty()){
            temp = filaPendente.poll();
            if(temp==t) temp = filaPendente.poll();
            aux.add(temp);
        }
        while(temp!=null){
            temp = aux.poll();
            filaPendente.add(temp);
        }
    }

    public boolean finalizaTransporte(Transporte t){
        for(Espaconave e: cadEspNave){
            if(e.getTransporte()==t){
                e.removeTransporte();
                return true;
            }
        }
        return false;
    }

    public boolean addPendente(Transporte t){
        return filaPendente.add(t);
    }

    public void setLocalNovo(Transporte t){
        for(Espaconave e: cadEspNave){
            if(e.getTransporte()==t) e.setLocalAtual(t.getDestino());
        }
    }
}


