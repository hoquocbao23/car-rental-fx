package controller.admin;

import java.io.IOException;

import controller.customer.CustomerPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminPageController {
	
	
	@FXML
	private Label label;
	
	@FXML
	public void btReportOnAction() throws IOException {
		loadScreen("manage_report");
	}
	
	@FXML
	public void btManageCustomerOnAction() throws IOException {
		loadScreen("manage_customer");
	}
	
	@FXML
	public void btManageCarOnAction() throws IOException {
		loadScreen("manage_car");
		
	}
	
	@FXML
	public void btManageRentalOnAction() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/admin/manage_history.fxml"));
		Parent root = loader.load();
		

		Scene scene = new Scene(root, 800, 800);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Car Rental System");
		
		primaryStage.setWidth(1049);
		primaryStage.setHeight(712);
		

		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		
		primaryStage.show();
		
		
	}
	
	@FXML
	public void btLogoutOnAction() throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("Do you want to logout ?");
		if (alert.showAndWait().get() == ButtonType.OK) {
			Stage win = (Stage) label.getScene().getWindow();
			win.close();
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/login.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
			primaryStage.setTitle("Login");
			primaryStage.setWidth(600);
			primaryStage.setHeight(450);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
	}
	
	public void loadScreen(String screen) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/admin/" + screen + ".fxml"));
		Parent root = loader.load();
		

		Scene scene = new Scene(root, 800, 600);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Car Rental System");
		
		primaryStage.setWidth(950);
		primaryStage.setHeight(700);
		

		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		
		primaryStage.show();
	}

}
