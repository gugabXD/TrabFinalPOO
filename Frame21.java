package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame21 extends JFrame{
    private JTextField nomeArq;
    private JButton enviarButton;
    private JLabel resp;
    private JPanel panel21;

    public Frame21() {
        setContentPane(panel21);
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
                else resp.setText("Não foi possível criar o arquivo");
                if (Cadastros.getInstance().salvaTranspJson(nome) && Cadastros.getInstance().salvaNavesJson(nome + "(1)") && Cadastros.getInstance().salvaEspPortJson(nome + "(2)")) {
                    resp.setText("Arquivo criado com sucesso");

                }
                else resp.setText("Não foi possível criar o arquivo");
            }
        });
    }
}
