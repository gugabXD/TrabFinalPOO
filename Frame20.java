import TrabFinalPOO.Cadastros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame20 extends JFrame{
    private JTextField nomeArq;
    private JButton enviarButton;
    private JLabel resp;
    private JPanel panel20;

    public Frame20(){
        setContentPane(panel20);
        setTitle("Interface Gráfica");
        setSize(400, 300);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeArq.getText();
                if(Cadastros.getInstance().salvaDadosArquivoXML(nome)) {
                    resp.setText("Arquivo criado com sucesso.");
                    return;

                }
                resp.setText("Não foi possível criar o arquivo.");
            }
        });
    }}

