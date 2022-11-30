import TrabFinalPOO.Cadastros;
import TrabFinalPOO.Transporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame14 extends JFrame{
    private JButton CANCELADOButton;
    private JButton TRANSPORTANDOButton;
    private JPanel panel14;
    private JLabel resp;

    Frame5 f5;
    public Frame14() {
        Transporte t = Cadastros.getInstance().procuraTransp(f5.getIdent());
        setContentPane(panel14);
        setTitle("Interface Gráfica");
        setSize(500, 300);
        setVisible(true);
        TRANSPORTANDOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setEstado(4);
                resp.setText("Transporte finalizado com sucesso.");
                Cadastros.getInstance().finalizaTransporte(t);
            }
        });
        CANCELADOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setEstado(2);
                resp.setText("Transporte cancelado.");
                Cadastros.getInstance().finalizaTransporte(t);
            }
        });
    }
}
