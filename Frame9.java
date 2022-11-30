package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame9 extends JFrame {
    private JTextField local;
    private JButton enviarButton;
    private JPanel panel9;
    private String lugar;

    public Frame9() {
        setContentPane(panel9);
        setTitle("Interface Gráfica");
        setSize(400, 300);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lugar = local.getText();
                new Frame28();
            }
        });
    }
    public String getLugar(){
        return lugar;
    }
}

