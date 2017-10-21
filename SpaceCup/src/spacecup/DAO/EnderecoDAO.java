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
import spacecup.Model.Endereco;

/**
 *
 * @author pauloh
 */
public class EnderecoDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public Endereco getById(int numero, String cep) {
        Endereco endereco = null;

        try {
            sql = "select * from endereco where numero = ? and cep = ?";
            con = new Conexao().getConnection();

            ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.setString(2, cep);
            rs = ps.executeQuery();

            while (rs.next()) {
                endereco = new Endereco(numero, cep, rs.getString("descricao"), new CidadeDAO().getById(rs.getInt("cidade_id")).getNome(), rs.getString("rua"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return endereco;
    }

    public List<Endereco> getEndereco() {
        List<Endereco> lista = new ArrayList<>();

        con = new Conexao().getConnection();

        try {
            sql = "select * from endereco";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Endereco(rs.getInt("numero"), rs.getString("cep"), rs.getString("descricao"), new CidadeDAO().getById(rs.getInt("cidade_id")).getNome(), rs.getString("rua")));
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void inserir(Endereco e) {
        con = new Conexao().getConnection();

        try {
            sql = "INSERT INTO `endereco` VALUES (?,?,?,(select cidade_id from cidade where nome = ?),?)";
            ps = con.prepareStatement(sql);

            ps.setInt(1, e.getNumero());
            ps.setString(2, e.getCep());
            ps.setString(3, e.getDescricao());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getRua());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Endereco e) {
        con = new Conexao().getConnection();

        try {
            sql = "UPDATE `endereco` SET ,`descricao`=?,`cidade_id`=(select cidade_id from cidade where nome = ?),`rua`=? WHERE `numero`= ? and `cep`=?";
            ps = con.prepareStatement(sql);

            ps.setInt(4, e.getNumero());
            ps.setString(5, e.getCep());
            ps.setString(1, e.getDescricao());
            ps.setString(2, e.getCidade());
            ps.setString(3, e.getRua());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
