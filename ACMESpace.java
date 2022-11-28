package TrabFinalPOO;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ACMESpace {
    private Scanner in;

    Cadastros cadastros = new Cadastros();
    public ACMESpace(){

        in = new Scanner(System.in);
    }
    public void menu(){
        while(true) {
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
        }
    }
    public void trataComando(int opcao){
        switch(opcao){
            case 0-> System.exit(0);
            case 1-> cadastraEspaçoPort();
            case 2-> cadastraesp();
            //case 3-> cadasdtraTransp();
            case 4-> fazer();
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

    public void cadastraesp(){
        System.out.println("Por favor insira o nome da espaçonave:");
        String nome = in.nextLine();
        System.out.println("Por favor insira em qual espaço-porto a nave está:");
        String local = in.nextLine();

        if(cadastros.porcuraespaçoporto(local)==null){
            System.out.println("=============================================================================");
            System.out.println("Nenhum Espaço-porto encontrado com esse nome, deseja cadastrar como Terra?");
            System.out.println("[1] - Sim.");
            System.out.println("[2] - Não.");
            System.out.println("=============================================================================");
            int opção = in.nextInt();

            if(opção==1){
                Espaconave e = new Espaconave(nome , cadastros.porcuraespaçoporto("Terra"));
                if(!cadastros.cadastraesp(e)){
                    System.out.println("Espaçonave já existente.");
                    return;
                }
                System.out.println("Espaço-porto cadastrado como Terra.");
                return;
            }
            System.out.println("Voltando para o menu...");
            return;
        }
        Espaconave e = new Espaconave(nome, cadastros.porcuraespaçoporto(local));
        if(!cadastros.cadastraesp(e)){
            System.out.println("Espaçonave já existente.");
            return;
        }
        System.out.println("Espaço porto cadastrado com sucesso");
    }

    public void cadastraEspaçoPort(){
        System.out.println("Por favor, insira o número:");
        int numero = in.nextInt();
        System.out.println("Por favor, insira o nome:");
        String nome = in.nextLine();
        System.out.println("Por favor, insira o cordenada X:");
        double x = in.nextDouble();
        System.out.println("Por favor, insira o cordenada Y:");
        double y = in.nextDouble();
        System.out.println("Por favor, insira o cordenada Z:");
        double z = in.nextDouble();


        EspacoPorto e = new EspacoPorto(numero, nome, x , y , z );

        if(!cadastros.cadastraEspaçoPort(e)){
            System.out.println("Espaçonave já existente.");
            return;
        }
        System.out.println("Espaço porto cadastrado com sucesso");

    }

    /*
    public void cadasdtraTransp(){
        System.out.println("=============================");
        System.out.println("Insira o tipo do transporte:");
        System.out.println("[1] - Transporte de pessoas.");
        System.out.println("[2] - Transporte de materais");
        System.out.println("=============================");

        int opção = in.nextInt();

        if(opção == 1){
            System.out.println("Por favor insira o identificador:");
            int identificador = in.nextInt();


        }

    }

     */
}
