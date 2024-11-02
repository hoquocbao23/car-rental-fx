package controller.customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.CarRental;
import pojo.Customer;
import service.carRental.CarRentalService;
import service.carRental.ICarRentalService;

public class BookingHistoryController  {

	private Customer customer;

	public void setCustomer(Customer customer) {
		this.customer = customer;
		tableModel = FXCollections.observableArrayList(carRentalService.findByCustomerId(this.customer.getCustomerID()));
		cCarId.setCellValueFactory(new PropertyValueFactory<>("carID"));
		cCarName.setCellValueFactory(new PropertyValueFactory<>("carName"));
		cPickup.setCellValueFactory(new PropertyValueFactory<>("pickupDate"));
		cReturn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
		cRent.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
		cStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		historyTable.setItems(tableModel);
	}

	public Customer getCustomer() {
		return customer;
	}

	

	private ICarRentalService carRentalService;

	public BookingHistoryController() {
		carRentalService = new CarRentalService();

	}

	@FXML
	private TableView<CarRental> historyTable;

	@FXML
	private TableColumn<CarRental, Integer> cCarId;

	@FXML
	private TableColumn<CarRental, String> cCarName;

	@FXML
	private TableColumn<CarRental, LocalDate> cPickup;

	@FXML
	private TableColumn<CarRental, LocalDate> cReturn;

	@FXML
	private TableColumn<CarRental, Double> cRent;

	@FXML
	private TableColumn<CarRental, String> cStatus;

	@FXML
	private ObservableList<CarRental> tableModel;

	

	
	
	

}
