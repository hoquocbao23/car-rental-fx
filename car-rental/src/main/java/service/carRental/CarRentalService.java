package service.carRental;

import java.time.LocalDate;
import java.util.List;

import pojo.CarRental;
import repository.carProducer.CarProducerRepository;
import repository.carRental.CarRentalRepository;
import repository.carRental.ICarRentalRepository;

 

public class CarRentalService implements ICarRentalService{
	
	private ICarRentalRepository repo;
	
	public CarRentalService () {
		repo = new CarRentalRepository("hibernate.cfg.xml");
	}
	
	@Override
	public void save(CarRental carRental) {
		 repo.save(carRental);
	}

	@Override
	public void update(CarRental carRental) {
		 repo.update(carRental);
	}

	@Override
	public void delete(CarRental carRental) {
		repo.delete(carRental);
	}
	
	@Override
	public void deleteById (int carRentalId) {
		repo.deleteById(carRentalId);
	}

	@Override
	public CarRental findById(int carRentalId) {
		return repo.findById(carRentalId);
	}
	
	

	@Override
	public List<CarRental> findAll() {
		return repo.findAll();
	}

	@Override
	public List<CarRental> findByCustomerId(int customerId) {
		return repo.findByCustomerId(customerId);
	}

	

	@Override
	public List<CarRental> findByDateRange(LocalDate startDate, LocalDate endDate) {
		return repo.findByDateRange(startDate, endDate);
	}

	@Override
	public List<CarRental> findAllByCarId(int carId) {
		return repo.findAllByCarId(carId);
	}

	@Override
	public CarRental findByCarId(Integer carID) {
		// TODO Auto-generated method stub
		return repo.findByCarId(carID);
	}
	
}
