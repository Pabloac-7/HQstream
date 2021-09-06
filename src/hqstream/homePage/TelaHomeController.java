package hqstream.homePage;

import com.jfoenix.controls.JFXButton;
import hqstream.HqStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaHomeController {

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML private Pane paneDados, paneBiblioteca, paneLoja, panePlanos;
    @FXML private JFXButton btnDados , btnBiblioteca, btnLoja, btnPlanos;
    
    @FXML
    public void acaoDados(ActionEvent event) throws Exception{
        paneDados.toFront();
    }
    @FXML
    public void acaoBiblioteca(ActionEvent event) throws Exception{
        paneBiblioteca.toFront();
    }
    @FXML
    public void acaoLoja(ActionEvent event) throws Exception{
        paneLoja.toFront();
    }
    @FXML
    public void acaoPlanos(ActionEvent event) throws Exception{
        panePlanos.toFront();
    }
    
     @FXML
    public void acaoSair(ActionEvent event) throws Exception{
        try {
          new HqStream().start(new Stage());
        } catch (Exception e) {
        }
        HqStream.homeStage.close();
    }

}