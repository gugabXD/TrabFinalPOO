import TrabFinalPOO.Cadastros;
import TrabFinalPOO.Transporte;
import TrabFinalPOO.TransporteMaterial;
import TrabFinalPOO.TransportePessoas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Frame18 extends JFrame {
    private JButton enviar;
    private JTextField local;
    private JLabel resp;
    private JPanel panel18;

    public Frame18() {
        setContentPane(panel18);
        setTitle("Interface Gráfica");
        setSize(500, 250);
        setVisible(true);

        enviar.addActionListener(new ActionListener() {
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
                        lerTRANSP(linha);
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    System.err.print(ex);
                }
            }
        });
    }
    public void lerTRANSP (String linha){
        String[] res = linha.split(";", 0);
        int tipo = Integer.parseInt(res[0]);
        Transporte transporte;
        if(tipo==1) transporte = new TransportePessoas(Integer.parseInt(res[1]),Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[2])),Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[3])), Integer.parseInt(res[4]) );
        else transporte = new TransporteMaterial(Integer.parseInt(res[1]),Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[2])),Cadastros.getInstance().procuraEspacoPorto(Integer.parseInt(res[3])), res[5], Double.parseDouble(res[4]));
        boolean resultado = Cadastros.getInstance().cadastraTransp(transporte);
        if(!resultado) resp.setText("Erro. Essa nave já existe.");
    }

}
