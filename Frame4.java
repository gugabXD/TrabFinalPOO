import TrabFinalPOO.Cadastros;
import TrabFinalPOO.Transporte;

import javax.swing.*;
import java.util.ArrayList;

public class Frame4 extends JFrame{
    private JPanel panel4;
    private JScrollBar scrollBar1;
    private JLabel pp;
    private JList resp;

    public Frame4() {
        setContentPane(panel4);
        setTitle("Interface Gráfica");
        setSize(400, 1000);
        setVisible(true);

        ArrayList<Transporte> lista = Cadastros.getInstance().consultaTransp();
        JList<String> resp = new JList<>((ListModel) lista);
        if(lista==null){
        pp.setText("Erro. Não há nenhum transporte cadastrado");
        }

    }
}
