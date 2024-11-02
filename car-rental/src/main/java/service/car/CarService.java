package service.car;

import java.util.List;

import pojo.Car;
import pojo.CarRental;
import repository.car.CarRepository;
import repository.car.ICarRepository;
import repository.carRental.CarRentalRepository;
import repository.carRental.ICarRentalRepository;




public class CarService implements ICarService{
	
	private ICarRepository carRepo;
	private ICarRentalRepository carRentalRepo;
	
	public CarService () {
		carRepo = new CarRepository("hibernate.cfg.xml");
		carRentalRepo = new CarRentalRepository("hibernate.cfg.xml");
	}
	
	@Override
	public void save(Car car) {
		 carRepo.save(car);
	}

	@Override
	public void update(Car car) {
		 carRepo.update(car);
	}

	@Override
	public void delete(Car car) {
		carRepo.delete(car);
	}
	
	@Override
	public void deleteById (Integer carId) {
		if (!isCarInTransaction(carId)) {
            carRepo.deleteById(carId);
        } else {
            Car car = carRepo.findById(carId);
            if (car!=null) {
                car.setStatus("available");
                carRepo.update(car);
                List<CarRental> rentals = carRentalRepo.findAllByCarId(carId);
                if (rentals!=null) {
                	CarRental c = rentals.get(0);
                	c.setStatus("Cancelled");
                	carRentalRepo.update(c);
                }
            }
        }
    }

	@Override
	public Car findById(int carId) {
		return carRepo.findById(carId);
	}

	@Override
	public List<Car> findAll() {
		return carRepo.findAll();
	}
	
    @Override
    public boolean isCarInTransaction(int carId) {
        List<CarRental> rentals = carRentalRepo.findAllByCarId(carId);
        if (!rentals.isEmpty()) {
            CarRental lastRental = rentals.get(rentals.size() - 1);
            return lastRental.getStatus().equals("Booked");
        }
        return false;
    }

	@Override
	public Car findByName(String carName) {
		// TODO Auto-generated method stub
		return carRepo.findByName(carName);
	}
	
}
