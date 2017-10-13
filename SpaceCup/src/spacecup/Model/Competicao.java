package spacecup.Model;

import java.util.Date;

public class Competicao {

    private int id;
    private TipoCompeticao tipoCompeticao;
    private boolean ativa;
    private Date data;
    private Endereco endereco;

    public Competicao(int id, TipoCompeticao tipoCompeticao, boolean ativa, Date data, Endereco endereco) {
        this.id = id;
        this.tipoCompeticao = tipoCompeticao;
        this.ativa = ativa;
        this.data = data;
        this.endereco = endereco;
    }
    
    public Competicao(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoCompeticao getTipoCompeticao() {
        return tipoCompeticao;
    }

    public void setTipoCompeticao(TipoCompeticao tipoCompeticao) {
        this.tipoCompeticao = tipoCompeticao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
