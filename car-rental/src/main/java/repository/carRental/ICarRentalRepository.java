package repository.carRental;

import java.time.LocalDate;
import java.util.List;

import pojo.CarRental;



public interface ICarRentalRepository {
	void save(CarRental carRental);
	void update(CarRental carRental);
    
    void delete(CarRental carRental);
    void deleteById(int carRentalId);
    
    CarRental findById(int carRentalId);
    List<CarRental> findByCustomerId (int customerId);
    List<CarRental> findAllByCarId(int carId);
    List<CarRental> findAll();
    List<CarRental> findByDateRange(LocalDate startDate, LocalDate endDate);
    CarRental findByCarId(Integer carID);
}
