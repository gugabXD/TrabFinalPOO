package TrabFinalPOO;

import javax.swing.*;

public class Frame7 extends JFrame{
    private JPanel panel7;
    private JLabel resp;

    public Frame7() {
        setContentPane(panel7);
        setTitle("Interface Gráfica");
        setSize(500, 300);
        setVisible(true);

        boolean res = Cadastros.getInstance().designaTransp();
        if(!res) resp.setText("Erro. Não há transportes pendentes.");
        else resp.setText("Todos as espaçonaves aptas foram designadas aos respectivos transportes.");
    }
}
