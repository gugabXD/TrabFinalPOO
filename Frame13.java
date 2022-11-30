import TrabFinalPOO.Cadastros;
import TrabFinalPOO.EspacoPorto;
import TrabFinalPOO.Transporte;
import TrabFinalPOO.TransporteMaterial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame13 extends JFrame {
    private JTextField origem;
    private JTextField destino;
    private JTextField material;
    private JTextField pesoMat;
    private JPanel panel13;
    private JButton enviarButton;
    private JLabel resp;
    private Frame3 f3;

    public Frame13(){
        setContentPane(panel13);
        setTitle("Interface Gráfica");
        setSize(500, 500);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int o = Integer.parseInt(origem.getText());
                EspacoPorto origem = Cadastros.getInstance().procuraEspacoPorto(o);
                if(origem==null) {
                    resp.setText("Erro. Origem inválida");
                    return;
                }
                int d = Integer.parseInt(destino.getText());
                EspacoPorto destino = Cadastros.getInstance().procuraEspacoPorto(d);
                if(destino==null) {
                    resp.setText("Erro. Destino inválido");
                    return;
                }
                if(origem==destino){
                    resp.setText("Erro. Origem e destino iguais");
                    return;
                    }
                String descricao = material.getText();
                double carga = Double.parseDouble(pesoMat.getText());
                Transporte tm = new TransporteMaterial(f3.getIdent(), origem, destino, descricao, carga);
                Cadastros.getInstance().cadastraTransp(tm);
                resp.setText("Transporte cadastrado com sucesso!");
            }
        });
    }

}
