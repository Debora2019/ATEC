/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connection.ConnectionFactory;
import bean.usuarios;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Debora
 */
public class usuariosdao {
    
   public void create(usuarios u){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;

   try{
       stmt = con.prepareStatement("INSERT INTO usuarios (usu_nome, usu_sobrenome, usu_morada, usu_fone, usu_email, usu_profissao)VALUES(?,?,?,?,?,?)");
       stmt.setString(1, u.getUsu_nome());
       stmt.setString(2, u.getUsu_sobrenome());
       stmt.setString(3, u.getUsu_morada());
       stmt.setString(4, u.getUsu_fone());
       stmt.setString(5, u.getUsu_email());
       stmt.setString(6, u.getUsu_profissao());
    
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Salvo com sucesso");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
           
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   } 
    
 
   public List<usuarios> read(){
       
      Connection con = ConnectionFactory.getConnection();
      
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      List<usuarios> x = new ArrayList<>();
      
       try {
           stmt = con.prepareStatement("SELECT * FROM usuarios");
           rs = stmt.executeQuery();
           
           while(rs.next()){
            usuarios a = new usuarios();
            a.setUsu_id(rs.getInt("usu_id"));
            a.setUsu_nome(rs.getString("usu_nome"));
            a.setUsu_sobrenome(rs.getString("usu_sobrenome"));
            a.setUsu_morada(rs.getString("usu_morada"));
            a.setUsu_fone(rs.getString("usu_fone"));
            a.setUsu_email(rs.getString("usu_email"));
            a.setUsu_profissao(rs.getString("usu_profissao"));
            x.add(a);
           
           } 
         //JOptionPane.showMessageDialog(null, "Consulta feita com sucesso");
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao executar a consulta" + ex);
       }finally{
        ConnectionFactory dao = new ConnectionFactory();
        dao.closeConnection(con, stmt, rs);
           
       }           
       return x;
       
   }// fim do read
   
   
   public void update(usuarios u){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;
   
   try{
       stmt = con.prepareStatement("UPDATE usuarios SET usu_nome=?, usu_sobrenome=?, usu_morada=?, usu_fone=?, usu_email=?, usu_profissao=? WHERE usu_id=?");
       stmt.setString(1,u.getUsu_nome());
       stmt.setString(2, u.getUsu_sobrenome());
       stmt.setString(3, u.getUsu_morada());
       stmt.setString(4, u.getUsu_fone());
       stmt.setString(5, u.getUsu_email());
       stmt.setString(6, u.getUsu_profissao());
       stmt.setInt(7,u.getUsu_id());
       
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Alterado com sucesso");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao alterar" + ex);
        
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   } 
   
   public void delete(usuarios u){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;
   
   try{
       stmt = con.prepareStatement("DELETE  FROM usuarios  WHERE usu_id=?");

       stmt.setInt(1, u.getUsu_id());
       
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao excluir" + ex);
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   }  
}// fim da classe
