package spacecup.Model;

public class Equipe {

    private int id;
    private String nome;
    private boolean classificado;
    private Turma turma;

    public Equipe(String nome, int id, boolean classificado, Turma turma) {
        this.nome = nome;
        this.id = id;
        this.classificado = classificado;
        this.turma = turma;
    }

    public Equipe() {
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
