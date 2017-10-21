package spacecup.Model;

public class Turma {

    private int id;
    private String nome;
    private Competicao competicao;

    public Turma(int id, String nome, Competicao competicao) {
        this.id = id;
        this.nome = nome;
        this.competicao = competicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }


}
