package spacecup.Model;

public class Foguete {

    private int id;
    private float peso;
    private float tamanho;

    public Foguete(int id, float peso, float tamanho) {
        this.id = id;
        this.peso = peso;
        this.tamanho = tamanho;
    }

    public Foguete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

}
