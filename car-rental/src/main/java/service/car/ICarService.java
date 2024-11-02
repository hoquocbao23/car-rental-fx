package service.car;

import java.util.List;

import pojo.Car;



public interface ICarService {
	void save(Car carProducer);
    void update(Car carProducer);
    
    void delete(Car car);
    void deleteById(Integer carId);
    
    Car findById(int carId);
    Car findByName(String carName);
    List<Car> findAll();
	
    boolean isCarInTransaction(int carId);
}
