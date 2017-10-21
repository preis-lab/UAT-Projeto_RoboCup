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
import spacecup.Model.Usuario;

/**
 *
 * @author pauloh
 */
public class UsuarioDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public Usuario autentica(int id, String senha) {
        Usuario usuario = null;
        try {
            con = new Conexao().getConnection();
            sql = "select * from aluno where usuario_id = ? and senha = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, senha);

            rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(rs.getInt("usuario_id"), rs.getString("nome"), senha, id);
            }

            if (rs.next() == false) {
                sql = "select * from administrador where usuario_id = ? and senha = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, senha);
                rs = ps.executeQuery();

                while (rs.next()) {
                    usuario = new Usuario(rs.getInt("usuario_id"), rs.getString("nome"), senha, id);
                }
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    public List<Usuario> getAlunos() {
        List<Usuario> alunos = new ArrayList<Usuario>();
        try {
            con = new Conexao().getConnection();
            sql = "select * from aluno";

            ps = con.prepareStatement(sql);;

            rs = ps.executeQuery();

            while (rs.next()) {
                 new Usuario(rs.getInt("usuario_id"), rs.getString("nome"), senha, id);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void adicionaUsuario(Usuario u) {

    }
}
