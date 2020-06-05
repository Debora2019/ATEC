/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connection.ConnectionFactory;
import bean.sobre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DeboraJava
 */
public class sobredao {

   public List<sobre> read(){
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      sobre bean = new sobre();  
      sobredao dao = new sobredao();
     
      List<sobre> x = new ArrayList<>();
      
       try {
           stmt = con.prepareStatement("SELECT sobre_texto FROM sobre WHERE id_sobre = ? and sobre_texto = ?");
           stmt.setInt(1, bean.getId_sobre());  
           stmt.setString(2, bean.getSobre_texto());
           rs = stmt.executeQuery();
                             
           while(rs.next()){ 
               
            bean.setId_sobre(rs.getInt("id_sobre"));
            bean.setSobre_texto(rs.getString("sobre_texto"));
            x.add(bean); 
           } 
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao executar a consulta de sobre" + ex);
       }finally{
        ConnectionFactory conf = new ConnectionFactory();
        conf.closeConnection(con, stmt, rs);
       }           
       return x;
       
   }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
