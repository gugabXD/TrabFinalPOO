package TrabFinalPOO;

public class TransportePessoas extends Transporte{
    private int quantPessoas;

    public TransportePessoas(int identificador, EspacoPorto origem, EspacoPorto destino, int quantPessoas){
        super(identificador, origem, destino);
        this.quantPessoas = quantPessoas;
    }
    @Override
    public double calculaCusto() {
        return 0;
    }

    @Override
    public double calculaDistancia() {
        return 0;
    }
}
