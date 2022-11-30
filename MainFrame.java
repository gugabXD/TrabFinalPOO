package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JButton Button;
    private JButton cadastrarNovaEspaçonaveButton;
    private JButton cadastrarNovoTransporteButton;
    private JButton consultarTodosOsTransportesButton;
    private JButton alterarEstadoDeTransporteButton;
    private JButton carregarDadosIniciaisButton;
    private JButton designarTransportesButton;
    private JButton salvarDadosButton;
    private JPanel mainPanel;
    private JButton carregarDadosButton;
    private JButton finalizarSistemaButton;


    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Interface Gráfica");
        setSize(1000, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        finalizarSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Frame1o();
            }
        });
        cadastrarNovaEspaçonaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2();
            }
        });
        cadastrarNovoTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame3();
            }
        });
        alterarEstadoDeTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame5();
            }
        });
        consultarTodosOsTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame4();
            }
        });
        carregarDadosIniciaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame6();
            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame8();
            }
        });
        designarTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame7();
            }
        });
    }
}
