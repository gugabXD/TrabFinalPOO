package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame32 extends JFrame{
    private JPanel panel31;
    private JButton íonButton;
    private JButton nuclearButton;
    private JLabel resp;
    private JPanel panel32;

    private Frame2 f2;
    private Frame27 f27;

    public Frame32() {
        setContentPane(panel31);
        setTitle("Interface Gráfica");
        setSize(550, 300);
        setVisible(true);

        íonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String combustivel= "ion";
                NaveSubluz s = new NaveSubluz(f2.getNome(), Cadastros.getInstance().procuraEspacoPorto(11), f27.getVelocidadeimp(), combustivel);

                if(!Cadastros.getInstance().cadastraEspNav(s)){
                    resp.setText("Espaçonave já existe.");
                    return;
                }
                resp.setText("Espaçonave criada com sucesso.");
            }
        });
        nuclearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String combustivel= "nuclear";
                NaveSubluz s = new NaveSubluz(f2.getNome(), Cadastros.getInstance().procuraEspacoPorto(11), f27.getVelocidadeimp(), combustivel);

                if(!Cadastros.getInstance().cadastraEspNav(s)){
                    resp.setText("Espaçonave já existe.");
                    return;
                }
                resp.setText("Espaçonave criada com sucesso.");
            }
        });
    }
}
