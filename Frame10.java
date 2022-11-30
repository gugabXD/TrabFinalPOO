import TrabFinalPOO.Cadastros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame10 extends JFrame{
    private JButton nãoButton;
    private JButton simButton;
    private JPanel panel10;
    private JLabel resp;

    public Frame10() {
        setContentPane(panel10);
        setTitle("Interface Gráfica");
        setSize(550, 200);
        setVisible(true);
        simButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }
}
