package repository.car;

import java.util.List;

import pojo.Car;


public interface ICarRepository {
	void save(Car car);
    void update(Car car);
    
    void delete(Car car);
    void deleteById(Integer carId);
    
    Car findById(int carId);
    List<Car> findAll();
    Car findByName(String carName);

}
