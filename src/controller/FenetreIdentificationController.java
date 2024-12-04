package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class FenetreIdentificationController {
    
    @FXML
    private RadioButton rdIdentificationNom;
    
    @FXML
    private RadioButton rdIdentificationTelephone;
    
    @FXML
    private Button btnConnexion;
    
    @FXML
    private Button btnConsulter;
    
    @FXML
    private TextField tfNom;
    
    @FXML
    private TextField tfPrenom;
    
    @FXML
    private TextField tfTelephone;
    
    @FXML
    private Button btnCatalogue;
    
    @FXML
    private TextField tfNumEmploye;
    
    @FXML
    private TextField tfMDP;
    
    @FXML
    private TitledPane tpAdherent;
    
    public FenetreIdentificationController() {
        
    }
    
    @FXML
    public void initialize() {
        
    }
    
    public void OuvrirCatalogue() {
        try {
            Stage currentStage = (Stage) btnCatalogue.getScene().getWindow();
            currentStage.close();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Médiathèque");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
