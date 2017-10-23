/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacecup.Model;

/**
 *
 * @author pauloh
 */
public class Usuario {
    protected int id;
    protected String nome;
    protected String senha;
    protected int nivelAcesso;

    public Usuario(){}
    
    public Usuario(int id, String nome, String senha, int nivelAcesso) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
    
}
