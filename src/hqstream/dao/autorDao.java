package hqstream.dao;

import hqstream.connection.bdConnection;
import hqstream.model.autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Pablo
 */
public class autorDao {
    
     public void create(autor a){
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
         try{
            stmt =  conexao.prepareStatement("INSERT INTO hqstream.autor (nome,data_nascimento) VALUES(?,?)");
            
            stmt.setString(1, a.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(a.getData()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no cadastro: " + ex.getMessage());
        }finally{
            bdConnection.closeConnection(conexao, stmt);
                    
        }
        
    }

    public List<autor> read(){
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        List<autor> autores = new ArrayList<>();
         try{
           stmt = conexao.prepareStatement("SELECT * FROM hqstream.autor");
           result = stmt.executeQuery();
           
           while(result.next()){
               autor a = new autor(result.getInt("codigo"),result.getString("nome"), formatter.format(result.getDate("data_nascimento")));
               autores.add(a);
           }
           
           return autores;
        }
        catch (SQLException ex) {
              throw new RuntimeException ("Erro: "+ ex);
        }finally{
             bdConnection.closeConnection(conexao, stmt, result);
        }
    } 
 
     public void edit(int cod, autor novo){
        
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
         try{
            stmt =  conexao.prepareStatement("UPDATE hqstream.autor SET nome=?, data_nascimento=? WHERE codigo= ? ");
            stmt.setString(1, novo.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(novo.getData()));
            stmt.setInt(3, cod);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Autor nº "+ cod +" modificada com sucesso");
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
            stmt =  conexao.prepareStatement("DELETE FROM hqstream.autor WHERE codigo = ? ");
            stmt.setInt(1, cod);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Autor nº "+ cod +" deletado");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na exclusao: " + ex.getMessage());
        }finally{
            bdConnection.closeConnection(conexao, stmt);
        }
    }
    
    
}
