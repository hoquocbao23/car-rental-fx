package controller.admin;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Car;
import pojo.CarRental;
import service.carRental.CarRentalService;
import service.carRental.ICarRentalService;
import util.AlertController;

public class ManageHistoryController implements Initializable {
	
	private ICarRentalService carRentalService;
	
	public ManageHistoryController() {
		carRentalService = new CarRentalService();
		tableModel = FXCollections.observableArrayList(carRentalService.findAll());
	}
	
	@FXML
	private TableView<CarRental> carRentalTable;
	
	@FXML 
	private ObservableList<CarRental> tableModel;
	
	@FXML
	private TableColumn<CarRental, Integer> cRentalId;
	
	@FXML
	private TableColumn<CarRental, Integer> cCusId;
	
	@FXML
	private TableColumn<CarRental, Integer> cCarId;
	
	@FXML
	private TableColumn<CarRental, LocalDate > cPickup;
	
	@FXML
	private TableColumn<CarRental, LocalDate> cReturn;
	
	@FXML
	private TableColumn<CarRental, Double> cRent;
	
	@FXML
	private TableColumn<CarRental, String> cStatus;
	
	
	@FXML
	private TextField txtRentalId;
	@FXML
	private TextField txtCustomerId;
	@FXML
	private TextField txtCarId;
	@FXML
	private DatePicker dpPickupDate;
	@FXML
	private DatePicker dpReturnDate;
	@FXML
	private TextField txtRentPrice;
	@FXML
	private ComboBox<String> cmbStatus;
	
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cRentalId.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
		cCusId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		cCarId.setCellValueFactory(new PropertyValueFactory<>("carID"));
		cPickup.setCellValueFactory(new PropertyValueFactory<>("pickupDate"));
		cReturn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
		cRent.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
		cStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		
		carRentalTable.setItems(tableModel);
		
		carRentalTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observableValue, Object oldValue, Object index) {
				if (carRentalTable.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel selectionModel = carRentalTable.getSelectionModel();
					ObservableList selectedCell = selectionModel.getSelectedCells();
					TablePosition tablePosition = (TablePosition) selectedCell.get(0);
					Object bookingId  = tablePosition.getTableColumn().getCellData(index);
					System.out.println(bookingId.toString());
					try {
						CarRental history = carRentalService.findById(Integer.valueOf(bookingId.toString()));
						showHistory(history);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Error");
						System.out.println(bookingId.toString());
					}
				}

			}

		});
		
		cmbStatus.getItems().add("UPCOMING");
		cmbStatus.getItems().add("USING");
		cmbStatus.getItems().add("CANCELLED");
		
	}
	
	
	
	@FXML
	public void btEditOnAction() {
		int rentalId = Integer.parseInt(txtRentalId.getText());
		CarRental findRental = carRentalService.findById(rentalId);
		findRental.setStatus(cmbStatus.getValue());
		carRentalService.update(findRental);
		AlertController.informationAlert("Update thanh cong!");
		reload();
		
		
	}
	
	@FXML
	public void btCancelOnAction() {
		txtRentalId.clear();
		txtCustomerId.clear();
		txtCarId.clear();
		txtRentPrice.clear();
	}

	
	
	
	public void showHistory(CarRental history) {
		txtRentalId.setText(String.valueOf(history.getRentalId()));
		txtCustomerId.setText(String.valueOf(history.getCustomerID()));
		txtCarId.setText(String.valueOf(history.getCarID()));
		txtRentPrice.setText(String.valueOf(history.getRentPrice()));
		dpPickupDate.setValue(history.getPickupDate());
		dpReturnDate.setValue(history.getReturnDate());
		cmbStatus.setValue(history.getStatus());
	}
	
	public void reload() {
		tableModel = FXCollections.observableArrayList(carRentalService.findAll());
		carRentalTable.setItems(tableModel);
	}

	

}
