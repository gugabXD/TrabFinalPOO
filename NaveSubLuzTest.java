package TrabFinalPOO;

import org.junit.Test;//JUNIT 4

public class NaveSubLuzTest {
    @Test
    public void testeGeraResumo(){
        EspacoPorto ep = new EspacoPorto(1, "s", 1, 1, 1);
        Espaconave en = new NaveSubluz("greftiw", ep, 1000, "ion");
        String test = "greftiw" + ";" + ep.getNumero() + ";" + "1000" + ";" + "ion" + ";";
        test.equals(en.geraResumo());
    }
}
