package controller.customer;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import pojo.Customer;
import service.account.AccountService;
import service.account.IAccountService;
import service.customer.CustomerService;
import service.customer.ICustomerService;
import util.AlertController;

public class CustomerProfileController {
	private ICustomerService customerService;
	
	private Customer customer;

	public void setCustomer(Customer customer) {
		this.customer = customer;
		txtFullname.setText(customer.getCustomerName());
		txtEmail.setText(customer.getEmail());
		txtPassword.setText(customer.getPassword());
		txtNumberphone.setText(customer.getMobile());
		txtCard.setText(customer.getIdentityCard());
		txtLicence.setText(customer.getLicenceNumber());
		dpBirth.setValue(customer.getBirthday());
		dpLicenDate.setValue(customer.getLicenceDate());
		
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public CustomerProfileController() {
		this.customerService = new CustomerService();
	}
	
	@FXML
	private TextField txtFullname;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private TextField txtNumberphone;
	
	@FXML
	private TextField txtCard;
	
	@FXML
	private TextField txtLicence;
	
	@FXML
	private DatePicker dpBirth;
	
	@FXML
	private DatePicker dpLicenDate;
	
	
	
	
	
	@FXML
	public void btEditOnAction(){
		String fullname = txtFullname.getText();
		String txtNumberphone = txtFullname.getText();
		String txtCard = txtFullname.getText();
		String txtLicence = txtFullname.getText();
		LocalDate birth = dpBirth.getValue();
		LocalDate licenDate = dpBirth.getValue();
		
		customer.setCustomerName(fullname);
		customer.setMobile(txtNumberphone);
		customer.setIdentityCard(txtCard);
		customer.setLicenceNumber(txtLicence);
		customer.setBirthday(birth);
		customer.setLicenceDate(licenDate);
		
		customerService.update(customer);
		AlertController.informationAlert("Update thanh cong!");
		
		
	}

	
	@FXML
	public void btCancelOnAction(){
		txtFullname.setText(customer.getCustomerName());
		txtEmail.setText(customer.getEmail());
		txtPassword.setText(customer.getPassword());
		txtNumberphone.setText(customer.getMobile());
		txtCard.setText(customer.getIdentityCard());
		txtLicence.setText(customer.getLicenceNumber());
		dpBirth.setValue(customer.getBirthday());
		dpLicenDate.setValue(customer.getLicenceDate());
		
	}


}
