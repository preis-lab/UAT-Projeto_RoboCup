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
}
