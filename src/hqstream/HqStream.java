package hqstream;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Pablo
 */
public class HqStream extends Application {
    
    public static Stage loginStage;
    public static Stage cadastStage;
    public static Stage homeStage;
    public static Stage adminStage;
    
     @Override
    public void start(Stage stage) throws Exception {
        
        //adminStart(stage);
        
        HqStream.loginStage = stage;
        //chama o FXML
        Parent root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
        
        Scene scene = new Scene(root);
        
        loginStage.setScene(scene);
        loginStage.setResizable(false);
        loginStage.setTitle("Hq'Stream");
        loginStage.show();
  
    }
    
    public void cadastroStart(Stage cadastroStage) throws Exception {
        
        HqStream.cadastStage = cadastroStage;
        Parent root = FXMLLoader.load(getClass().getResource("/hqstream/Cadastro/TelaCadastro.fxml"));
        
        Scene scene = new Scene(root);
        
        cadastStage.setScene(scene);
        cadastStage.setTitle("Hq'Stream - Cadastro");
        cadastStage.setResizable(false);
        cadastStage.show();
                 
    }
    
    
    public void homeStart(Stage principalStage) throws Exception {
        
        HqStream.homeStage = principalStage;
        Parent root = FXMLLoader.load(getClass().getResource("/hqstream/homePage/TelaHome.fxml"));
        
        Scene scene = new Scene(root);
        
        homeStage.setScene(scene);
        homeStage.setTitle("Hq'Stream - Home");
        homeStage.setResizable(false);
        homeStage.show();
                 
    }
    
    public void adminStart(Stage administradorStage) throws Exception {
        
        HqStream.adminStage = administradorStage;
        Parent root = FXMLLoader.load(getClass().getResource("/hqstream/adminPage/TelaAdmin.fxml"));
        
        Scene scene = new Scene(root);
        
        adminStage.setScene(scene);
        adminStage.setTitle("Hq'Stream - Admin");
        adminStage.setResizable(false);
        adminStage.show();
                 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

   
    
}
