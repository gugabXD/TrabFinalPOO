package TrabFinalPOO;
import org.junit.Assert;
import org.junit.Test; //JUNIT 4
public class TransportePessoasTest {
    @Test
    public void testeGeraResumo(){
        EspacoPorto ep1 = new EspacoPorto(4, "alexander", 123, 321, 123);
        EspacoPorto ep2 = new EspacoPorto(4, "sabado", 321, 321, 123);
        Transporte tp = new TransportePessoas(3, ep1, ep2, 1500);
        String test= 3+ ";" + ep1.getNumero()+ ";" + ep2.getNumero() + ";" + "-" + ";" + 1500 + ";";
        test.equals(tp.geraResumo());
    }
    public void testeCalculaDistancia(){
        EspacoPorto ep1 = new EspacoPorto(4, "alexander", 123, 321, 123);
        EspacoPorto ep2 = new EspacoPorto(4, "sabado", 321, 321, 123);
        Transporte tp = new TransportePessoas(3, ep1, ep2, 1500);
        EspacoPorto origem = tp.getOrigem();
        EspacoPorto destino = tp.getDestino();
        double dist = Math.pow((origem.getCoordX()-destino.getCoordX()),2)+Math.pow((origem.getCoordY()-destino.getCoordY()),2)+Math.pow((origem.getCoordZ()-destino.getCoordZ()),2);
        Assert.assertEquals(Math.sqrt(dist), tp.calculaDistancia());
    }
    public void testeCalculaCusto(){
        EspacoPorto ep1 = new EspacoPorto(4, "alexander", 123, 321, 123);
        EspacoPorto ep2 = new EspacoPorto(4, "sabado", 321, 321, 123);
        Transporte tp = new TransportePessoas(3, ep1, ep2, 1500);
        double custoDist, custoTransp, fatorDist;
        double distancia = tp.getDistancia();
        if(distancia<0.5) fatorDist = 1000000;
        else fatorDist = 100;
        custoDist = fatorDist * distancia;
        custoTransp = 1500 * 100;
        Assert.assertEquals(custoDist * custoTransp, tp.calculaCusto());
    }
}
