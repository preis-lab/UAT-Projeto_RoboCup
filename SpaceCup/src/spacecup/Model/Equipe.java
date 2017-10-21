package spacecup.Model;

public class Equipe {

    private int id;
    private String nome;
    private boolean classificado;
    private int turmaId;

    public Equipe(String nome, int id, boolean classificado, int turmaId) {
        this.nome = nome;
        this.id = id;
        this.classificado = classificado;
        this.turmaId = turmaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isClassificado() {
        return classificado;
    }

    public void setClassificado(boolean classificado) {
        this.classificado = classificado;
    }

    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }

}
