package hqstream.dao;

import hqstream.connection.bdConnection;
import hqstream.model.historiaQuadrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Pablo
 */
public class historiaQuadrinhoDao {
    
    
     public void create(historiaQuadrinho hq){
        
         Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
         try{
            stmt =  conexao.prepareStatement("INSERT INTO hqstream.historia_quadrinho (nome,data_publicacao,empresa,n_paginas) VALUES(?,?,?,?)");
            
            stmt.setString(1, hq.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(hq.getData()));
            stmt.setString(3, hq.getEmpresa());
            stmt.setInt(4, hq.getPag());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no cadastro: " + ex.getMessage());
        }finally{
            bdConnection.closeConnection(conexao, stmt);
                    
        }
        
    }
     
     public List<historiaQuadrinho> read(){
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        List<historiaQuadrinho> hqList = new ArrayList<>();
         try{
           stmt = conexao.prepareStatement("SELECT * FROM hqstream.historia_quadrinho");
           result = stmt.executeQuery();
           
           while(result.next()){
              historiaQuadrinho hq = new historiaQuadrinho(result.getInt("codigo"),result.getString("nome"), formatter.format(result.getDate("data_publicacao")),
                      result.getString("empresa"), result.getInt("n_paginas"));
              hqList.add(hq);
           }
           
           return hqList;
        }
        catch (SQLException ex) {
              throw new RuntimeException ("Erro: "+ ex);
        }finally{
             bdConnection.closeConnection(conexao, stmt, result);
        }
    } 
     
     
    public void edit(int cod, historiaQuadrinho novo){
        
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
         try{
            stmt =  conexao.prepareStatement("UPDATE hqstream.historia_quadrinho SET nome=?, data_publicacao=?, empresa=?, n_paginas=? WHERE codigo= ? ");
            stmt.setString(1, novo.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(novo.getData()));
            stmt.setString(3, novo.getEmpresa());
            stmt.setInt(4, novo.getPag());
            stmt.setInt(5, cod);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Hq nº "+ cod +" modificada com sucesso");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na modificacao: " + ex.getMessage());
        }finally{
            bdConnection.closeConnection(conexao, stmt);
        }
        
    }
    
    public void delete(int cod){
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
         try{
            stmt =  conexao.prepareStatement("DELETE FROM hqstream.historia_quadrinho  WHERE codigo= ? ");
            stmt.setInt(1, cod);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Hq nº "+ cod +"deletada");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro  na exclusao: " + ex.getMessage());
        }finally{
            bdConnection.closeConnection(conexao, stmt);
        }
    }
    
}
