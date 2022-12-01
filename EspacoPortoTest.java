package TrabFinalPOO;

import org.junit.Test;//JUNIT 4

public class EspacoPortoTest {
    @Test
    public void testeToString(){
        String nome = "s";
        int numero=1;
        double coordX=1;
        double coordY=1;
        double coordZ=1;
        String to = "\nEspaço-Porto " +"s"+ ", de número "+"1"+", disposto nas coordenadas: "+
                "("+"1"+";"+"1"+";"+"1"+")";
        EspacoPorto ep = new EspacoPorto(numero, nome, coordX, coordY, coordZ);
        to.equals(ep.toString());
    }
    @Test
    public void testeGeraResumo(){
        String nome = "s";
        int numero=1;
        double coordX=1;
        double coordY=1;
        double coordZ=1;
        String to = "1" + ";" + "s" + ";" + "1" + ";" + "1" + ";" + "1" + ";";
        EspacoPorto ep = new EspacoPorto(numero, nome, coordX, coordY, coordZ);
    }
}
