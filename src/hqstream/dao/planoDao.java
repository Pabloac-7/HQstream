package hqstream.dao;

import hqstream.connection.bdConnection;
import hqstream.model.plano;
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
public class planoDao {
   
    public void create(plano p){
        
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
         try{
            stmt =  conexao.prepareStatement("INSERT INTO hqstream.plano (tipo,descricao,mensalidade) VALUES(?,?,?)");
            
            stmt.setString(1, p.getTipo());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getMensalidade());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Plano Definido com sucesso");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no cadastro: " + ex.getMessage());
        }finally{
            bdConnection.closeConnection(conexao, stmt);
                    
        }
        
    }
    
    public List<plano> read(){
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        List<plano> planos = new ArrayList<>();
         try{
           stmt = conexao.prepareStatement("SELECT * FROM hqstream.plano");
           result = stmt.executeQuery();
           
           while(result.next()){
               plano p = new plano(result.getString("tipo"),result.getString("descricao"), result.getFloat("mensalidade"));
               planos.add(p);
           }
           
           return planos;
        }
        catch (SQLException ex) {
              throw new RuntimeException ("Erro: "+ ex);
        }finally{
             bdConnection.closeConnection(conexao, stmt, result);
        }
    } 
    
    public void edit(plano p, plano novo){
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
        try{
           stmt = conexao.prepareStatement("UPDATE hqstream.plano SET tipo=?, descricao = ?, mensalidade = ? WHERE tipo = ? AND descricao = ?");
           stmt.setString(1,novo.getTipo());
           stmt.setString(2, novo.getDescricao());
           stmt.setFloat(3, novo.getMensalidade());
           stmt.setString(4, p.getTipo());
           stmt.setString(5, p.getDescricao());
           
           stmt.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Plano modificado com sucesso");
        }
        catch (SQLException ex) {
              throw new RuntimeException ("Erro na modificacao: "+ ex);
        }finally{
             bdConnection.closeConnection(conexao, stmt);
        }
        
    }
    
    public void delete(plano p){
        
        Connection conexao = bdConnection.getConnection();
        PreparedStatement stmt = null;
        
        try{
           stmt = conexao.prepareStatement("DELETE FROM hqstream.plano WHERE tipo = ? AND descricao = ?");
           stmt.setString(1, p.getTipo());
           stmt.setString(2, p.getDescricao());
           
           stmt.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Plano excluido");
        }
        catch (SQLException ex) {
              throw new RuntimeException ("Erro na exclusao: "+ ex);
        }finally{
             bdConnection.closeConnection(conexao, stmt);
        }
        
    }
    
}
