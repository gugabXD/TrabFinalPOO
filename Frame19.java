package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame19 extends JFrame{
    private JTextField nomeArq;
    private JButton enviarButton;
    private JPanel panel19;
    private JLabel resp;

    public Frame19(){
        setContentPane(panel19);
        setTitle("Interface Gráfica");
        setSize(400, 300);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeArq.getText();

                if (Cadastros.getInstance().salvaTransporte(nome) && Cadastros.getInstance().salvaNaves(nome + "(1)") && Cadastros.getInstance().salvaEspacoPorto(nome + "(2)")) {
                    resp.setText("Arquivo criado com sucesso");
                }
                resp.setText("Não foi possível criar o arquivo");
            }
        });
    }}
