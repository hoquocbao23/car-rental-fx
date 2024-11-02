package main;

import java.time.LocalDate;
import java.util.List;

import dao.AccountDao;
import pojo.CarRental;
import service.carRental.CarRentalService;

public class main {

	public static void main(String[] args) {
		
		AccountDao dao = new AccountDao("hibernate.cfg.xml");
		
		CarRentalService service = new CarRentalService();
		LocalDate st = LocalDate.parse("2024-11-01");
		LocalDate end = LocalDate.parse("2024-11-30");
		List<CarRental> rental = service.findByDateRange(st, end);
		if (rental == null) {
			System.out.println("null");
		}else {
			System.out.println(rental);
		}

	}

}
