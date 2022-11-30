package TrabFinalPOO;

import org.junit.Test;//JUNIT 4
public class NaveFTLTest {
    @Test
    public void testeGeraResumo(){
        String nome = "s";
        int numero=1;
        double coordX=1;
        double coordY=1;
        double coordZ=1;
        EspacoPorto ep = new EspacoPorto(numero, nome, coordX, coordY, coordZ);
        Espaconave en = new NaveFTL("jorge", ep, 1, 1);
        String test = "s" + ";" + ep.getNumero() + ";" + "1" + ";" + "1" + ";";
        test.equals(ep.geraResumo());
    }

}
