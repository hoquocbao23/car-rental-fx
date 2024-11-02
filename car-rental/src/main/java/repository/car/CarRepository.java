package repository.car;

import java.util.List;

import dao.CarDao;
import pojo.Car;


public class CarRepository implements ICarRepository{
	
	private CarDao dao;
	
	public CarRepository(String filename) {
		dao = new CarDao(filename);
	}
	
	@Override
	public void save(Car car) {
		dao.save(car);
	}

	@Override
	public void update(Car car) {
		dao.update(car);
	
	}

	@Override
	public void delete(Car car) {
		dao.delete(car);
	}
	
	@Override
	public void deleteById (Integer carId) {
		delete(
				dao.findById(carId)
		);
	}

	@Override
	public Car findById(int carId) {
		return dao.findById(carId);
	}

	@Override
	public List<Car> findAll() {
		return dao.findAll();
	}

	@Override
	public Car findByName(String carName) {
		// TODO Auto-generated method stub
		return dao.findByName(carName);
	}
	
}
