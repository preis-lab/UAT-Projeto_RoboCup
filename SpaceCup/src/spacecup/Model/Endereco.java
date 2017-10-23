package spacecup.Model;
public class Endereco {

    private int numero;
    private String cep;
    private String descricao;
    private String cidade;    
    private String rua;

    public Endereco(int numero, String cep, String descricao, String cidade, String rua) {
        this.numero = numero;
        this.cep = cep;
        this.descricao = descricao;
        this.cidade = cidade;
        this.rua = rua;
    }

    public Endereco() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    
}
