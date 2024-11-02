package repository.carProducer;

import java.util.List;

import dao.CarProducerDao;
import pojo.CarProducer;


public class CarProducerRepository implements ICarProducerRepository{
	
	private CarProducerDao dao;
	
	public CarProducerRepository(String filename) {
		dao = new CarProducerDao(filename);
	}
	
	@Override
	public void save(CarProducer carProducer) {
		dao.save(carProducer);
	}

	@Override
	public void update(CarProducer carProducer) {
		dao.update(carProducer);
	}

	@Override
	public void delete(CarProducer carProducer) {
		dao.delete(carProducer);
	}
	
	@Override
	public void deleteById (Integer carProducerId) {
		delete(
				dao.findById(carProducerId)
		);
	}
	
	@Override
	public CarProducer findByName(String producerName) {
		return dao.findByName(producerName);
	}

	@Override
	public CarProducer findById(int producerID) {
		return dao.findById(producerID);
	}

	@Override
	public List<CarProducer> findAll() {
		return dao.findAll();
	}
}
