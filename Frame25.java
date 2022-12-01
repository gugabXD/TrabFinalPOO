package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame25 extends JFrame {
    private JButton naveFTLButton;
    private JButton naveSubluzButton;
    private JPanel panel25;
    private JPanel panel22;

    public Frame25() {
        setContentPane(panel25);
        setTitle("Interface Gráfica");
        setSize(550, 200);
        setVisible(true);

        naveFTLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame26();
            }
        });
        naveSubluzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame27();
            }
        });
    }
}
