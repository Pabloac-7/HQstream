package hqstream.Cadastro;


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hqstream.HqStream;
import hqstream.dao.clienteDao;
import hqstream.model.cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaCadastroController {
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML private JFXPasswordField fieldSenha;

    @FXML private JFXTextField fieldEmail, fieldCpf, txtNome;

    @FXML private Label lblEmail, lblCPF, lblNome, lblSenha, lblAviso;
    
    @FXML private Button btnCadastro;

    public void acaoCadastrar()  {
        
        cliente c = new cliente(txtNome.getText(),Integer.parseInt(fieldCpf.getText()),fieldEmail.getText(),fieldSenha.getText());
        clienteDao dao = new clienteDao();
        
        dao.create(c);
        
        try {
          new HqStream().start(new Stage());
        } catch (Exception e) {
        }
        HqStream.cadastStage.close();
    }

}
