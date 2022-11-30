package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1o extends JFrame{
    private JTextField num;
    private JTextField cordX;
    private JTextField cordY;
    private JTextField cordZ;
    private JButton enviarButton;
    private JPanel panel1;
    private JTextField nomeEP;
    private JLabel resp;


    public Frame1o() {
        setContentPane(panel1);
        setTitle("Interface Gráfica");
        setSize(500, 300);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int numero = Integer.parseInt(num.getText());
                    String nome = nomeEP.getText();
                    double x = Double.parseDouble(cordX.getText());
                    double y = Double.parseDouble(cordY.getText());
                    double z = Double.parseDouble(cordZ.getText());

                    EspacoPorto ep = new EspacoPorto(numero, nome, x , y , z );
                    if(!Cadastros.getInstance().cadastraEspaçoPort(ep)){
                        resp.setText("Erro. Espaço-Porto já existente.");
                        return;
                    }
                    resp.setText("Espaço-porto cadastrado com sucesso");
                }
                catch(Exception ex){
                    System.err.print(ex);
                }

            }

        });
    }

}


