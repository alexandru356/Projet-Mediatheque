module Mediatheque {
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
//	opens controller to javafx.fxml;
}