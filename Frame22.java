package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame22 extends JFrame {
    private JButton naveFTLButton;
    private JButton naveSubluzButton;
    private JPanel panel22;

    public Frame22() {
        setContentPane(panel22);
        setTitle("Interface Gráfica");
        setSize(550, 200);
        setVisible(true);

        naveFTLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame23();
            }
        });
        naveSubluzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Frame24();
            }
        });
    }
}
