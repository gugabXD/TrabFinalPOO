package TrabFinalPOO;

import java.util.Scanner;

public class ACMESpace {
    private Scanner in;
    public ACMESpace(){
       in = new Scanner(System.in);
    }
    public void menu(){
        while(true) {
            System.out.println("====================");
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
            int opcao = Integer.parseInt(in.nextLine());
            trataComando(opcao);
        }
    }
    public void trataComando(int opcao){
        switch(opcao){
            case 0-> System.exit(0);
            case 1-> fazer();
            case 2-> fazer();
            case 3-> fazer();
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

}
