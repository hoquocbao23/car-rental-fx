package controller.customer;

import java.io.IOException;

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
import pojo.Account;
import pojo.Customer;

public class CustomerPageController {
	private Customer customer = null;
	
	@FXML
	private Label label ;

	public void setCustomer(Customer customer) {
		this.customer = customer;
		
	}
	
	

	@FXML
	public void btProfileOnAction() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer/customer_profile.fxml"));
		Parent root = loader.load();

		CustomerProfileController profileController = loader.getController();
		System.out.println("Hello:" + customer);
		profileController.setCustomer(customer);

		Scene scene = new Scene(root, 800, 600);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Car Rental System");

		primaryStage.setWidth(950);
		primaryStage.setHeight(700);

		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();

		primaryStage.show();

	}

	@FXML
	public void btBookingOnAction() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer/booking_page.fxml"));
		Parent root = loader.load();

		BookingController bookingController = loader.getController();
		System.out.println("Hello:" + customer);
		bookingController.setCustomer(customer);

		Scene scene = new Scene(root, 800, 600);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Car Rental System");

		primaryStage.setWidth(950);
		primaryStage.setHeight(700);

		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();

		primaryStage.show();
	}

	@FXML
	public void btBookingHistoryOnAction() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer/booking_history.fxml"));

		Parent root = loader.load();

		BookingHistoryController bookingHistoryController = loader.getController();

		System.out.println("Hello:" + customer);
		bookingHistoryController.setCustomer(customer);

		Scene scene = new Scene(root, 800, 600);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Car Rental System");

		primaryStage.setWidth(800);
		primaryStage.setHeight(500);

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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer/" + screen + ".fxml"));
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
