package controller.admin;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.CarRental;
import service.car.ICarService;
import service.carRental.CarRentalService;
import service.carRental.ICarRentalService;

public class ManageReportController {
	private ICarRentalService carRentalService;
	
	
	@FXML
	private DatePicker dpStartDate;
	
	@FXML
	private DatePicker dpEndDate;
	
	@FXML
	private ObservableList<CarRental> tableModel;
	
	@FXML
	private TableView<CarRental> carRentalTable;
	
	@FXML
	private TableColumn<CarRental, Integer> cRentalId;
	
	@FXML 
	private TableColumn<CarRental, Integer> cCusId;
	
	@FXML 
	private TableColumn<CarRental, Integer> cCarId;
	
	@FXML 
	private TableColumn<CarRental, LocalDate> cPickup;
	
	@FXML 
	private TableColumn<CarRental, LocalDate> cReturn;
	
	@FXML 
	private TableColumn<CarRental, Float> cRent;
	
	@FXML 
	private TableColumn<CarRental, String>cStatus;
	
	
	public ManageReportController() {
		carRentalService = new CarRentalService();
	}
	
	@FXML
	public void btSearchOnAction() {
		LocalDate start = dpStartDate.getValue();
		System.out.println(start);
		LocalDate end = dpEndDate.getValue();
		System.out.println(end);
		tableModel = FXCollections.observableArrayList(carRentalService.findByDateRange(start, end));
		System.out.println(tableModel.size());
		cRentalId.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
		cCusId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		cCarId.setCellValueFactory(new PropertyValueFactory<>("carID"));
		cPickup.setCellValueFactory(new PropertyValueFactory<>("pickupDate"));
		cReturn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
		cRent.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
		cStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		
		carRentalTable.setItems(tableModel);
		
		
		
		
	}

}
