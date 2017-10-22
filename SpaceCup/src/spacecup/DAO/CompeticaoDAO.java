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
import spacecup.Model.Competicao;

public class CompeticaoDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public List<Competicao> getCompeticoes() {
        List<Competicao> lista = new ArrayList<>();
        try {
            sql = "select * from competicao";
            con = new Conexao().getConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                boolean ativa;
                if (rs.getInt("ativa") == 1) {
                    ativa = true;
                } else {
                    ativa = false;
                }

                Competicao c = new Competicao();
                c.setId(rs.getInt("competicao_id"));
                c.setAtiva(ativa);
                c.setData(rs.getDate("data"));
                c.setEndereco(new EnderecoDAO().getById(rs.getInt("numero"), rs.getString("cep")));
                c.setTipoCompeticao(new TipoCompeticaoDAO().getById(rs.getInt("tipo_competicao_id")));

                lista.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<String> getDatas(String tipoCompeticao) {
        List<String> listaDatas = new ArrayList<>();

        try {
            sql = "select DISTINCT year(data) from competicao WHERE tipo_competicao_id = (SELECT tipo_competicao_id FROM tipo_competicao WHERE nome = ?)";
            con = new Conexao().getConnection();

            ps = con.prepareStatement(sql);
            ps.setString(1, tipoCompeticao);
            rs = ps.executeQuery();

            while (rs.next()) {
                listaDatas.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaDatas;
    }

    public void adicionaCompeticao(Competicao competicao) {
        try {
            con = new Conexao().getConnection();

            sql = "INSERT INTO `competicao` VALUES (?, ?, ?, ?)";

            ps = con.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(competicao.getData().getDate()));
            ps.setInt(2, competicao.getEndereco().getNumero());
            ps.setInt(3, competicao.getTipoCompeticao().getId());

            if (competicao.isAtiva()) {
                ps.setInt(4, 1);
            } else {
                ps.setInt(4, 2);
            }

            ps.setString(6, competicao.getEndereco().getCep());

            ps.execute();

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alteraCompeticao(Competicao competicao) {
        try {
            con = new Conexao().getConnection();

            sql = "UPDATE `competicao` SET `data`=?,`numero`=?,`tipo_competicao_id`=?,`ativa`=?,`cep`=6 WHERE `competicao_id`=?";

            ps = con.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(competicao.getData().getDate()));
            ps.setInt(2, competicao.getEndereco().getNumero());
            ps.setInt(3, competicao.getTipoCompeticao().getId());

            if (competicao.isAtiva()) {
                ps.setInt(4, 1);
            } else {
                ps.setInt(4, 2);
            }
            ps.setInt(5, competicao.getId());

            ps.setString(6, competicao.getEndereco().getCep());

            ps.execute();

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Competicao getById(int id) {
        Competicao c = null;

        try {

            con = new Conexao().getConnection();
            sql = "select * from competicao where competicao_id = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                boolean ativa;
                if (rs.getInt("ativa") == 1) {
                    ativa = true;
                } else {
                    ativa = false;
                }

                c = new Competicao();
                c.setId(rs.getInt("competicao_id"));
                c.setAtiva(ativa);
                c.setData(rs.getDate("data"));
                c.setEndereco(new EnderecoDAO().getById(rs.getInt("numero"), rs.getString("cep")));
                c.setTipoCompeticao(new TipoCompeticaoDAO().getById(rs.getInt("tipo_competicao_id")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

}
