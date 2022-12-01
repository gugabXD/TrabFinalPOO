package TrabFinalPOO;
import org.junit.Assert;
import org.junit.Test;//JUNIT 4
public class TransporteMaterialTest {
    @Test
    public void testeGeraResumo(){
        EspacoPorto ep1 = new EspacoPorto(4, "alexander", 123, 321, 123);
        EspacoPorto ep2 = new EspacoPorto(4, "sabado", 321, 321, 123);

        Transporte tr = new TransporteMaterial(3, ep1, ep2, "ouro", 1000);
        String test = "3"+ ";" + ep1.getNumero()+ ";" + ep2.getNumero() + ";"+ "ouro" + ";" + "1000";
        test.equals(tr.geraResumo());
    }
    @Test
    public void testeCalculaDistancia(){
        EspacoPorto ep1 = new EspacoPorto(4, "alexander", 123, 321, 123);
        EspacoPorto ep2 = new EspacoPorto(4, "sabado", 321, 321, 123);

        Transporte tr = new TransporteMaterial(3, ep1, ep2, "ouro", 1000);
        EspacoPorto or=tr.getOrigem();
        EspacoPorto de=tr.getDestino();
        double dist = Math.pow((or.getCoordX()-de.getCoordX()),2)+Math.pow((or.getCoordY()-de.getCoordY()),2)+Math.pow((or.getCoordZ()-de.getCoordZ()),2);
        Assert.assertEquals(Math.sqrt(dist), tr.calculaDistancia());
    }
    @Test
    public void testeCalculaCusto(){
        EspacoPorto ep1 = new EspacoPorto(4, "alexander", 123, 321, 123);
        EspacoPorto ep2 = new EspacoPorto(4, "sabado", 321, 321, 123);
        Transporte tr = new TransporteMaterial(3, ep1, ep2, "ouro", 1000);
        double custoDist, custoTransp, fatorDist;
        double distancia =tr.getDistancia();
        if(distancia<0.5) fatorDist = 1000000;
        else fatorDist = 100;
        custoDist = fatorDist * distancia;
        custoTransp = tr.getCarga() * 500;
        Assert.assertEquals(custoDist * custoTransp, tr.calculaCusto());
    }
}
