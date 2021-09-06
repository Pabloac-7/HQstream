package hqstream;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hqstream.dao.clienteDao;
import hqstream.model.cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class TelaLoginController {
    @FXML
    private JFXPasswordField txtSenha;

    @FXML
    private JFXTextField txtLogin;

    @FXML
    private Label lblLogin, lblSenha;

    @FXML
    private Hyperlink lnkCadastro;

    @FXML
    private Button btnLogar;
    
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    
    @FXML
    public void botaoLogar() {
        
        cliente c = new cliente(txtLogin.getText(),txtSenha.getText());
        clienteDao dao = new clienteDao();
                  
        if(dao.access(c)){
            try {   
                if (c.getEmail().equals("hqStreamAdm") && c.getSenha().equals("admin")) {
                    new HqStream().adminStart(new Stage());
                     HqStream.loginStage.close();
                } else {
                    new HqStream().homeStart(new Stage());
                    HqStream.loginStage.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
            }    
       }
       else{
           JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalidos");
       }
    }
    
    
    @FXML
    public void acaoCadastro(javafx.event.ActionEvent event) throws Exception {
        try {
            new HqStream().cadastroStart(new Stage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
        }
         HqStream.loginStage.close();
    }
    
    
    
}
