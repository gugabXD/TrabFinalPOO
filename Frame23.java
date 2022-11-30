package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame23 extends JFrame {
    private JTextField vel;
    private JTextField carga;
    private JLabel resp;
    private JButton enviarButton;
    private JPanel panel23;
    Frame2 f2;

    public Frame23() {
        setContentPane(panel23);
        setTitle("Interface Gráfica");
        setSize(550, 200);
        setVisible(true);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Cadastros.getInstance().procuraEspacoPorto(11)==null) Cadastros.getInstance().precadastraTerra();
                double velocidade = Double.parseDouble(vel.getText());
                double quantidade = Double.parseDouble(carga.getText());
                NaveFTL n = new NaveFTL(f2.getNome(), Cadastros.getInstance().procuraEspacoPorto(f2.getEspPorto()), velocidade, quantidade);
                if(!Cadastros.getInstance().cadastraEspNav(n)) {
                    resp.setText("Espaçonave já existe.");
                    return;
                }
                    resp.setText("Espaçonave criada com sucesso.");
            }
        });
    }
}
