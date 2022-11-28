package TrabFinalPOO;

import java.util.Scanner;

public class ACMESpace {
    private Scanner in;
    private Cadastros c;
    public ACMESpace(){
        in = new Scanner(System.in);
    }
    public void executa(){
        c = new Cadastros();
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
            System.err.print(e);
        }
        }
    }
    public void trataComando(int opcao){
        switch(opcao){
            case 0-> System.exit(0);
            case 1-> cadastraEspaçoPorto();
            case 2-> cadastraEspacoNave();
            case 3-> cadastraTransp();
            case 4-> consultaTransp();
            case 5-> fazer();
            case 6-> fazer();
            case 7-> fazer();
            case 8-> fazer();
            case 9-> fazer();
        }
    }
    public void fazer(){
        //só pros case nao encher o saco com erro xD xD
    }

    public void cadastraEspacoNave(){
        System.out.println("Por favor insira o nome da espaçonave:");
        String nome = in.nextLine();
        System.out.println("Por favor insira o número identificador do espaço-porto da nave");
        int espPorto = Integer.parseInt(in.nextLine());

        if(c.procuraEspacoPorto(espPorto)==null){
            System.out.println("=============================================================================");
            System.out.println("Nenhum Espaço-porto encontrado com esse nome, deseja cadastrar como Terra?");
            System.out.println("[1] - Sim.");
            System.out.println("[2] - Não.");
            System.out.println("=============================================================================");
            int opção = Integer.parseInt(in.nextLine());

            if(opção==1){
                Espaconave e = new Espaconave(nome , c.procuraEspacoPorto(0));
                if(!c.cadastraesp(e)){
                    System.out.println("Espaçonave já existente.");
                    return;
                }
                System.out.println("Espaço-porto cadastrado como Terra.");
                return;
            }
            System.out.println("Voltando para o menu...");
            return;
        }
        Espaconave e = new Espaconave(nome, c.procuraEspacoPorto(espPorto));
        if(!c.cadastraesp(e)){
            System.out.println("Erro. Espaçonave já existente.");
            return;
        }
        System.out.println("Espaço-porto cadastrado com sucesso");
    }

    public void cadastraEspaçoPorto(){
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

        if(!c.cadastraEspaçoPort(e)){
            System.out.println("Erro. Espaço-Porto já existente.");
            return;
        }
        System.out.println("Espaço-porto cadastrado com sucesso");

    }

    public void cadastraTransp(){
        System.out.println("Insira o identificador do transporte");
        int ident = Integer.parseInt(in.nextLine());
        if(c.procuraTransp(ident)!=null){
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
        EspacoPorto origem = c.procuraEspacoPorto(o);
        if(origem==null){
            System.out.println("Erro. Origem inválida");
            return;
        }
        System.out.println("Insira o número do Espaço-Porto de destino");
        int d = Integer.parseInt(in.nextLine());
        EspacoPorto destino = c.procuraEspacoPorto(d);
        if(destino==null){
            System.out.println("Erro. Destino inválido");
            return;
        }
        System.out.println("Insira a quantidade de pessoas transportadas");
        int quantPessoas = Integer.parseInt(in.nextLine());
        Transporte tp = new TransportePessoas(ident, origem, destino, quantPessoas);
        c.cadastraTransp(tp);
        System.out.println("Transporte cadastrado com sucesso!");
        System.out.println(tp);
    }
    public void cadastraTranspM(int ident){
        System.out.println("Insira o número do Espaço-Porto de origem");
        int o = Integer.parseInt(in.nextLine());
        EspacoPorto origem = c.procuraEspacoPorto(o);
        if(origem==null){
            System.out.println("Erro. Origem inválida");
            return;
        }
        System.out.println("Insira o número do Espaço-Porto de destino");
        int d = Integer.parseInt(in.nextLine());
        EspacoPorto destino = c.procuraEspacoPorto(d);
        if(destino==null){
            System.out.println("Erro. Destino inválido");
            return;
        }
        System.out.println("Insira a descrição do material transportado");
        String descricao = in.nextLine();
        System.out.println("Insira a carga em toneladas de material a ser transportado");
        double carga = Double.parseDouble(in.nextLine());
        Transporte tm = new TransporteMaterial(ident, origem, destino, descricao, carga);
        c.cadastraTransp(tm);
        System.out.println("Transporte cadastrado com sucesso!");
        System.out.println(tm);
    }


    public void consultaTransp(){
        c.consultaTransp();
    }
}
