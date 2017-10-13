package spacecup.Model;

import java.util.Date;

public class Lancamento {

    private int id;
    private float distanciaDoAlvo;
    private float anguloLancamento;
    private float velocidadeVento;
    private float altitudeMaxima;
    private float altitudeEjecao;
    private float picoAceleracao;
    private float aceleracaoMedia;
    private float taxaDescida;
    private float distanciaEntreQuedaAlvo;
    private Date tempoApogeuAescida;
    private Date duracaoVoo;
    private Date tempoPropulsao;

    public Lancamento(int id, float distanciaDoAlvo, float anguloLancamento, float velocidadeVento, float altitudeMaxima, float altitudeEjecao, float picoAceleracao, float aceleracaoMedia, float taxaDescida, float distanciaEntreQuedaAlvo, Date tempoApogeuAescida, Date duracaoVoo, Date tempoPropulsao) {
        this.id = id;
        this.distanciaDoAlvo = distanciaDoAlvo;
        this.anguloLancamento = anguloLancamento;
        this.velocidadeVento = velocidadeVento;
        this.altitudeMaxima = altitudeMaxima;
        this.altitudeEjecao = altitudeEjecao;
        this.picoAceleracao = picoAceleracao;
        this.aceleracaoMedia = aceleracaoMedia;
        this.taxaDescida = taxaDescida;
        this.distanciaEntreQuedaAlvo = distanciaEntreQuedaAlvo;
        this.tempoApogeuAescida = tempoApogeuAescida;
        this.duracaoVoo = duracaoVoo;
        this.tempoPropulsao = tempoPropulsao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDistanciaDoAlvo() {
        return distanciaDoAlvo;
    }

    public void setDistanciaDoAlvo(float distanciaDoAlvo) {
        this.distanciaDoAlvo = distanciaDoAlvo;
    }

    public float getAnguloLancamento() {
        return anguloLancamento;
    }

    public void setAnguloLancamento(float anguloLancamento) {
        this.anguloLancamento = anguloLancamento;
    }

    public float getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(float velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public float getAltitudeMaxima() {
        return altitudeMaxima;
    }

    public void setAltitudeMaxima(float altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }

    public float getAltitudeEjecao() {
        return altitudeEjecao;
    }

    public void setAltitudeEjecao(float altitudeEjecao) {
        this.altitudeEjecao = altitudeEjecao;
    }

    public float getPicoAceleracao() {
        return picoAceleracao;
    }

    public void setPicoAceleracao(float picoAceleracao) {
        this.picoAceleracao = picoAceleracao;
    }

    public float getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(float aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public float getTaxaDescida() {
        return taxaDescida;
    }

    public void setTaxaDescida(float taxaDescida) {
        this.taxaDescida = taxaDescida;
    }

    public float getDistanciaEntreQuedaAlvo() {
        return distanciaEntreQuedaAlvo;
    }

    public void setDistanciaEntreQuedaAlvo(float distanciaEntreQuedaAlvo) {
        this.distanciaEntreQuedaAlvo = distanciaEntreQuedaAlvo;
    }

    public Date getTempoApogeuAescida() {
        return tempoApogeuAescida;
    }

    public void setTempoApogeuAescida(Date tempoApogeuAescida) {
        this.tempoApogeuAescida = tempoApogeuAescida;
    }

    public Date getDuracaoVoo() {
        return duracaoVoo;
    }

    public void setDuracaoVoo(Date duracaoVoo) {
        this.duracaoVoo = duracaoVoo;
    }

    public Date getTempoPropulsao() {
        return tempoPropulsao;
    }

    public void setTempoPropulsao(Date tempoPropulsao) {
        this.tempoPropulsao = tempoPropulsao;
    }

    
}
