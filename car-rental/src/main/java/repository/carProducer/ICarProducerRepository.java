package repository.carProducer;

import java.util.List;

import pojo.CarProducer;



public interface ICarProducerRepository {
	void save(CarProducer carProducer);
    void update(CarProducer carProducer);
    
    void delete(CarProducer carProducer);
    void deleteById(Integer carProducerId);
    
    CarProducer findByName(String producerName);
    CarProducer findById(int producerID);
    List<CarProducer> findAll();
	
}
