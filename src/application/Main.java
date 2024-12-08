package application;
	

import controller.AjouterDoc;
import controller.DocumentController;
import controller.LivreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vueIdentification.fxml"));		
		
	    LivreController livreController = new LivreController();
	    DocumentController documentController = new DocumentController();
	    AjouterDoc ajouterDoc = new AjouterDoc();

	    ajouterDoc.setLivreController(livreController);
	    ajouterDoc.setDocumentController(documentController);
	    
	    
	    Parent root = loader.load();
	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Identification");
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
