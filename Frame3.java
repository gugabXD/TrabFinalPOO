import TrabFinalPOO.Cadastros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame3 extends JFrame{
    private JTextField iden;
    private JPanel panel3;
    private JButton enviarButton;
    private JLabel resp;

    private int ident;
    public Frame3() {
        setContentPane(panel3);
        setTitle("Interface Gráfica");
        setSize(400, 200);
        setVisible(true);


        //System.out.println("Insira o identificador do transporte");
        //        int ident = Integer.parseInt(in.nextLine());
        //        if(c.procuraTransp(ident)!=null){
        //            System.out.println("Erro. Transporte já existente.");
        //            return;
        //        }
        //        System.out.println("=============================");
        //        System.out.println("Insira o tipo do transporte:");
        //        System.out.println("[1] - Transporte de pessoas");
        //        System.out.println("[2] - Transporte de materais");
        //        System.out.println("=============================");
        //        int opcao;
        //        do { opcao = Integer.parseInt(in.nextLine());
        //        switch(opcao){
        //            case 1-> cadastraTranspP(ident);
        //            case 2-> cadastraTranspM(ident);
        //            default -> System.out.println("Insira uma opção válida.");
        //        } } while(opcao!=1 && opcao!=2);


        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ident = Integer.parseInt(iden.getText());
                if (Cadastros.getInstance().procuraTransp(ident) != null) {
                    resp.setText("Erro. Transporte já existente.");
                    return;
                }
                new Frame11();
            }
        });
    }
    public int getIdent() {
        return ident;
    }
}

