/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacecup.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import spacecup.Conexao.Conexao;
import spacecup.Model.Turma;

/**
 *
 * @author pauloh
 */
public class TurmaDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public List<Turma> getTurma() {
        List<Turma> lista = new ArrayList<>();
        try {
            con = new Conexao().getConnection();
            sql = "select * from turma ";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Turma(rs.getInt("turma_id"), rs.getString("nome"), new CompeticaoDAO().getById(rs.getInt("competicao_id"))));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void altera(Turma t) {
        try {
            con = new Conexao().getConnection();
            sql = "UPDATE `turma` SET `nome`=?,`competicao_id`=? WHERE `turma_id`=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, t.getNome());
            ps.setInt(2, t.getCompeticao().getId());
            ps.setInt(3, t.getId());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insere(Turma t) {
        try {
            con = new Conexao().getConnection();
            sql = "INSERT INTO `turma` VALUES (?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, t.getId());
            ps.setString(2, t.getNome());
            ps.setInt(3, t.getCompeticao().getId());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Turma getById(int id) {
        Turma c = null;

        try {

            con = new Conexao().getConnection();
            sql = "select * from turma where turma_id = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                c = new Turma(rs.getInt("turma_id"), rs.getString("nome"), new CompeticaoDAO().getById(rs.getInt("competicao_id")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;

    }

    public List<String> getNomes() {
        List<String> lista = new ArrayList<>();
        try {
            con = new Conexao().getConnection();
            sql = "select distinct nome from turma";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Turma getByNome(String nome) {
        Turma c = null;

        try {

            con = new Conexao().getConnection();
            sql = "select * from turma where nome = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();

            if (rs.next()) {
                c = new Turma(rs.getInt("turma_id"), rs.getString("nome"), new CompeticaoDAO().getById(rs.getInt("competicao_id")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}

