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
import spacecup.Model.TipoCompeticao;

public class TipoCompeticaoDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public List<TipoCompeticao> getTipoCompeticao() {
        List<TipoCompeticao> lista = new ArrayList<>();
        try {
            con = new Conexao().getConnection();
            sql = "select * from tipo_competicao ";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new TipoCompeticao(rs.getInt("tipo_competicao_id"), rs.getString("nome")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoCompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void altera(TipoCompeticao tc) {
        try {
            con = new Conexao().getConnection();
            sql = "UPDATE `tipo_competicao` SET `nome`=? WHERE `tipo_competicao_id`=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, tc.getNome());
            ps.setInt(2, tc.getId());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoCompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insere(TipoCompeticao tc) {
        try {
            con = new Conexao().getConnection();
            sql = "INSERT INTO `tipo_competicao` VALUES (?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, tc.getId());
            ps.setString(2, tc.getNome());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoCompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TipoCompeticao getById(int id) {
        TipoCompeticao tp = null;

        try {

            con = new Conexao().getConnection();
            sql = "select * from tipo_competicao where tipo_competicao_id = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                tp = new TipoCompeticao(id, rs.getString("nome"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoCompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;

    }

    public TipoCompeticao getBynome(String nome) {
        TipoCompeticao tp = null;

        try {

            con = new Conexao().getConnection();
            sql = "select * from tipo_competicao where nome = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();

            if (rs.next()) {
                tp = new TipoCompeticao(rs.getInt("tipo_competicao_id"), rs.getString("nome"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoCompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;

    }

    public List<String> getNomes() {
        List<String> lista = new ArrayList<>();
        try {
            con = new Conexao().getConnection();
            sql = "select distinct nome from tipo_competicao";
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
