package TrabFinalPOO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ACMESpace {
    private Scanner in;
    public ACMESpace(){
        in = new Scanner(System.in);
    }
    public void executa(){
        menu();
    }
    public void menu(){
        while(true) {try{
            System.out.println("============================================================");
            System.out.println("Bem vindo ao menu ACMESpace, escolha uma das opções:");
            System.out.println("1 - Cadastrar novo espaço-porto");
            System.out.println("2 - Cadastrar nova espaçonave");
            System.out.println("3 - Cadastrar novo transporte");
            System.out.println("4 - Consultar todos os transportes");
            System.out.println("5 - Alterar estado de transporte");
            System.out.println("6 - Carregar dados iniciais");
            System.out.println("7 - Designar transportes");
            System.out.println("8 - Salvar dados");
            System.out.println("9 - Carregar dados");
            System.out.println("0 - Finalizar sistema");
            System.out.println("============================================================");
            int opcao = Integer.parseInt(in.nextLine());
            trataComando(opcao);
         } catch(Exception e) {
            System.err.print(e+"\n");
        }
        }
    }
    public void trataComando(int opcao){
        switch(opcao){
            case 0-> System.exit(0);
            case 1-> cadastraEspacoPorto();
            case 2-> cadastraEspacoNave();
            case 3-> cadastraTransp();
            case 4-> consultaTransp();
            case 5-> alteraEstado();
            case 6-> carregaDados();
            case 7-> designaTransp();
            case 8-> salvaDados();
            case 9-> carregarDados();
            case 99->consultaESPPORTO();
            case 100->consultaESPNAVE();
            case 101-> consultaFilaPendente();
            default -> System.out.println("Opção inválida.");

        }
    }
    public void fazer(){
        //só pros case nao encher o saco com erro xD xD
    }

    public void carregarDados(){
        System.out.println("Por favor, insira o local do arquivo.");
        String local;
        local = in.nextLine();

        System.out.println("======================================================");
        System.out.println("Por favor, insira o tipo de arquivo que irá ser lido");
        System.out.println("[1] - DAT ");
        System.out.println("[2] - JSON ");
        System.out.println("======================================================");
        int opcao = Integer.parseInt(in.nextLine());

        switch(opcao){

            case 1 -> leArquivoCSV(local);
            case 2 -> leArquivoJSON(local);
            default -> carregarDados();
        }
    }

    public void leArquivoJSON(String local){
        System.out.println("====================================");
        System.out.println("Por favor insira o que deseja inserir:");
        System.out.println("[1] - Espaçonaves");
        System.out.println("[2] - Espaço-portos");
        System.out.println("[3] - Transportes");
        System.out.println("====================================");
        int opcao = Integer.parseInt(in.nextLine());

        switch(opcao){
            case 1 -> menu();
            case 2 -> menu();
            case 3 -> menu();
            default -> leArquivoCSV(local);
        }


    }

    public void leArquivoCSV(String local) {
        System.out.println("====================================");
        System.out.println("Por favor insira o que deseja inserir:");
        System.out.println("[1] - Espaçonaves");
        System.out.println("[2] - Espaço-portos");
        System.out.println("[3] - Transportes");
        System.out.println("====================================");
        int opcao = Integer.parseInt(in.nextLine());

        switch(opcao){
            case 1 -> Cadastros.getInstance().leituraEspaconave(local);
            case 2 -> Cadastros.getInstance().leituraEspacoPorto(local);
            case 3 -> Cadastros.getInstance().leituraTransporte(local);
            default -> leArquivoCSV(local);
        }

    }

    public void salvaDados(){
        System.out.println("Por favor, insira o nome que deseja colocar no arquivo.");
        String nome;
        nome = in.nextLine();

        System.out.println("==================================================================");
        System.out.println("Por favor, selecione qual formato gostaria de salvar o arquivo.");
        System.out.println("[1] - DAT");
        System.out.println("[2] - JSON");
        System.out.println("[3] - CSV e JSON");
        System.out.println("==================================================================");
        int opcao = Integer.parseInt(in.nextLine());

        switch (opcao){
            case 1 -> salvaDadosCsv(nome);
            case 2 -> salvaDadosXML(nome);
            case 3 -> {
                salvaDadosCsv(nome);
                salvaDadosXML(nome + "(1)");
            }
            default -> menu();
        }
    }

    public void salvaDadosCsv(String nome){
        System.out.println("==================================================================");
        System.out.println("Selecione o que deseja salvar no arquivo DAT: ");
        System.out.println("[1] - Espaçonaves");
        System.out.println("[2] - Espaço-portos");
        System.out.println("[3] - Transportes");
        System.out.println("[4] - Salva todos os dados.");
        System.out.println("==================================================================");
        int opcao = Integer.parseInt(in.nextLine());

        switch (opcao) {
            case 1 -> {
                if (Cadastros.getInstance().salvaNaves(nome)) {
                    System.out.println("Arquivo criado com sucesso");
                    break;
                }
                System.out.println("Não foi possível criar o arquivo");
            }
            case 2 -> {
                if (Cadastros.getInstance().salvaEspacoPorto(nome)) {
                    System.out.println("Arquivo criado com sucesso");
                    break;
                }
                System.out.println("Não foi possível criar o arquivo");
            }
            case 3 -> {
                if (Cadastros.getInstance().salvaTransporte(nome)) {
                    System.out.println("Arquivo criado com sucesso");
                    break;
                }
                System.out.println("Não foi possível criar o arquivo");
            }
            case 4 -> {
                if (Cadastros.getInstance().salvaTransporte(nome) && Cadastros.getInstance().salvaNaves(nome + "(1)") && Cadastros.getInstance().salvaEspacoPorto(nome + "(2)")) {
                    System.out.println("Arquivo criado com sucesso");
                    break;
                }
                System.out.println("Não foi possível criar o arquivo");

            }
            default -> menu();
        }

    }

    public void salvaDadosXML(String nome){
        System.out.println("==================================================================");
        System.out.println("Selecione o que deseja salvar no arquivo JSON: ");
        System.out.println("[1] - Espaçonaves");
        System.out.println("[2] - Espaço-portos");
        System.out.println("[3] - Transportes");
        System.out.println("[4] - Salva todos os dados.");
        System.out.println("==================================================================");
        int opcao = Integer.parseInt(in.nextLine());

        switch (opcao) {
            case 1 -> {
                if (Cadastros.getInstance().salvaNavesJson(nome)) {
                    System.out.println("Arquivo criado com sucesso");
                    break;
                }
                System.out.println("Não foi possível criar o arquivo");
            }
            case 2 -> {
                if (Cadastros.getInstance().salvaEspPortJson(nome)) {
                    System.out.println("Arquivo criado com sucesso");
                    break;
                }
                System.out.println("Não foi possível criar o arquivo");
            }
            case 3 -> {
                if (Cadastros.getInstance().salvaTranspJson(nome)) {
                    System.out.println("Arquivo criado com sucesso");
                    break;
                }
                System.out.println("Não foi possível criar o arquivo");
            }
            case 4 -> {
                if (Cadastros.getInstance().salvaTranspJson(nome) && Cadastros.getInstance().salvaNavesJson(nome + "(1)") && Cadastros.getInstance().salvaEspPortJson(nome + "(2)")) {
                    System.out.println("Arquivo criado com sucesso");
                    break;
                }
                System.out.println("Não foi possível criar o arquivo");

            }
            default -> menu();
        }
    }

    public void cadastraEspacoNave() {
        System.out.println("Por favor insira o nome da espaçonave:");
        String nome = in.nextLine();
        System.out.println("Por favor insira o número identificador do espaço-porto em que a nave está");
        int espPorto = Integer.parseInt(in.nextLine());

        if (Cadastros.getInstance().procuraEspacoPorto(espPorto) == null) {
            System.out.println("=============================================================================");
            System.out.println("Nenhum Espaço-porto encontrado com esse numero, deseja cadastrar como Terra?");
            System.out.println("[1] - Sim.");
            System.out.println("[2] - Não.");
            System.out.println("=============================================================================");
            int opção = Integer.parseInt(in.nextLine());


            switch (opção) {
                case 1 -> {
                    if(Cadastros.getInstance().procuraEspacoPorto(11)==null) Cadastros.getInstance().precadastraTerra();
                    trataEspaconave(nome,     11);
                }
                default -> {
                    System.out.println("Voltando para o menu...");
                    menu();
                }
            }
            return;
        }
        trataEspaconave(nome, espPorto);
    }



    public void trataEspaconave(String nome, int numeroesp) {
        System.out.println("=============================================");
        System.out.println("Por favor insira o tipo da espaçonave:");
        System.out.println("[1] - Nave FTL");
        System.out.println("[2] - Nave Subluz");
        System.out.println("==============================================");

        int a = Integer.parseInt(in.nextLine());

        switch (a) {
            case 1 -> {

                System.out.println("Por favor insira a velocidade máxima Warp.");
                double velocidade = Double.parseDouble(in.nextLine());

                System.out.println("Por favor insira a quantidade máxima de pessoas ou de carga. ");
                double quantidade = Double.parseDouble(in.nextLine());

                NaveFTL n = new NaveFTL(nome, Cadastros.getInstance().procuraEspacoPorto(numeroesp), velocidade, quantidade);

                if(!Cadastros.getInstance().cadastraEspNav(n)){
                    System.out.println("Espaçonave já existe.");
                    return;
                }
                System.out.println("Espaçonave criada com sucesso.");
                System.out.println(n);
            }
            case 2 -> {
                System.out.println("Por favor insira a velocidade máxima de impulso (limite 0.3 Warp)");
                double velocidadeimp = Math.abs(Double.parseDouble(in.nextLine()));
                if(velocidadeimp > 0.3){
                    velocidadeimp = 0.3;
                    System.out.println("Velocidade máxima inserida é maior que o limite, portanto foi definida como 0.3 Warp");
                }

                System.out.println("=======================================");
                System.out.println("Por favor, escolha o tipo de combustível");
                System.out.println("[1] - Íon");
                System.out.println("[2] - Nuclear");
                System.out.println("=======================================");
                int opcao = Integer.parseInt(in.nextLine());
                String combustivel;
                switch(opcao){
                    case 1-> combustivel = "ion";
                    case 2-> combustivel = "nuclear";
                    default -> {
                        System.out.println("Opção inválida. Voltando ao menu");
                        return;
                    }
                }
                NaveSubluz s = new NaveSubluz(nome, Cadastros.getInstance().procuraEspacoPorto(numeroesp), velocidadeimp, combustivel);

                if(!Cadastros.getInstance().cadastraEspNav(s)){
                    System.out.println("Espaçonave já existe.");
                    return;
                }
                System.out.println("Espaçonave criada com sucesso.");
                System.out.println(s);
            }
            default -> {
                System.out.println("Voltando para o menu...");
                menu();
            }
        }
    }

    public void cadastraEspacoPorto(){
        System.out.println("Por favor, insira o número do Espaço-Porto:");
        int numero = Integer.parseInt(in.nextLine());
        System.out.println("Por favor, insira o nome:");
        String nome = in.nextLine();
        System.out.println("Por favor, insira o cordenada X:");
        double x = Double.parseDouble(in.nextLine());
        System.out.println("Por favor, insira o cordenada Y:");
        double y = Double.parseDouble(in.nextLine());
        System.out.println("Por favor, insira o cordenada Z:");
        double z = Double.parseDouble(in.nextLine());

        EspacoPorto e = new EspacoPorto(numero, nome, x , y , z );

        if(!Cadastros.getInstance().cadastraEspaçoPort(e)){
            System.out.println("Erro. Espaço-Porto já existente.");
            return;
        }
        System.out.println("Espaço-porto cadastrado com sucesso");
        System.out.println(e);
    }

    public void cadastraTransp(){
        System.out.println("Insira o identificador do transporte");
        int ident = Integer.parseInt(in.nextLine());
        if(Cadastros.getInstance().procuraTransp(ident)!=null){
            System.out.println("Erro. Transporte já existente.");
            return;
        }
        System.out.println("=============================");
        System.out.println("Insira o tipo do transporte:");
        System.out.println("[1] - Transporte de pessoas");
        System.out.println("[2] - Transporte de materais");
        System.out.println("=============================");
        int opcao;
        do { opcao = Integer.parseInt(in.nextLine());
        switch(opcao){
            case 1-> cadastraTranspP(ident);
            case 2-> cadastraTranspM(ident);
            default -> System.out.println("Insira uma opção válida.");
        } } while(opcao!=1 && opcao!=2);
    }
    public void cadastraTranspP(int ident){
        System.out.println("Insira o número do Espaço-Porto de origem");
        int o = Integer.parseInt(in.nextLine());
        EspacoPorto origem = Cadastros.getInstance().procuraEspacoPorto(o);
        if(origem==null){
            System.out.println("Erro. Origem inválida");
            return;
        }
        System.out.println("Insira o número do Espaço-Porto de destino");
        int d = Integer.parseInt(in.nextLine());
        EspacoPorto destino = Cadastros.getInstance().procuraEspacoPorto(d);
        if(destino==null){
            System.out.println("Erro. Destino inválido");
            return;
        }
        if(origem==destino){
            System.out.println("Erro. Origem e destino iguais");
            return;
        }
        System.out.println("Insira a quantidade de pessoas transportadas");
        int quantPessoas = Integer.parseInt(in.nextLine());
        Transporte tp = new TransportePessoas(ident, origem, destino, quantPessoas);
        Cadastros.getInstance().cadastraTransp(tp);
        System.out.println("Transporte cadastrado com sucesso!");
        System.out.println(tp);
    }
    public void cadastraTranspM(int ident){
        System.out.println("Insira o número do Espaço-Porto de origem");
        int o = Integer.parseInt(in.nextLine());
        EspacoPorto origem = Cadastros.getInstance().procuraEspacoPorto(o);
        if(origem==null){
            System.out.println("Erro. Origem inválida");
            return;
        }
        System.out.println("Insira o número do Espaço-Porto de destino");
        int d = Integer.parseInt(in.nextLine());
        EspacoPorto destino = Cadastros.getInstance().procuraEspacoPorto(d);
        if(destino==null){
            System.out.println("Erro. Destino inválido");
            return;
        }
        if(origem==destino){
            System.out.println("Erro. Origem e destino iguais");
            return;
        }
        System.out.println("Insira a descrição do material transportado");
        String descricao = in.nextLine();
        System.out.println("Insira a carga em toneladas de material a ser transportado");
        double carga = Double.parseDouble(in.nextLine());
        Transporte tm = new TransporteMaterial(ident, origem, destino, descricao, carga);
        Cadastros.getInstance().cadastraTransp(tm);
        System.out.println("Transporte cadastrado com sucesso!");
        System.out.println(tm);
    }

    public void alteraEstado(){
        consultaTransp();
        System.out.println("Insira o identificador do transporte");
        int ident = Integer.parseInt(in.nextLine());
        Transporte t = Cadastros.getInstance().procuraTransp(ident);
        if(t==null){
            System.out.println("Erro. Transporte inexistente.");
            return;
        }
        t.toString();
        String estado = t.getEstado();
        if(estado.equals("CANCELADO") || t.getEstado().equals("FINALIZADO")) {
            System.out.println("Erro. Estado imutável.");
            return;
        }
        else if(estado.equals("PENDENTE")){
            System.out.println("===============");
            System.out.println("TRANSPORTE PENDENTE");
            System.out.println("Escolha o novo estado do transporte (ou um valor diferente para cancelar a operação)");
            System.out.println("[1] - TRANSPORTANDO");
            System.out.println("[2] - CANCELADO");
            System.out.println("===============");
            int opcao = Integer.parseInt(in.nextLine());
            switch(opcao){
                case 1-> {
                    if(Cadastros.getInstance().associar(t)){
                        Cadastros.getInstance().removePendente(t);
                        System.out.println("Transporte iniciado com sucesso");
                    }
                    else System.out.println("Erro. Não há naves disponíveis no momento");
                }
                case 2-> {
                    t.setEstado(2);
                    Cadastros.getInstance().removePendente(t);
                    System.out.println("Transporte cancelado.");
                }
                default -> {
                    System.out.println("Opção inválida. Operação cancelada.");;
                }
            }
        }
        else {
            System.out.println("===============");
            System.out.println("TRANSPORTE EM ANDAMENTO");
            System.out.println("Escolha o novo estado do transporte (ou um valor diferente para cancelar a operação)");
            System.out.println("[1] - FINALIZADO");
            System.out.println("[2] - PENDENTE");
            System.out.println("[3] - CANCELADO");
            System.out.println("===============");
            int opcao = Integer.parseInt(in.nextLine());
            switch(opcao){
                case 1-> {
                    t.setEstado(4);
                    System.out.println("Transporte finalizado com sucesso.");
                    Cadastros.getInstance().setLocalNovo(t);
                    Cadastros.getInstance().finalizaTransporte(t);
                }
                case 2-> {
                    t.setEstado(1);
                    System.out.println("Transporte novamente pendente");
                    Cadastros.getInstance().addPendente(t);
                }
                case 3-> {
                    t.setEstado(2);
                    System.out.println("Transporte cancelado.");
                    Cadastros.getInstance().finalizaTransporte(t);
                }
                default -> {
                    System.out.println("Opção inválida. Operação cancelada.");
                }
            }
        }

    }
    public void consultaTransp(){
        ArrayList<Transporte> lista = Cadastros.getInstance().consultaTransp();
        if(lista==null){
            System.out.println("Erro. Não há nenhum transporte cadastrado");
            return;
        }
        lista.stream().forEach(t -> System.out.println(t));
    }
    public void consultaFilaPendente(){
        ArrayList<Transporte> lista = Cadastros.getInstance().consultaFilaPendente();
        if(lista==null){
            System.out.println("Erro. Não há nenhum transporte cadastrado");
            return;
        }
        lista.stream().forEach(t -> System.out.println(t));
    }
    public void consultaESPNAVE(){
        ArrayList<Espaconave> lista = Cadastros.getInstance().consultaESPNAVE();
        if(lista==null){
            System.out.println("Erro. Não há nenhuma Espaçonave cadastrada");
            return;
        }
        lista.stream().forEach(t -> System.out.println(t));
    }

    public void consultaESPPORTO(){
        ArrayList<EspacoPorto> lista = Cadastros.getInstance().consultaESPPORTO();
        if(lista==null){
            System.out.println("Erro. Não há nenhum Espaço-Porto cadastrado");
            return;
        }
        lista.stream().forEach(t -> System.out.println(t));
    }

    public void carregaDados(){
        System.out.println("===============");
        System.out.println("Que tipo de Espaço-Objeto deseja inserir?");
        System.out.println("[1] - Espaço-Porto");
        System.out.println("[2] - Espaçonave");
        System.out.println("[3] - Transporte");
        int opcao = Integer.parseInt(in.nextLine());
        switch (opcao){
            case 1-> carregaDados(1);
            case 2-> carregaDados(2);
            case 3-> carregaDados(3);
            default -> System.out.println("Opção inválida. Retornando ao menu.");
        }
    }
    public void carregaDados(int tipo){
        BufferedReader leitor;
        try{
            System.out.println("Insira o local de arquivo");
            String caminho = in.nextLine();
            leitor = new BufferedReader(new FileReader(caminho+".dat"));
            String linha;
            leitor.readLine();
            switch(tipo) {
               case 1-> { while (true) {
                    linha = leitor.readLine();
                    if (linha == null) break;
                    lerESPPORT(linha);
                 }
                   consultaESPPORTO();
               }
                case 2-> { while (true) {
                    linha = leitor.readLine();
                    if (linha == null) break;
                    lerESPNAVE(linha);
                }
                    consultaESPNAVE();
               }
                case 3-> { while (true) {
                    linha = leitor.readLine();
                    if (linha == null) break;
                    lerTRANSP(linha);
                }
                    consultaTransp();
               }
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch(Exception e){
            System.err.print(e);
        }
    }
    public void lerESPPORT(String linha){
        String[] res = linha.split(";", 0);
        EspacoPorto esp = new EspacoPorto(Integer.parseInt(res[0]), res[1], Double.parseDouble(res[2]), Double.parseDouble(res[3]), Double.parseDouble(res[4]));
        boolean resultado = Cadastros.getInstance().cadastraEspaçoPort(esp);
        if(!resultado) System.out.println("Erro. Identificador repetido");
    }
    public void lerESPNAVE (String linha){
        String[] res = linha.split(";", 0);
        int tipo = Integer.parseInt(res[0]);
        Espaconave nave;
        if(tipo==1) nave = new NaveSubluz(res[1],Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[2])), Double.parseDouble(res[3]), res[4]);
        else nave = new NaveFTL(res[1], Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[2])), Double.parseDouble(res[3]), Double.parseDouble(res[4]));
        boolean resultado = Cadastros.getInstance().cadastraEspNav(nave);
        if(!resultado) System.out.println("Erro. Essa nave já existe.");
    }

    public void lerTRANSP (String linha){
        String[] res = linha.split(";", 0);
        int tipo = Integer.parseInt(res[0]);
        Transporte transporte;
        if(tipo==1) transporte = new TransportePessoas(Integer.parseInt(res[1]),Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[2])),Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[3])), Integer.parseInt(res[4]) );
        else transporte = new TransporteMaterial(Integer.parseInt(res[1]),Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[2])),Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[3])), res[5], Double.parseDouble(res[4]));
        boolean resultado = Cadastros.getInstance().cadastraTransp(transporte);
        if(!resultado) System.out.println("Erro. Essa nave já existe.");
    }

    public void designaTransp(){
        boolean res = Cadastros.getInstance().designaTransp();
        if(!res) System.out.println("Erro. Não há transportes pendentes.");
        else System.out.println("Todos as espaçonaves aptas foram designadas aos respectivos transportes.");
    }
}
