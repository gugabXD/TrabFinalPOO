package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame3 extends JFrame{
    private JTextField iden;
    private JPanel panel3;
    private JButton enviarButton;
    private JLabel resp;

    private int ident;
    public Frame3() {
        setContentPane(panel3);
        setTitle("Interface Gráfica");
        setSize(400, 200);
        setVisible(true);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ident = Integer.parseInt(iden.getText());
                if (Cadastros.getInstance().procuraTransp(ident) != null) {
                    resp.setText("Erro. Transporte já existente.");
                    return;
                }
                new Frame11();
            }
        });
    }
    public int getIdent() {
        return ident;
    }
}

