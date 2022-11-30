import TrabFinalPOO.Cadastros;
import TrabFinalPOO.EspacoPorto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Frame16 extends JFrame{
    private JTextField local;
    private JButton enviarButton;
    private JPanel panel16;
    private JLabel resp;

    public Frame16(){
        setContentPane(panel16);
        setTitle("Interface Gráfica");
        setSize(500, 250);
        setVisible(true);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedReader leitor;
                try{
                    leitor = new BufferedReader(new FileReader(local.getText()+".dat"));
                    String linha;
                    leitor.readLine();
                    while (true) {
                        linha = leitor.readLine();
                        if (linha == null) break;
                        lerESPPORT(linha);
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                catch(Exception ex){
                    System.err.print(ex);
                }
            }
        });

    }
    public void lerESPPORT(String linha){
        String[] res = linha.split(";", 0);
        EspacoPorto esp = new EspacoPorto(Integer.parseInt(res[0]), res[1], Double.parseDouble(res[2]), Double.parseDouble(res[3]), Double.parseDouble(res[4]));
        boolean resultado = Cadastros.getInstance().cadastraEspaçoPort(esp);
        if(!resultado) resp.setText("Erro. Identificador repetido");
    }
}
