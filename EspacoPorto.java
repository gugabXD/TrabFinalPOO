package TrabFinalPOO;
public class EspacoPorto {

    private int numero;

    private String nome;

    private double coordX;

    private double coordY;

    private double coordZ;

    public EspacoPorto(int numero, String nome, double coordX, double coordY, double coordZ) {
        this.numero = numero;
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
        this.coordZ = coordZ;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public double getCoordZ() {
        return coordZ;
    }

    public void setCoordZ(double coordZ) {
        this.coordZ = coordZ;
    }
}
