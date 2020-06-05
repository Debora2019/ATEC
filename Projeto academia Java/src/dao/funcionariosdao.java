/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connection.ConnectionFactory;
import bean.funcionarios;
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
public class funcionariosdao {
 
    
   public void create(funcionarios f){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;
   
   
   try{
       stmt = con.prepareStatement("INSERT INTO funcionarios (func_nome, func_sobrenome, func_morada, func_fone, func_email)VALUES(?,?,?,?,?)");
       stmt.setString(1,f.getFunc_nome());
       stmt.setString(2, f.getFunc_sobrenome());
       stmt.setString(3, f.getFunc_morada());
       stmt.setString(4, f.getFunc_fone());
       stmt.setString(5, f.getFunc_email());
       
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Inserido com sucesso");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao inserir" + ex);
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   }    
    
   
   public List<funcionarios> read(){
       
      Connection con = ConnectionFactory.getConnection();
      
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      List<funcionarios> x = new ArrayList<>();
      
       try {
           stmt = con.prepareStatement("SELECT * FROM funcionarios");
           rs = stmt.executeQuery();
           
           while(rs.next()){
            funcionarios a = new funcionarios();
            a.setFunc_id(rs.getInt("func_id"));
            a.setFunc_nome(rs.getString("func_nome"));
            a.setFunc_sobrenome(rs.getString("func_sobrenome"));
            a.setFunc_morada(rs.getString("func_morada"));
            a.setFunc_fone(rs.getString("func_fone"));
            a.setFunc_email(rs.getString("func_email"));
           // a.setUsu_profissao(rs.getString("usu_profissao"));
            x.add(a);
           
           } 
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao executar a consulta de funcionarios" + ex);
       }finally{
        ConnectionFactory dao = new ConnectionFactory();
        dao.closeConnection(con, stmt, rs);
           
       }           
       return x;
       
   }
    
    public void update(funcionarios u){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;
   
   try{
       stmt = con.prepareStatement("UPDATE funcionarios SET func_nome=?, func_sobrenome=?, func_morada=?, func_fone=?, func_email=? WHERE func_id=?");
       stmt.setString(1,u.getFunc_nome());
       stmt.setString(2, u.getFunc_sobrenome());
       stmt.setString(3, u.getFunc_morada());
       stmt.setString(4, u.getFunc_fone());
       stmt.setString(5, u.getFunc_email());
       stmt.setInt(6,u.getFunc_id());
       
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Alterado com sucesso no cadastro dos funcionarios");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao alterar no cadastro dos funcionarios " + ex);
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   }   
   
   public void delete(funcionarios u){
   Connection con = ConnectionFactory.getConnection();
   PreparedStatement stmt = null;
   
   try{
       stmt = con.prepareStatement("DELETE  FROM funcionarios  WHERE func_id=?");

       stmt.setInt(1, u.getFunc_id());
       
       stmt.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Excluído com sucesso da lista de funcionarios");
       
   }   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Erro ao excluir da lista de funcionarios" + ex);
       }finally{
       ConnectionFactory.closeConnection(con, stmt);
   }
   }  
    
}//fim da classes
