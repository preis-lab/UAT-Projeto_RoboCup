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
import spacecup.Model.Foguete;

public class FogueteDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public List<Foguete> getFoguetes() {
        List<Foguete> lista = new ArrayList<>();
        try {
            con = new Conexao().getConnection();
            sql = "select * from foguete ";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Foguete(rs.getInt("foguete_id"), rs.getFloat("peso"), rs.getFloat("tamanho")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FogueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void altera(Foguete f) {
        try {
            con = new Conexao().getConnection();
            sql = "UPDATE `foguete` SET `peso`=?,`tamanho`=? WHERE `foguete_id`= ?";

            ps = con.prepareStatement(sql);

            ps.setFloat(1, f.getPeso());
            ps.setFloat(2, f.getTamanho());
            ps.setInt(3, f.getId());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FogueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insere(Foguete f) {
        try {
            con = new Conexao().getConnection();
            sql = "INSERT INTO `foguete` VALUES (NULL,?, ?)";

            ps = con.prepareStatement(sql);

            ps.setFloat(1, f.getPeso());
            ps.setFloat(2, f.getTamanho());

            ps.execute();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FogueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Foguete getById(int id) {
        Foguete f = null;

        try {

            con = new Conexao().getConnection();
            sql = "select * from foguete where foguete_id = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                f = new Foguete(rs.getInt("foguete_id"), rs.getFloat("peso"), rs.getFloat("tamanho"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FogueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;

    }
}
