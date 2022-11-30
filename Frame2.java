package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends JFrame {
    private JTextField nomEsp;
    private JTextField iden;
    private JPanel panel2;
    private JButton enviarButton;
    private JTextField tipo;
    private JLabel resp;
    private int espPorto;
    private String nome;
    public Frame2() {
        setContentPane(panel2);
        setTitle("Interface Gráfica");
        setSize(700, 300);
        setVisible(true);


        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nome = nomEsp.getText();
                espPorto = Integer.parseInt(iden.getText());
                if(Cadastros.getInstance().procuraEspacoPorto(espPorto)==null){
                    new Frame10();
                    Espaconave en = new Espaconave(nome , Cadastros.getInstance().procuraEspacoPorto(0));
                }
                new Frame25();
            }
        });
    }
    public int getEspPorto(){
        return espPorto;
    }
    public String getNome(){
        return nome;
    }

}
