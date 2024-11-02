package controller.admin;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;

import java.util.ResourceBundle;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Car;
import pojo.CarProducer;
import pojo.CarRental;
import service.car.CarService;
import service.car.ICarService;
import service.carProducer.CarProducerService;
import service.carProducer.ICarProducerService;
import service.carRental.CarRentalService;
import service.carRental.ICarRentalService;
import util.AlertController;


public class ManageCarController implements Initializable {
	private ICarProducerService carProducerService ;
	
	private ICarService carService;
	
	private ICarRentalService carRentalService;
	
	
	@FXML
	private TextField txtCarId;
	
	@FXML
	private TextField txtCarName; 
	
	@FXML
	private TextField txtCarModelYear;
	
	@FXML
	private TextField txtCapacity;
	
	@FXML
	private ComboBox<String> cmbStatus;
	
	@FXML
	private TextField txtRentPrice;
	
	@FXML
	private TextField txtDescription;
	
	@FXML
	private TextField txtColor;
	
	@FXML
	private TextField txtProducer;
	
	@FXML
	private TableView<Car> carTable;
	
	@FXML
	private TableColumn<Car, Integer> cId;

	@FXML
	private TableColumn<Car, String> cName;

	@FXML
	private TableColumn<Car, Integer> cYear;

	@FXML
	private TableColumn<Car, String> cColor;
	
	@FXML
	private TableColumn<Car, Integer> cCapacity;
	
	@FXML
	private TableColumn<Car, String> cDes;
	
	@FXML
	private TableColumn<Car, LocalDateTime > cImportDate;
	
	@FXML
	private TableColumn<Car, String> cProducer;
	
	@FXML
	private TableColumn<Car, String> cStatus;
	
