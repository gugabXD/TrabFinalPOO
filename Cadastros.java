package TrabFinalPOO;

import TrabFinalPOO.EspacoPorto;
import TrabFinalPOO.Espaconave;
import TrabFinalPOO.Transporte;

import java.util.ArrayList;

public class Cadastros {
    ArrayList<Espaconave> cadesp = new ArrayList<>();
    ArrayList<Transporte> cadtrans = new ArrayList<>();
    ArrayList<EspacoPorto> cadesport = new ArrayList<>();

    public void precadastraTerra(){
        EspacoPorto Terra = new EspacoPorto(0000, "Terra", 0000, 0000, 0000 );
        cadesport.add (Terra);
    }

    public boolean cadastraesp(Espaconave e){
        for(Espaconave p : cadesp){
            if(p.getNome().equalsIgnoreCase(e.getNome())){
                return false;
            }
        }
        cadesp.add(e);
        return true;
    }

   public boolean cadastratrasp(Transporte t){
        for(Transporte p : cadtrans){
            if(p.getIdentificador()== t.getIdentificador()){
                return false;
            }
        }
        cadtrans.add(t);
        return true;
    }

    public boolean cadastraEspaçoPort(EspacoPorto e){
        for(EspacoPorto p : cadesport){
            if (p.getNumero() == e.getNumero()){
                return false;

            }
        }
        cadesport.add(e);
        return true;
    }

    public EspacoPorto porcuraespaçoporto(String nome){
        for(EspacoPorto p : cadesport){
            if (p.getNome().equalsIgnoreCase(nome)){
                return p;

            }
        }
        return null;
    }
}


