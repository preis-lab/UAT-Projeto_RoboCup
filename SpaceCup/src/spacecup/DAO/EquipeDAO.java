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
import spacecup.Model.Equipe;

/**
 *
 * @author pauloh
 */
public class EquipeDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public List<Equipe> getEquipes(){
        List<Equipe> lista = new ArrayList<Equipe>();
        try {
            boolean classificado = false;
            con = new Conexao().getConnection();
            sql = "select * from equipe";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                if(rs.getInt("classificado")==1){
                    classificado = true;
                } else {
                    classificado = false;
                }
                
                lista.add(new Equipe(rs.getString("nome"), rs.getInt("equipe_id"), classificado, rs.getInt("turma_id")));
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
                equipe = new Equipe(rs.getString("nome"), rs.getInt("equipe_id"), classificado, rs.getInt("turma_id"));               
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipe;
    }
}
