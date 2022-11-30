import TrabFinalPOO.Cadastros;
import TrabFinalPOO.Espaconave;

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

    public Frame2() {
        setContentPane(panel2);
        setTitle("Interface Gráfica");
        setSize(700, 300);
        setVisible(true);


        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomEsp.getText();
                int espPorto = Integer.parseInt(iden.getText());
                if(Cadastros.getInstance().procuraEspacoPorto(espPorto)==null){
                    new Frame10();
                    Espaconave en = new Espaconave(nome , Cadastros.getInstance().procuraEspacoPorto(0));
                    if(!Cadastros.getInstance().cadastraEspNav(en)) {

                    }

                }
            }
        });
    }
}
