package TrabFinalPOO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Cadastros {
    private ArrayList<Espaconave> cadEspNave;
    private ArrayList<Transporte> cadTransp;
    private ArrayList<EspacoPorto> cadEspPort;

    private ArrayList<JSONObject> json;
    Scanner in = new Scanner(System.in);

    private Queue<Transporte> filaPendente;

    public Cadastros() {
        cadEspNave = new ArrayList<>();
        cadTransp = new ArrayList<>();
        cadEspPort = new ArrayList<>();
        filaPendente = new LinkedList<>();
    }


    public void leituraEspaconave(String local){
        Path path = Paths.get(local);

        try {
            BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] aux = line.split(";");
                //"tipo;nome;espacoporto;velocidade;combustivel_limite"
                String tipo;
                String nome;
                String espacoporto;
                String velocidade;
                String combustivel_limite;

                tipo = aux[0];
                nome = aux[1];
                espacoporto = aux[2];
                velocidade = aux[3];
                combustivel_limite = aux[4];

                double vel = Double.parseDouble(velocidade);
                int numero = Integer.parseInt(espacoporto);

                if(procuraEspacoPorto(numero) == null) {
                    numero = 0;
                }

                if(tipo.equalsIgnoreCase("1")) {
                    NaveSubluz n = new NaveSubluz(nome, procuraEspacoPorto(numero), vel ,combustivel_limite );
                    cadastraEspNav(n);
                }

                if(tipo.equalsIgnoreCase("2")) {
                    double limite = Double.parseDouble(combustivel_limite);
                    NaveFTL n = new NaveFTL(nome, procuraEspacoPorto(numero), vel, limite);
                   cadastraEspNav(n);
                }

            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("===================================");
            System.out.println("ERRO! Arquivo não encontrado.");
            System.out.println("===================================");
            in.nextLine();
        }
        catch(NumberFormatException e ){
            System.out.println("===================================");
            System.out.println("ERRO! Formato de dados incorreto.");
            System.out.println("===================================");
            in.nextLine();
        }
        System.out.println("Pronto!");
    }

    public void leituraNavesJSON(String local){
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();

        String tipo;
        String nome;
        String espacoporto;
        String velocidade;
        String combustivel_limite;


        try {

            jsonObject = (JSONObject) parser.parse(new FileReader(local));


            nome = (String) jsonObject.get("Nome");
            tipo = (String) jsonObject.get("Tipo");
            espacoporto = (String) jsonObject.get("Espaço Porto");

            int numero = Integer.parseInt(espacoporto);

            if(tipo.equalsIgnoreCase("1")){
                velocidade = (String) jsonObject.get("VMax Impulso");
                combustivel_limite = (String) jsonObject.get("Combustivel");

                double vel = Double.parseDouble(velocidade);

                NaveSubluz n = new NaveSubluz(nome, procuraEspacoPorto(numero), vel, combustivel_limite );
                cadastraEspNav(n);

            }
            else{
                velocidade = (String) jsonObject.get("VMax Warp");
                combustivel_limite = (String) jsonObject.get("MaxCarga");

                double vel = Double.parseDouble(velocidade);
                double carga = Double.parseDouble((combustivel_limite));

                NaveFTL n = new NaveFTL(nome, procuraEspacoPorto(numero), vel, carga );
                cadastraEspNav(n);

            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void leituraEspacoPorto(String local){
        Path path = Paths.get(local);

        try {
            BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] aux = line.split(";");
                //"numero;nome;cordx;cordy;cordz""
                String numero;
                String nome;
                String cordx;
                String cordy;
                String cordz;

                numero = aux[0];
                nome = aux[1];
                cordx = aux[2];
                cordy = aux[3];
                cordz = aux[4];

                int num = Integer.parseInt(numero);
                double cx = Double.parseDouble(cordx);
                double cy = Double.parseDouble(cordy);
                double cz = Double.parseDouble(cordz);


                EspacoPorto esp = new EspacoPorto(num, nome, cx, cy,cz);
                cadastraEspaçoPort(esp);

            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("===================================");
            System.out.println("ERRO! Arquivo não encontrado.");
            System.out.println("===================================");
            in.nextLine();
        }
        catch(NumberFormatException e ){
            System.out.println("===================================");
            System.out.println("ERRO! Formato de dados incorreto.");
            System.out.println("===================================");
            in.nextLine();
        }
        System.out.println("Pronto!");
    }

    public void leituraTransporte(String local) {
        Path path = Paths.get(local);

        try {
            BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] aux = line.split(";");
                //"tipo;identificador;origem;destino;descricao;pessoas_carga""
                String tipo;
                String identificador;
                String origem;
                String destino;
                String descricao;
                String pessoas_carga;

                tipo = aux[0];
                identificador = aux[1];
                origem = aux[2];
                destino = aux[3];
                descricao = aux[4];
                pessoas_carga = aux[5];


                int id = Integer.parseInt(identificador);
                int orig = Integer.parseInt(origem);
                int dest = Integer.parseInt(destino);
                //1 = pessoas
                if (tipo.equalsIgnoreCase("1")) {
                    int quantpess = Integer.parseInt(pessoas_carga);
                    TransportePessoas tp = new TransportePessoas(id, procuraEspacoPorto(orig), procuraEspacoPorto(dest), quantpess);
                    cadastraTransp(tp);

                }
                if (tipo.equalsIgnoreCase("2")) {
                    double carg = Double.parseDouble(pessoas_carga);
                    TransporteMaterial tm = new TransporteMaterial(id, procuraEspacoPorto(orig), procuraEspacoPorto(dest), descricao, carg);
                    cadastraTransp(tm);;
                }

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("===================================");
            System.out.println("ERRO! Arquivo não encontrado.");
            System.out.println("===================================");
            in.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("===================================");
            System.out.println("ERRO! Formato de dados incorreto.");
            System.out.println("===================================");
            in.nextLine();
        }
        System.out.println("Pronto!");
    }

    public void precadastraTerra() {
        EspacoPorto Terra = new EspacoPorto(11, "Terra", 0, 0, 0);
        cadEspPort.add(Terra);

    }

    public boolean cadastraEspNav(Espaconave e) {
        for (Espaconave p : cadEspNave) {
            if (p.getNome().equalsIgnoreCase(e.getNome())) {
                return false;
            }
        }
        cadEspNave.add(e);
        return true;
    }

    public boolean cadastraTransp(Transporte t) {
        for (Transporte transp : cadTransp) {
            if (t.getIdentificador() == transp.getIdentificador()) return false;
        }
        cadTransp.add(t);
        filaPendente.add(t);
        return true;
    }

    public boolean cadastraEspaçoPort(EspacoPorto e) {
        for (EspacoPorto p : cadEspPort) {
            if (p.getNumero() == e.getNumero()) {
                return false;

            }
        }
        cadEspPort.add(e);
        return true;
    }

    public EspacoPorto procuraEspacoPorto(int identificador) {
        for (EspacoPorto e : cadEspPort) {
            if (e.getNumero() == identificador) return e;
        }
        return null;
    }

    public ArrayList<Transporte> consultaTransp() {
        if (cadTransp.isEmpty()) return null;
        ArrayList<Transporte> aux = new ArrayList<>();
        cadTransp.stream().forEach(t -> aux.add(t));
        return aux;
    }

    public ArrayList<Transporte> consultaFilaPendente() {
        if (filaPendente.isEmpty()) return null;
        ArrayList<Transporte> aux = new ArrayList<>();
        filaPendente.stream().forEach(t -> aux.add(t));
        return aux;
    }
    public ArrayList<Espaconave> consultaESPNAVE() {
        if (cadEspNave.isEmpty()) return null;
        ArrayList<Espaconave> aux = new ArrayList<>();
        cadEspNave.stream().forEach(t -> aux.add(t));
        return aux;
    }

    public ArrayList<EspacoPorto> consultaESPPORTO() {
        if (cadEspPort.isEmpty()) return null;
        ArrayList<EspacoPorto> aux = new ArrayList<>();
        cadEspPort.stream().forEach(t -> aux.add(t));
        return aux;
    }

    public boolean salvaNaves(String nomeArquivo){
        String linha = "";
        try {
            FileWriter arq = new FileWriter(nomeArquivo);
            BufferedWriter bf = new BufferedWriter(arq);
            bf.write("tipo;nome;espacoporto;velocidade;combustivel_limite"+ "\n");
            for (Espaconave p : cadEspNave) {
                if(p instanceof NaveSubluz){
                    linha = ("1" + ";" + p.geraResumo() + "\n");
                    bf.write(linha);
                }
                else {
                    linha = ("2" + ";" + p.geraResumo() + "\n");
                    bf.write(linha);
                }
            }
            bf.close();
            return true;

        }  catch (Exception e ){
            return false;
        }
    }

    public boolean salvaNavesJson(String nomeArquivo) {
        json = new ArrayList<>();
        for (Espaconave e : cadEspNave) {
            JSONObject jsonObject = new JSONObject();
            if (e instanceof NaveSubluz) {
                jsonObject.put("Tipo", "1");
                jsonObject.put("Nome", e.getNome());
                jsonObject.put("Espaço Porto", e.getLocalAtual().getNumero());
                jsonObject.put("VMax Impulso", ((NaveSubluz) e).getVmaxImpulso());
                jsonObject.put("Combustivel", ((NaveSubluz) e).getCombustivel());

                json.add(jsonObject);
            }
            else{
                jsonObject.put("Tipo", "2");
                jsonObject.put("Nome", e.getNome());
                jsonObject.put("Espaço Porto", e.getLocalAtual().getNumero());
                jsonObject.put("VMax Warp", ((NaveFTL) e).getVmaxWarp());
                jsonObject.put("MaxCarga", ((NaveFTL) e).getMaxCarga());

                json.add(jsonObject);
            }
        }
        try{
            FileWriter arq = new FileWriter(nomeArquivo);
            for(JSONObject j : json){
                arq.write(j.toJSONString() + "\n");
            }
            arq.close();
            return true;
        }
            catch(IOException k){
            return false;
        }
    }

    public boolean salvaEspacoPorto(String nomeArquivo){
        String linha = "";
        try {
            FileWriter arq = new FileWriter(nomeArquivo);
            BufferedWriter bf = new BufferedWriter(arq);
            bf.write("numero;nome;cordx;cordy;cordz"+ "\n");
            for (EspacoPorto p : cadEspPort) {
                linha = (p.geraResumo() + "\n");
                bf.write(linha);
            }
            bf.close();
            return true;

        }  catch (Exception e ){
            return false;
        }
    }

    public boolean salvaEspPortJson(String nomeArquivo) {
        json = new ArrayList<>();
        for (EspacoPorto e : cadEspPort) {
            JSONObject jsonObject = new JSONObject();

                jsonObject.put("Numero", e.getNumero());
                jsonObject.put("Nome", e.getNome());
                jsonObject.put("CordX", e.getCoordX());
                jsonObject.put("CordY", e.getCoordY());
                jsonObject.put("CordZ", e.getCoordZ());

                json.add(jsonObject);
        }
        try{
            FileWriter arq = new FileWriter(nomeArquivo);
            for(JSONObject j : json ){
                arq.write(j.toJSONString() + "\n");
            }
            arq.close();
            return true;
        }
        catch(IOException k){
            return false;
        }
    }

    public boolean salvaTransporte(String nomeArquivo){
        String linha = "";
        try {
            FileWriter arq = new FileWriter(nomeArquivo);
            BufferedWriter bf = new BufferedWriter(arq);
            bf.write("tipo;identificador;origem;destino;descricao;pessoas_carga" + "\n");
            for (Transporte p : cadTransp) {
                if(p instanceof TransportePessoas){
                    linha = ("1" + ";" + p.geraResumo() + "\n");
                    bf.write(linha);

                }
                else {
                    linha = ("2" + ";" + p.geraResumo() + "\n");
                    bf.write(linha);
                }
            }
            bf.close();
            return true;

        }  catch (Exception e ){
            return false;
        }
    }

    public boolean salvaTranspJson(String nomeArquivo) {
        json = new ArrayList<>();
        for (Transporte e : cadTransp) {
            JSONObject jsonObject = new JSONObject();
            if (e instanceof TransportePessoas) {
                jsonObject.put("Tipo", "1");
                jsonObject.put("Id", e.getIdentificador());
                jsonObject.put("Origem", e.getOrigem().getNumero());
                jsonObject.put("Destino", e.getDestino().getNumero());
                jsonObject.put("Quantpessoas", ((TransportePessoas) e).getQuantPessoas());

                json.add(jsonObject);
            }
            else{
                jsonObject.put("Tipo", "2");
                jsonObject.put("Id", e.getIdentificador());
                jsonObject.put("Origem", e.getOrigem().getNumero());
                jsonObject.put("Destino", e.getDestino().getNumero());
                jsonObject.put("Carga", e.getCarga());

                json.add(jsonObject);
            }
        }
        try{
            FileWriter arq = new FileWriter(nomeArquivo);
            for(JSONObject j : json){
                arq.write(j.toJSONString() + "\n");
            }
            arq.close();
            return true;
        }
        catch(IOException k){
            return false;
        }
    }

    public Transporte procuraTransp(int ident) {
        for (Transporte t : cadTransp) {
            if (t.getIdentificador() == ident) return t;
        }
        return null;
    }

    public boolean associar(Transporte t) {
        for (Espaconave e : cadEspNave) {
            if (e.setTransporte(t)) {
                t.setEstado(3);
                return true;
            }
        }
        return false;
    }

    public void removePendente(Transporte t) {
        filaPendente.remove(t);
    }

    public boolean finalizaTransporte(Transporte t) {
        for (Espaconave e : cadEspNave) {
            if (e.getTransporte() == t) {
                e.removeTransporte();
                return true;
            }
        }
        return false;
    }

    public boolean addPendente(Transporte t) {
        return filaPendente.add(t);
    }

    public void setLocalNovo(Transporte t) {
        for (Espaconave e : cadEspNave) {
            if (e.getTransporte() == t) e.setLocalAtual(t.getDestino());
        }
    }

    public boolean designaTransp() {
        if (filaPendente.isEmpty()) return false;
        filaPendente.removeIf(t -> associar(t));
        return true;
    }
}


