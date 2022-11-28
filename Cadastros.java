package TrabFinalPOO;

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

    public void consultaTransp(){
        if(cadTransp.isEmpty()){
            System.out.println("Erro. Não há nenhum transporte.");
            return;
        }
        cadTransp.stream().forEach(c -> System.out.println(c));
    }
    public Transporte procuraTransp(int ident){
        for(Transporte t: cadTransp){
            if(t.getIdentificador()==ident) return t;
        }
        return null;
    }

}


