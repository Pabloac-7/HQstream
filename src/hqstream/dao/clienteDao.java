package hqstream.dao;

import hqstream.connection.bdConnection;
import hqstream.model.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Pablo
 */
public class clienteDao {
    
    public void create(cliente c){
        
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
         try{
            stmt =  conexao.prepareStatement("INSERT INTO hqstream.cliente (nome,cpf,email,senha) VALUES(?,?,?,?)");
            
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getSenha());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no cadastro: " + ex);
        }finally{
            bdConnection.closeConnection(conexao, stmt);
        }
        
    }
    
    public boolean access(cliente c){
        
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        try{
           stmt =  conexao.prepareStatement("Select * from hqstream.cliente where email = ? and senha = ?");
           
           stmt.setString(1, c.getEmail());
           stmt.setString(2, c.getSenha());
           
           result = stmt.executeQuery();
           
           return  result.next();
            
        }
        catch (SQLException ex) {
              throw new RuntimeException ("Erro no Login: "+ ex);
        }finally{
             bdConnection.closeConnection(conexao, stmt);
        }
        
    }
    
    
    public boolean search(cliente c){
        
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        try{
           stmt =  conexao.prepareStatement("Select * from hqstream.cliente where email = ? and cpf = ?");
           
           stmt.setString(1, c.getEmail());
           stmt.setInt(2, c.getCpf());
           
           result = stmt.executeQuery();
           
           return result.next();
            
        }
        catch (SQLException ex) {
              throw new RuntimeException ("Erro: "+ ex);
        }finally{
             bdConnection.closeConnection(conexao, stmt);
        }
        
    }
    
    
    public List<cliente> read(){
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        List<cliente> clientes = new ArrayList<>();
        
         try{
           stmt = conexao.prepareStatement("SELECT * FROM hqstream.cliente");
           result = stmt.executeQuery();
           
           while(result.next()){
               cliente c = new cliente(result.getInt("id"),result.getString("nome"), result.getInt("cpf"),result.getString("email"));
               clientes.add(c);
           }
           
           return clientes;
        }
        catch (SQLException ex) {
              throw new RuntimeException ("Erro: "+ ex);
        }finally{
             bdConnection.closeConnection(conexao, stmt, result);
        }
    }
       
    public void edit(int id, cliente novo){
        
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
         try{
            stmt =  conexao.prepareStatement("UPDATE hqstream.cliente SET nome=?, cpf=?, email=?, senha=? WHERE id= ? ");
            stmt.setString(1, novo.getNome());
            stmt.setInt(2, novo.getCpf());
            stmt.setString(3, novo.getEmail());
            stmt.setString(4, novo.getSenha());
            stmt.setInt(5, id);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Seus dados foram modificados com sucesso");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na modificacao: " + ex.getMessage());
        }finally{
            bdConnection.closeConnection(conexao, stmt);
        }
        
    }
        
    public void delete(cliente c){
        //not supported yet
    }
    
}
