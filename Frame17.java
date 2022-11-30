package TrabFinalPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Frame17 extends JFrame {
    private JTextField local;
    private JButton enviarButton;
    private JLabel resp;
    private JPanel panel17;

    public Frame17() {
        setContentPane(panel17);
        setTitle("Interface Gráfica");
        setSize(500, 250);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedReader leitor;
                try {
                    leitor = new BufferedReader(new FileReader(local.getText() + ".dat"));
                    String linha;
                    leitor.readLine();
                    while (true) {
                        linha = leitor.readLine();
                        if (linha == null) break;
                        lerESPNAVE(linha);
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    System.err.print(ex);
                }
            }
        });
    }
    public void lerESPNAVE (String linha){
        String[] res = linha.split(";", 0);
        int tipo = Integer.parseInt(res[0]);
        Espaconave nave;
        if(tipo==1) nave = new NaveSubluz(res[1],Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[2])), Double.parseDouble(res[3]), res[4]);
        else nave = new NaveFTL(res[1], Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[2])), Double.parseDouble(res[3]), Double.parseDouble(res[4]));
        boolean resultado = Cadastros.getInstance().cadastraEspNav(nave);
        if(!resultado) resp.setText("Erro. Essa nave já existe.");
    }
}