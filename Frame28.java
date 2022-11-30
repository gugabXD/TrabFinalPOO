package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame28 extends JFrame{
    private JButton CSVButton;
    private JButton JSONButton;
    private JPanel panel28;

    public Frame28() {
        setContentPane(panel28);
        setTitle("Interface Gráfica");
        setSize(400, 300);
        setVisible(true);


        CSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame29();
            }
        });
        JSONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame30();
            }
        });
    }
}
