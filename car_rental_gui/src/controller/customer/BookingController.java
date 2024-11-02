package controller.customer;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import pojo.Car;
import pojo.CarRental;
import pojo.Customer;
import service.car.CarService;
import service.car.ICarService;
import service.carRental.CarRentalService;
import service.carRental.ICarRentalService;
import util.AlertController;

public class BookingController implements Initializable {

	private Customer customer = null;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}

	private ICarService carService;
	private ICarRentalService carRentalService;

	public BookingController() {
		this.carService = new CarService();
		this.carRentalService = new CarRentalService();
		listCar = FXCollections.observableArrayList(getAllCarName());

	}

	@FXML
	private ComboBox<String> cbCar;

	@FXML
	private DatePicker dpPickup = new DatePicker();

	@FXML
	private DatePicker dpReturn = new DatePicker();

	@FXML
	private Label labelTotal;

	@FXML
	private ObservableList<String> listCar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cbCar.setItems(listCar);

	}

	@FXML
	public void btBookOnAction() {
		String carName = cbCar.getValue();
		LocalDate pickupDate = dpPickup.getValue();
		LocalDate returnDate = dpReturn.getValue();
		if (carName == null || pickupDate == null || returnDate == null  ) {
			AlertController.errorAlert("Vui long nhap thong tin!");
		}else {
			long days = ChronoUnit.DAYS.between(pickupDate, returnDate);
			if (days == 0 ) {
				AlertController.errorAlert("Vui long chon ngay khac!");
			}else {
				Car findCar = carService.findByName(carName);
				float totalPrice = findCar.getRentPrice() * days;

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm Booking");
				alert.setHeaderText("Xac nhan dat xe");
				alert.setContentText("Tong don hang: " + BigDecimal.valueOf(totalPrice));

				if (alert.showAndWait().get() == ButtonType.OK) {
					CarRental rental = new CarRental();
					rental.setCustomer(customer);
					rental.setCar(findCar);
					rental.setPickupDate(pickupDate);
					rental.setReturnDate(returnDate);
					rental.setRentPrice(totalPrice);
					rental.setStatus("UPCOMING");
					carRentalService.save(rental);
				}
			}
			
		}
		

	}

	@FXML
	public void btCancelOnAction() {
		cbCar.setValue(null);
		dpPickup.setValue(null);
		dpReturn.setValue(null);
	}

	

	public List<String> getAllCarName() {
		List<String> listName = new ArrayList<String>();
		List<Car> list = carService.findAll();
		for (Car car : list) {
			String name = car.getCarName();
			listName.add(name);
			System.out.println(name);
		}
		return listName;
	}

}
