package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame29 extends JFrame{
    private JButton espaçonavesButton;
    private JButton espaçoPortosButton;
    private JButton transportesButton;
    private JPanel panel29;
    private JLabel resp;

    Frame9 f9;
    public Frame29() {
        setContentPane(panel29);
        setTitle("Interface Gráfica");
        setSize(400, 300);
        setVisible(true);
        espaçonavesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastros.getInstance().leituraEspaconave(f9.getLugar());
            }
        });
        espaçoPortosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastros.getInstance().leituraEspacoPorto(f9.getLugar());
            }
        });
        transportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastros.getInstance().leituraTransporte(f9.getLugar());
            }
        });
    }
}
