package controller;

import java.io.IOException;

import controller.admin.AdminPageController;
import controller.customer.CustomerPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Account;
import pojo.Customer;
import service.account.AccountService;
import service.account.IAccountService;
import util.AlertController;

public class LoginController {

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtPassword;

	private IAccountService accountService = new AccountService();

	@FXML
	public void btLoginOnAction() throws IOException {
		String email = txtEmail.getText();
		String password = txtPassword.getText();
		Account account = accountService.findByEmail(email);
		if (account == null) {
			AlertController.errorAlert("Email hoặc password không hợp lệ!");
		} else {
			if (!account.getPasword().equals(password)) {
				AlertController.errorAlert("Email hoặc password không hợp lệ!");
			}
			else if (account.getCustomer() != null ) {
				Customer customer = account.getCustomer();
				loadCustomerScreen(customer);
			}
			else{
				loadAdminScreen();
			}

		}
	}

	@FXML
	public void btCancelOnAction() {

	}

	public void loadCustomerScreen(Customer customer) throws IOException {
		Stage win = (Stage) txtEmail.getScene().getWindow();
		win.close();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer/customer_page.fxml"));
		Parent root = loader.load();
		CustomerPageController customerController = loader.getController();
		customerController.setCustomer(customer);
		

		Scene scene = new Scene(root, 800, 650);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Car Rental System");
		
		primaryStage.setWidth(650);
		primaryStage.setHeight(500);
		

		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void loadAdminScreen() throws IOException {
		Stage win = (Stage) txtEmail.getScene().getWindow();
		win.close();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/admin/admin_page.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root, 800, 650);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Car Rental System");

		primaryStage.setWidth(650);
		primaryStage.setHeight(500);

		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
