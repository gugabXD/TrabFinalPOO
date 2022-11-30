package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame12 extends JFrame{
    private JTextField origem;
    private JTextField destino;
    private JTextField quant;
    private JButton enviarButton;
    private JLabel resp;
    private JPanel panel12;

    private Frame3 f3;
    public Frame12() {
        setContentPane(panel12);
        setTitle("Interface Gráfica");
        setSize(350, 300);
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
                int quantPessoas = Integer.parseInt(quant.getText());
                Transporte tp = new TransportePessoas(f3.getIdent(), origem, destino, quantPessoas);
                Cadastros.getInstance().cadastraTransp(tp);
                resp.setText("Transporte cadastrado com sucesso!");
            }
        });
    }


}
