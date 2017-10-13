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
import spacecup.Model.Competicao;
import spacecup.Model.Endereco;
import spacecup.Model.TipoCompeticao;

/**
 *
 * @author pauloh
 */
public class CompeticaoDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public List<Competicao> getCompeticoes() {
        List<Competicao> lista= new ArrayList<>();
        try {
            sql = "select * from competicao";
            con = new Conexao().getConnection();
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                        
            while(rs.next()){
                boolean ativa;
                if(rs.getInt("ativa")==1){
                    ativa = true;                    
                } else {
                    ativa = false;
                }
                
                System.out.println(rs.getInt(1));
                System.out.println(rs.getDate(2));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getInt(4));
                System.out.println(rs.getInt(5));
                System.out.println(rs.getString(6));
                
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
            
            while(rs.next()){
                listaDatas.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompeticaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaDatas;
    }
    
    
    
}
