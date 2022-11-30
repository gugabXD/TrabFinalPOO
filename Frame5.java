import TrabFinalPOO.Cadastros;
import TrabFinalPOO.Transporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame5 extends JFrame{
    private JTextField iden;
    private JButton enviarButton;
    private JPanel panel5;
    private JLabel resp;
    private int ident;
    public Frame5() {
        setContentPane(panel5);
        setTitle("Interface Gráfica");
        setSize(500, 100);
        setVisible(true);


        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ident = Integer.parseInt(iden.getText());
                Transporte t = Cadastros.getInstance().procuraTransp(ident);
                if(t==null){
                resp.setText("Erro. Transporte inexistente.");
                return;
                }
                String estado = t.getEstado();
                if(estado.equals("CANCELADO") || t.getEstado().equals("FINALIZADO")) {
                resp.setText("Erro. Estado imutável.");
                return;
                }
                else if(estado.equals("PENDENTE")){
                    new Frame14();
                }
                else
                    new Frame15();
            }
        });

    }
    public int getIdent(){
        return ident;
    }
}
