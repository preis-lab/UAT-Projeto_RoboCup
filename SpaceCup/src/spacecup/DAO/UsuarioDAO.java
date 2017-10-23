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
import spacecup.Model.Aluno;
import spacecup.Model.Equipe;
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
                usuario = new Usuario(rs.getInt("usuario_id"), rs.getString("nome"), senha, rs.getInt("nivel_acesso"));
            }

            if (rs.next() == false) {
                sql = "select * from administrador where usuario_id = ? and senha = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, senha);
                rs = ps.executeQuery();

                while (rs.next()) {
                    usuario = new Usuario(rs.getInt("usuario_id"), rs.getString("nome"), senha, rs.getInt("nivel_acesso"));
                }
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            con = new Conexao().getConnection();
            sql = "select * from aluno";

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {                                    
                alunos.add(new Aluno(rs.getInt("usuario_id"), rs.getString("nome") , rs.getString("senha"), rs.getInt("nivel_acesso"), new EquipeDAO().getById(rs.getInt("equipe_id"))));               
            }
                
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }
    
    public Aluno getAlunoById(int id){
        Aluno aluno = null;
            try {
            con = new Conexao().getConnection();
            sql = "select * from aluno where usuario_id = ?";
            

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();

            while (rs.next()) {                                    
                aluno = new Aluno(rs.getInt("usuario_id"), rs.getString("nome") , rs.getString("senha"), rs.getInt("nivel_acesso"), new EquipeDAO().getById(rs.getInt("equipe_id")));               
            }
                
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }
    
    public void adicionaAluno(Aluno a) {
       try {
            con = new Conexao().getConnection();
            sql = "INSERT INTO `aluno` VALUES (?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, a.getId());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getSenha());
            ps.setInt(4, 0);
            ps.setInt(5, a.getEquipe().getId());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoCompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alteraAluno(Aluno a) {
       try {
            con = new Conexao().getConnection();
            sql = "UPDATE `aluno` SET `nome`=?,`senha`=?,`nivel_acesso`=?,`equipe_id`=? WHERE `usuario_id`=?";

            ps = con.prepareStatement(sql);

            ps.setInt(5, a.getId());
            ps.setString(1, a.getNome());
            ps.setString(2, a.getSenha());
            ps.setInt(3, a.getNivelAcesso());
            ps.setInt(4, a.getEquipe().getId());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoCompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
