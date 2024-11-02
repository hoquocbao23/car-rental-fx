package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertController {
	
	public static void errorAlert(String error) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(error);
		alert.show();
	}
	
	public static void informationAlert(String info) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(info);
		alert.show();
	}

}
