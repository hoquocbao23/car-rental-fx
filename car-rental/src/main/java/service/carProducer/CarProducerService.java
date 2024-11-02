package service.carProducer;

import java.util.List;

import pojo.CarProducer;
import repository.carProducer.CarProducerRepository;
import repository.carProducer.ICarProducerRepository;



public class CarProducerService implements ICarProducerService{
	
	private ICarProducerRepository repo;
	
	public CarProducerService() {
		repo = new CarProducerRepository("hibernate.cfg.xml");
	}
	
	@Override
	public  void save(CarProducer carProducer) {
		 repo.save(carProducer);
	}

	@Override
	public void update(CarProducer carProducer) {
		 repo.update(carProducer);
	}

	@Override
	public void delete(CarProducer carProducer) {
		repo.delete(carProducer);
	}
	
	@Override
	public void deleteById (int carProducerId) {
		repo.deleteById(carProducerId);
	}
	
	@Override
	public CarProducer findByName(String producerName) {
		return repo.findByName(producerName);
	}

	@Override
	public CarProducer findById(int producerID) {
		return repo.findById(producerID);
	}

	@Override
	public List<CarProducer> findAll() {
		return repo.findAll();
	}
	
}
