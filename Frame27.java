package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame27 extends JFrame{
    private JPanel panel24;
    private JTextField vel;
    private JTextField comb;
    private JButton enviarButton;
    private JLabel resp;
    private JPanel panel27;

    Frame2 f2;
    private double velocidadeimp;
    public Frame27() {
        setContentPane(panel27);
        setTitle("Interface Gráfica");
        setSize(550, 200);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                velocidadeimp = Double.parseDouble(vel.getText());
                if(velocidadeimp > 0.3){
                    velocidadeimp = 0.3;
                    resp.setText("Velocidade máxima inserida é maior que o limite, portanto foi definida como 0.3 Warp");
                }
                new Frame31();
            }
        });
    }
    public double getVelocidadeimp(){
        return velocidadeimp;
    }

}

