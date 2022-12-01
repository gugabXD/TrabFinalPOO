package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame8 extends JFrame{
    private JButton CSVButton;
    private JButton XMLButton;
    private JPanel panel8;
    private JButton CSVEXMLButton;
    private JLabel resp;

    public Frame8(){
        setContentPane(panel8);
        setTitle("Interface Gráfica");
        setSize(400, 300);
        setVisible(true);
        CSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Frame19();
            }
        });
        XMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Frame20();
            }
        });
        CSVEXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Frame21();
            }
        });
    }
}
