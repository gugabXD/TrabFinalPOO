package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame15 extends JFrame{
    private JButton canceladoButton;
    private JButton finalizadoButton;
    private JPanel panel15;
    private JLabel resp;
    private JButton pendenteButton;

    Frame5 f5;

    public Frame15() {
        Transporte t = Cadastros.getInstance().procuraTransp(f5.getIdent());
        setContentPane(panel15);
        setTitle("Interface Gráfica");
        setSize(600, 400);
        setVisible(true);
        finalizadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setEstado(4);
                resp.setText("Transporte finalizado com sucesso.");
                Cadastros.getInstance().setLocalNovo(t);
                Cadastros.getInstance().finalizaTransporte(t);
            }
        });
        canceladoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setEstado(2);
                resp.setText("Transporte cancelado.");
                Cadastros.getInstance().finalizaTransporte(t);
            }
        });
        pendenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setEstado(1);
                resp.setText("Transporte novamente pendente");
                Cadastros.getInstance().addPendente(t);
            }
        });
    }}
