package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame6 extends JFrame{
    private JPanel panel6;
    private JButton espaçoPortoButton;
    private JButton espaçonaveButton;
    private JButton transporteButton;

    public Frame6(){
        setContentPane(panel6);
        setTitle("Interface Gráfica");
        setSize(250, 350);
        setVisible(true);
        espaçoPortoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame16();
            }
        });
        espaçonaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Frame17();
            }
        });
        transporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Frame18();
            }
        });
    }
}
