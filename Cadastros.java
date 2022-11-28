package TrabFinalPOO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Cadastros {
    private ArrayList<Espaconave> cadEspNave;
    private ArrayList<Transporte> cadTransp;
    private ArrayList<EspacoPorto> cadEspPort;

    public Cadastros(){
        cadEspNave = new ArrayList<>();
        cadTransp = new ArrayList<>();
        cadEspPort = new ArrayList<>();
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

   public boolean cadastraTransp(Transporte t){
        for(Transporte p : cadTransp){
            if(p.getIdentificador()== t.getIdentificador()){
                return false;
            }
        }
        cadTransp.add(t);
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

    public void consultaTransp(){
        if(cadTransp.isEmpty()){
            System.out.println("Erro. Não há nenhum transporte.");
            return;
        }
        cadTransp.stream().forEach(c -> c.toString());
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
}


