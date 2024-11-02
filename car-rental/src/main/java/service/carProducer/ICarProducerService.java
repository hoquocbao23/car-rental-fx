package service.carProducer;

import java.util.List;

import pojo.CarProducer;



public interface ICarProducerService {
	void save(CarProducer carProducer);
    void update(CarProducer carProducer);
    
    void delete(CarProducer carProducer);
    void deleteById(int carProducerId);
    
    CarProducer findByName(String producerName);
    CarProducer findById(int producerID);
    List<CarProducer> findAll();
	
}
