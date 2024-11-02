package controller.admin;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Account;
import pojo.Car;
import pojo.Customer;
import pojo.Role;
import service.account.AccountService;
import service.account.IAccountService;
import service.customer.CustomerService;
import service.customer.ICustomerService;
import util.AlertController;

public class ManageCustomerController implements Initializable {
	
	private IAccountService accountService;
	private ICustomerService customerService;
	
	public ManageCustomerController() {
		this.accountService = new AccountService();
		this.customerService = new CustomerService();
		tableModel = FXCollections.observableArrayList(customerService.findAll());
		System.out.println(tableModel.get(0).toString());
	}
	
	
	
	
	@FXML
	private TextField txtCustomerId; 
	
	@FXML
	private TextField txtFullname;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private TextField txtNumberphone;
	
	@FXML
	private DatePicker dpBirth;
	
	@FXML
	private TextField txtCard;
	
	
	
	@FXML
	private TextField txtLicence;
	
	@FXML
	private DatePicker dpLicenDate ;
	
	@FXML
	private TableView<Customer> customerTable;
	
	@FXML
	private TableColumn<Customer, Integer> cId;

	@FXML
	private TableColumn<Customer, String> cName;

	@FXML
	private TableColumn<Customer, String> cPassword;
	
	@FXML
	private TableColumn<Customer, String> cEmail;
	
	@FXML
	private TableColumn<Customer, String> cCard;
	
	@FXML
	private TableColumn<Customer, String> cLicenseNumber;
	
	@FXML
	private TableColumn<Customer, LocalDate> cLicenseDate;
	
	@FXML
	private TableColumn<Customer, LocalDate> cBirthday;
	
	@FXML
	private TableColumn<Customer, String> cMobile;
	
	@FXML
	private ObservableList<Customer> tableModel;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		cName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
		cPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
		cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		cCard.setCellValueFactory(new PropertyValueFactory<>("identityCard"));
		cLicenseNumber.setCellValueFactory(new PropertyValueFactory<>("licenceNumber"));
		cLicenseDate.setCellValueFactory(new PropertyValueFactory<>("licenceDate"));
		cBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		cMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		
		
		customerTable.setItems(tableModel);
		
		customerTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observableValue, Object oldValue, Object index) {
				if (customerTable.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel selectionModel = customerTable.getSelectionModel();
					ObservableList selectedCell = selectionModel.getSelectedCells();
					TablePosition tablePosition = (TablePosition) selectedCell.get(0);
					Object customerId = tablePosition.getTableColumn().getCellData(index);
					try {
						Customer customer = customerService.findById(Integer.valueOf(customerId.toString()));
						showCustomer(customer);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Error");
					}
				}

			}

		});
		
	}
	
	@FXML
	public void btAddOnAction() {
		Account newAccount = new Account();
		String email = txtEmail.getText();
		String password = txtPassword.getText();
		String fullname = txtFullname.getText();
		String numberphone = txtNumberphone.getText();
		LocalDate birthDate = dpBirth.getValue();
		String card = txtCard.getText();
		String licence = txtLicence.getText();
		LocalDate licenceDate = dpLicenDate.getValue();
		
		Account findAccount = accountService.findByEmail(email);
		if (findAccount != null) {
			AlertController.errorAlert("Email da ton tai!");
		}else {
			newAccount.setEmail(email);
			newAccount.setPasword(password);
			newAccount.setRole(Role.CUSTOMER);
			accountService.save(newAccount);
		}
		Customer newCustomer = new Customer();
		newCustomer.setAccount(newAccount);
		newCustomer.setCustomerName(fullname);
		newCustomer.setMobile(numberphone);
		newCustomer.setBirthday(birthDate);
		newCustomer.setIdentityCard(card);
		newCustomer.setLicenceNumber(licence);
		newCustomer.setLicenceDate(licenceDate);
		customerService.save(newCustomer);
		AlertController.informationAlert("Them nguoi dung thanh cong!");
		
		reloadScreen();
		
		
		
	}
	
	@FXML
	public void btEditOnAction() {
		int id = Integer.parseInt(txtCustomerId.getText());
		String fullname = txtFullname.getText();
		String txtNumberphone = txtFullname.getText();
		String txtCard = txtFullname.getText();
		String txtLicence = txtFullname.getText();
		LocalDate birth = dpBirth.getValue();
		LocalDate licenDate = dpBirth.getValue();
		
		Customer findCustomer = customerService.findById(id);
		findCustomer.setCustomerName(fullname);
		findCustomer.setMobile(txtNumberphone);
		findCustomer.setIdentityCard(txtCard);
		findCustomer.setLicenceNumber(txtLicence);
		findCustomer.setBirthday(birth);
		findCustomer.setLicenceDate(licenDate);
		
		customerService.update(findCustomer);
		AlertController.informationAlert("Update thanh cong!");
		
	}
	
	@FXML
	public void btCancelOnAction() {
		txtCustomerId.clear();
		txtFullname.clear();
		txtEmail.clear();
		txtPassword.clear();
		txtNumberphone.clear();
		txtCard.clear();
		txtLicence.clear();
		dpBirth.setValue(null);
		dpLicenDate.setValue(null);
		
	}

	@FXML
	public void btDeleteOnAction() {
		int id = Integer.parseInt(txtCustomerId.getText());
		Customer findCustomer = customerService.findById(id);
		customerService.delete(findCustomer);
		AlertController.informationAlert("Da xoa thanh cong!");
	}
	
	
	
	public void reloadScreen() {
		tableModel = FXCollections.observableArrayList(customerService.findAll());
		customerTable.setItems(tableModel);
	}
	
	public void showCustomer(Customer customer) {
		txtCustomerId.setText(String.valueOf(customer.getCustomerID()));
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
