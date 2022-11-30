package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame30 extends JFrame{
    private JPanel panel29;
    private JButton espaçonavesButton;
    private JButton espaçoPortosButton;
    private JButton transportesButton;
    private JLabel resp;
    private JPanel panel30;

    Frame9 f9;

    public Frame30() {
        setContentPane(panel29);
        setTitle("Interface Gráfica");
        setSize(400, 300);
        setVisible(true);
        espaçonavesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastros.getInstance().leituraNavesJSON(f9.getLugar());
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
