package repository.carRental;

import java.time.LocalDate;
import java.util.List;

import dao.CarRentalDao;
import pojo.CarRental;




public class CarRentalRepository implements ICarRentalRepository{
	
	private CarRentalDao dao;
	
	public CarRentalRepository(String filename) {
		dao = new CarRentalDao(filename);
	}
	
	@Override
	public void save(CarRental carRental) {
		dao.save(carRental);
	 
	}

	@Override
	public void update(CarRental carRental) {
		dao.update(carRental);
		 
	}

	@Override
	public void delete(CarRental carRental) {
		dao.delete(carRental);
	}
	
	@Override
	public void deleteById (int carRentalId) {
		delete(
				dao.findById(carRentalId)
		);
	}

	@Override
	public CarRental findById(int carRentalId) {
		return dao.findById(carRentalId);
	}

	@Override
	public List<CarRental> findAll() {
		return dao.findAll();
	}

	@Override
	public List<CarRental> findByCustomerId(int customerId) {
		return dao.findAllByCustomerId(customerId);
	}

	@Override
	public List<CarRental> findAllByCarId(int carId) {
		return dao.findAllByCarId(carId);
	}

	@Override
	public List<CarRental> findByDateRange(LocalDate startDate, LocalDate endDate) {
		return dao.findByDateRange(startDate, endDate);
	}

	@Override
	public CarRental findByCarId(Integer carID) {
		// TODO Auto-generated method stub
		return dao.findByCarId(carID);
	}
	
}