	@FXML
	private TableColumn<Car, Double> cPrice;
	
	
	@FXML
	private ObservableList<Car> tableModel;
	
	
	public ManageCarController() {
		this.carProducerService = new CarProducerService();
		this.carService = new CarService();
		this.carRentalService = new CarRentalService();
		tableModel = FXCollections.observableArrayList(carService.findAll());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cmbStatus.getItems().add("AVAIABLE");
		cmbStatus.getItems().add("DISABLE");
		
		cId.setCellValueFactory(new PropertyValueFactory<>("carID"));
		cName.setCellValueFactory(new PropertyValueFactory<>("carName"));
		cYear.setCellValueFactory(new PropertyValueFactory<>("carModelYear"));
		cColor.setCellValueFactory(new PropertyValueFactory<>("color"));
		cCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		cDes.setCellValueFactory(new PropertyValueFactory<>("description"));
		cImportDate.setCellValueFactory(new PropertyValueFactory<>("importDate"));
		cProducer.setCellValueFactory(new PropertyValueFactory<>("producerName"));
		cPrice.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
		cStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		carTable.setItems(tableModel);
		
		carTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observableValue, Object oldValue, Object index) {
				if (carTable.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel selectionModel = carTable.getSelectionModel();
					ObservableList selectedCell = selectionModel.getSelectedCells();
					TablePosition tablePosition = (TablePosition) selectedCell.get(0);
					Object carId  = tablePosition.getTableColumn().getCellData(index);
					try {
						Car car = carService.findById(Integer.valueOf(carId.toString()));
						showCar(car);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Error");
					}
				}

			}

		});
		
		
		
	}
	
	
	@FXML
	public void btAddOnAction()  {
		String carname = txtCarName.getText()  ;
		int carModelYear = Integer.parseInt(txtCarModelYear.getText());
		int capacity = Integer.parseInt(txtCapacity.getText()) ;
		String status = cmbStatus.getValue() ;
		float rentPrice = Float.parseFloat(txtRentPrice.getText())  ;
		String description = txtDescription.getText() ;
		String color = txtColor.getText() ;
		String producer = txtProducer.getText();
		
		Car newCar = new Car();
		newCar.setCarName(carname);
		newCar.setCarModelYear(carModelYear);
		newCar.setCapacity(capacity);
		newCar.setStatus(status);
		newCar.setRentPrice(rentPrice);
		newCar.setDescription(description);
		newCar.setColor(color);
		newCar.setImportDate(LocalDateTime.now());
		
		CarProducer carProducer = carProducerService.findByName(producer);
		
		newCar.setCarProducer(carProducer);
		
		carService.save(newCar);
		AlertController.informationAlert("Da them thanh cong!");
		loadScreen();
		
		
		
		
	
		
				
		
	}
	
	@FXML
	public void btEditOnAction() {
		int id = Integer.parseInt(txtCarId.getText());
		String carname = txtCarName.getText()  ;
		int carModelYear = Integer.parseInt(txtCarModelYear.getText());
		int capacity = Integer.parseInt(txtCapacity.getText()) ;
		String status = cmbStatus.getValue() ;
		System.out.println(status);
		float rentPrice = Float.parseFloat(txtRentPrice.getText())  ;
		String description = txtDescription.getText() ;
		String color = txtColor.getText() ;
		String producer = txtProducer.getText();
		
		CarProducer carProducer = carProducerService.findByName(producer);
		
		if (carProducer == null) {
			AlertController.errorAlert("Nha cung cap khong ton tai!");
		}else {
			Car updateCar = carService.findById(id);
			updateCar.setCarName(carname);
			updateCar.setCarModelYear(carModelYear);
			updateCar.setCapacity(capacity);
			updateCar.setStatus(status);
			updateCar.setRentPrice(rentPrice);
			updateCar.setDescription(description);
			updateCar.setColor(color);
			updateCar.setCarProducer(carProducer);
			
			carService.update(updateCar);
			AlertController.informationAlert("Update thanh cong!");
			loadScreen();
		}
		
		
		
		
		
	}
	
	@FXML
	public void btCancelOnAction() {
		txtCarId.clear();
		 txtCarName.clear();
		 txtCarModelYear.clear();
		 txtCapacity.clear();
		 txtRentPrice.clear();
		 cmbStatus.valueProperty().set(null);
		 txtDescription.clear();
		 txtColor.clear();
		 txtProducer.clear();
		
	}

	@FXML
	public void btDeleteOnAction() {
		int id = Integer.parseInt(txtCarId.getText());
		CarRental exitRental = carRentalService.findByCarId(id);
		if (exitRental != null) {
			
			String carname = txtCarName.getText()  ;
			int carModelYear = Integer.parseInt(txtCarModelYear.getText());
			int capacity = Integer.parseInt(txtCapacity.getText()) ;
			
			
			float rentPrice = Float.parseFloat(txtRentPrice.getText())  ;
			String description = txtDescription.getText() ;
			String color = txtColor.getText() ;
			String producer = txtProducer.getText();
			
			CarProducer carProducer = carProducerService.findByName(producer);
			
			if (carProducer == null) {
				AlertController.errorAlert("Nha cung cap khong ton tai!");
			}else {
				Car updateCar = carService.findById(id);
				updateCar.setCarName(carname);
				updateCar.setCarModelYear(carModelYear);
				updateCar.setCapacity(capacity);
				updateCar.setStatus("DISABLE");
				updateCar.setRentPrice(rentPrice);
				updateCar.setDescription(description);
				updateCar.setColor(color);
				updateCar.setCarProducer(carProducer);
				
				carService.update(updateCar);
				AlertController.informationAlert("Update thanh cong!");
				loadScreen();
			}
		}
		else {
			Car removeCar = carService.findById(id);
			carService.delete(removeCar);
			loadScreen();
		}
		
	}
	
	
	
	public void loadScreen() {
		tableModel = FXCollections.observableArrayList(carService.findAll());
		carTable.setItems(tableModel);
	}
	
	public void showCar(Car car) {
		txtCarId.setText(String.valueOf(car.getCarID()));
		txtCarName.setText(car.getCarName());
		 txtCarModelYear.setText(String.valueOf(car.getCarModelYear()));
		 txtCapacity.setText(String.valueOf(car.getCapacity()));
		 txtRentPrice.setText(String.valueOf(car.getRentPrice()));
		 txtDescription.setText(car.getDescription());
		 txtColor.setText(car.getColor());
		 txtProducer.setText(car.getProducerName());
		 cmbStatus.setValue(car.getStatus());
	}
	
	

	

}
