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
import spacecup.Model.Equipe;

public class EquipeDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public List<Equipe> getEquipes() {
        List<Equipe> lista = new ArrayList<Equipe>();
        try {
            boolean classificado = false;
            con = new Conexao().getConnection();
            sql = "select * from equipe";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                if (rs.getInt("classificado") == 1) {
                    classificado = true;
                } else {
                    classificado = false;
                }

                lista.add(new Equipe(rs.getString("nome"), rs.getInt("equipe_id"), classificado, new TurmaDAO().getById(rs.getInt("turma_id"))));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Equipe getById(int id) {
        Equipe equipe = null;

        try {
            boolean classificado = false;

            sql = "select * from equipe where equipe_id = ?";
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt("classificado") == 1) {
                    classificado = true;
                }
                equipe = new Equipe(rs.getString("nome"), rs.getInt("equipe_id"), classificado, new TurmaDAO().getById(rs.getInt("turma_id")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipe;
    }

    public void inserir(Equipe equipe) {

        try {
            con = new Conexao().getConnection();
            sql = "INSERT INTO `equipe`  VALUES (?,?,?,?)";

            ps = con.prepareStatement(sql);
            ps.setInt(1, equipe.getId());
            ps.setString(2, equipe.getNome());

            if (equipe.isClassificado()) {
                ps.setInt(3, 1);
            } else {
                ps.setInt(3, 0);
            }

            ps.setInt(4, equipe.getTurma().getId());

            ps.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar(Equipe equipe) {
        try {
            con = new Conexao().getConnection();
            sql = "UPDATE `equipe` SET `nome`=?,`classificado`=?,`turma_id`=? WHERE `equipe_id`=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, equipe.getNome());

            if (equipe.isClassificado()) {
                ps.setInt(2, 1);
            } else {
                ps.setInt(2, 0);
            }
            ps.setInt(3, equipe.getTurma().getId());
            ps.setInt(4, equipe.getId());

            ps.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Equipe getByNome(String nome) {
        Equipe equipe = null;

        try {
            boolean classificado = false;

            sql = "select * from equipe where nome = ?";
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt("classificado") == 1) {
                    classificado = true;
                }
                equipe = new Equipe(rs.getString("nome"), rs.getInt("equipe_id"), classificado, new TurmaDAO().getById(rs.getInt("turma_id")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipe;
    }

    public List<String> getNomes() {
        List<String> lista = new ArrayList<>();
        try {
            boolean classificado = false;
            con = new Conexao().getConnection();
            sql = "select distinct nome from equipe";
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
}
