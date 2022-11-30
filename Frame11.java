import TrabFinalPOO.EspacoPorto;
import TrabFinalPOO.Transporte;
import TrabFinalPOO.TransporteMaterial;
import TrabFinalPOO.TransportePessoas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame11 extends JFrame {
    private JButton transporteDePessoasButton;
    private JButton transporteDeMateraisButton;
    private JPanel panel11;

    public Frame11() {
        setContentPane(panel11);
        setTitle("Interface Gráfica");
        setSize(350, 300);
        setVisible(true);

        transporteDePessoasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame12();
            }
        });
        transporteDeMateraisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame13();
            }
        });
    }
}
