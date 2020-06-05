/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connection.ConnectionFactory;
import bean.modalidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Débora
 */
public class modalidadesdao { //falta terminar de criar o metodo
    
    public void create(modalidades m){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;

   try{
       stmt = con.prepareStatement("INSERT INTO modalidades (mod_descricao, mod_instrutor, mod_preco, mod_horario)VALUES(?,?,?,?)");
       stmt.setString(1, m.getMod_descricao());
       stmt.setString(2, m.getMod_instrutor());
       stmt.setString(3, m.getMod_preco());
       stmt.setString(4, m.getMod_horario());
      
     
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Inserido em modalidades com sucesso");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao salvar em modalidades" + ex);
        
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   }  
    
    
 public List<modalidades> read(){
       
      Connection con = ConnectionFactory.getConnection();
      
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      List<modalidades> x = new ArrayList<>();
      
       try {
           stmt = con.prepareStatement("SELECT * FROM modalidades");
           rs = stmt.executeQuery();
           
           while(rs.next()){
            modalidades m = new modalidades();
            m.setMod_descricao(rs.getString("mod_descricao"));
            m.setMod_instrutor(rs.getString("mod_instrutor"));
            m.setMod_preco(rs.getString("mod_preco"));
            m.setMod_horario(rs.getString("mod_horario"));
            m.setMod_id(rs.getInt("mod_id"));
            x.add(m);
           } 
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao executar a consulta de modalidades " + ex);
       }finally{
        ConnectionFactory dao = new ConnectionFactory();
        dao.closeConnection(con, stmt, rs);
       }           
       return x;
       
 } 
       
     public void update(modalidades m){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;
   
   try{
       stmt = con.prepareStatement("UPDATE modalidades SET mod_descricao=?, mod_instrutor=?, mod_preco=?, mod_horario=? WHERE mod_id=?");
       stmt.setString(1,m.getMod_descricao());
       stmt.setString(2, m.getMod_instrutor());
       stmt.setString(3, m.getMod_horario());
       stmt.setString(4, m.getMod_preco());
       stmt.setInt(5, m.getMod_id());
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Alterado com sucesso no cadastro de modalidades");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao alterar no cadastro de modalidades " + ex);
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   }    
     
      public void delete(modalidades m){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;
   
   try{
       stmt = con.prepareStatement("DELETE FROM modalidades  WHERE mod_id=?");
       stmt.setInt(1, m.getMod_id());
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Excluído com sucesso da lista de modalidades");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao excluir da lista de modalidades" + ex);
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   }  
   } //fim da classe   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

