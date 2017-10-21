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
import java.util.logging.Level;
import java.util.logging.Logger;
import spacecup.Conexao.Conexao;
import spacecup.Model.Cidade;

/**
 *
 * @author pauloh
 */
public class CidadeDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public Cidade getById(int id) {
        Cidade cidade = null;
        con = new Conexao().getConnection();

        sql = "select * from cidade where cidade_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                cidade = new Cidade(id, rs.getString("nome"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidade;
    }

    public List<Cidade> getCidades() {
        List<Cidade> lista = new ArrayList<>();

        try {
            sql = "select * from cidade";

            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Cidade(rs.getInt("cidade_id"), rs.getString("nome")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void insere(Cidade c) {
        try {
            con = new Conexao().getConnection();
            sql = "insert into cidade values(?,?)";

            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNome());

            ps.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altera(Cidade c) {
        try {
            con = new Conexao().getConnection();
            sql = "UPDATE `cidade` SET `nome`=? WHERE `cidade_id`=?";

            ps = con.prepareStatement(sql);
            
            ps.setString(1, c.getNome());
            ps.setInt(2, c.getId());            

            ps.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
