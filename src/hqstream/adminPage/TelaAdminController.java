package hqstream.adminPage;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import hqstream.HqStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import hqstream.model.*;
import hqstream.dao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class TelaAdminController implements Initializable {
    
    
    @FXML
    private Label lblListHQ, lblListAutor, lblCadastrado, lvlQtdHq, lblPlanoCliente, lblNome;
    
    @FXML
    private Label lblNomeAutor, lblDataAutor, lblNomeHQ, lblPagHQ, lblDatahq, lblEmpresa;
    
    @FXML
    private Label lblArquivo, lblTipoPlano, lblValorPlano, lblDescricaoPlano ,  lblPlanos, lblListClientes;

    @FXML
    private JFXTextField txtEmail, txtCpf, txtNomeAutor, txtNomeHq, txtQtdPag,  txtEmpesa;
    
    @FXML private JFXTextField txtTipoPlano, txtValorPlano;

    @FXML
    private Button btnBuscar, btnCadastroAutor, btnCadastraHq, btnDefinirPlano;

    @FXML private JFXTextArea txtDescricaoPlano;
    
    @FXML private DatePicker dtDataHq ,dtDataAutor;
    
    @FXML private TableView<cliente> tableCliente;
     
    @FXML private TableColumn <cliente, String> colunaNomeC , colunaEmail;
     
    @FXML private TableColumn <cliente, Integer>  colunaID, colunaCpf;
    
    @FXML private TableView<autor> tableAutor;
    
    @FXML private TableColumn<autor, Integer> colunaCodAutor;

    @FXML private TableColumn<autor, String> colunaNomeA, colunaDataAutor;
    
    @FXML private TableView<historiaQuadrinho> tableHq;
    
    @FXML private TableColumn<historiaQuadrinho, Integer> colunaCodHq, colunaPag;

    @FXML private TableColumn<historiaQuadrinho, String> colunaNomeHq, colunaEmpresa, colunaDataHq;

    @FXML private TableView<plano> tablePlano;
        
    @FXML private TableColumn<plano, String> colunaTipo, colunaDescricao;

    @FXML private TableColumn<plano, Float> colunaMensalidade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabelaCliente();
        tabelaHq();
        tabelaAutor();
        tabelaPlano();
    }    
       
    public void tabelaCliente(){
       colunaID.setCellValueFactory(new PropertyValueFactory("id"));
       colunaNomeC.setCellValueFactory(new PropertyValueFactory("nome"));
       colunaEmail.setCellValueFactory(new PropertyValueFactory("email"));
       colunaCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
       tableCliente.setItems(atualizaTabelaC());
    }
    
    public void tabelaAutor(){
       colunaCodAutor.setCellValueFactory(new PropertyValueFactory("codigo"));
       colunaNomeA.setCellValueFactory(new PropertyValueFactory("nome"));
       colunaDataAutor.setCellValueFactory(new PropertyValueFactory("dataLista"));
       tableAutor.setItems(atualizaTabelaA());
    } 
    
    public void tabelaHq(){
        colunaCodHq.setCellValueFactory(new PropertyValueFactory("codigo"));
        colunaNomeHq.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaPag.setCellValueFactory(new PropertyValueFactory("pag"));
        colunaEmpresa.setCellValueFactory(new PropertyValueFactory("empresa"));
        colunaDataHq.setCellValueFactory(new PropertyValueFactory("dataLista"));
        tableHq.setItems(atualizaTabelaHq());
    } 
    
    public void tabelaPlano(){
        colunaTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        colunaMensalidade.setCellValueFactory(new PropertyValueFactory("mensalidade"));
        tablePlano.setItems(atualizaTabelaP());
    } 
    
    public ObservableList<cliente> atualizaTabelaC(){
        clienteDao clientes = new clienteDao();
        return FXCollections.observableArrayList(clientes.read());
    }
    
     public ObservableList<autor> atualizaTabelaA(){
        autorDao autor = new autorDao();
        return FXCollections.observableArrayList(autor.read());
    }
     
     public ObservableList<historiaQuadrinho> atualizaTabelaHq(){
        historiaQuadrinhoDao hq = new  historiaQuadrinhoDao();
        return FXCollections.observableArrayList(hq.read());
    }
     
     public ObservableList<plano> atualizaTabelaP(){
        planoDao plano = new planoDao();
        return FXCollections.observableArrayList(plano.read());
    }
     
    @FXML
    public void cadastrarHq(ActionEvent event) throws Exception {
        historiaQuadrinho hq = new historiaQuadrinho (txtNomeHq.getText(),dtDataHq.getValue(),txtEmpesa.getText(),Integer.parseInt(txtQtdPag.getText()));
        historiaQuadrinhoDao hqDao =  new historiaQuadrinhoDao();
        hqDao.create(hq);
       
        tabelaHq();
    }
    
    @FXML
    public void atualizaHq(ActionEvent event) throws Exception{
        tabelaHq();
    }
    
    @FXML
    public void deletaHq(ActionEvent event) throws Exception{
        historiaQuadrinhoDao dao  = new  historiaQuadrinhoDao();
        dao.delete(tableAutor.getSelectionModel().getSelectedItem().getCodigo());
        tabelaHq();
    }
    
     @FXML
    public void cadastrarAutor(ActionEvent event) throws Exception {
        autor a = new autor(txtNomeAutor.getText(),dtDataAutor.getValue());
        autorDao dao = new autorDao();
        dao.create(a);
        
        tabelaAutor();
    }
    
    @FXML
    public void atualizaAutor(ActionEvent event) throws Exception{
        tabelaAutor();
    }
    
    @FXML
    public void deletaAutor(ActionEvent event) throws Exception{
        autorDao dao = new autorDao();
        dao.delete(tableAutor.getSelectionModel().getSelectedItem().getCodigo());
        tabelaAutor();
    }
    
    @FXML
    public void definirPlano(ActionEvent event) throws Exception {
        plano p = new plano(txtTipoPlano.getText(),txtDescricaoPlano.getText(),Float.parseFloat(txtValorPlano.getText()));
        planoDao plan = new planoDao();
        
        plan.create(p);
        
        tabelaPlano();
    }
    
    @FXML
    public void atualizaPlano(ActionEvent event) throws Exception{
        
        tabelaPlano();
    }
    
    @FXML
    public void deletaPlano(ActionEvent event) throws Exception{
        planoDao dao = new planoDao();
        dao.delete(new plano(tablePlano.getSelectionModel().getSelectedItem().getTipo(),tablePlano.getSelectionModel().getSelectedItem().getDescricao()));
        tabelaPlano();
    }
    
      @FXML
    public void acaoSair(ActionEvent event) throws Exception{
        try {
          new HqStream().start(new Stage());
        } catch (Exception e) {
        }
        HqStream.adminStage.close();
    }
    
}
