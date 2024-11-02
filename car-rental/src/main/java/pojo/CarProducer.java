package pojo;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car_producer")

public class CarProducer {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int producerId;

	@Column(nullable = false)
	private String producerName;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String country;
	
	@OneToMany(mappedBy = "carProducer")
	private List<Car> listCar;
	
	public int getProducerId() {
		return producerId;
	}

	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Car> getListCar() {
		return listCar;
	}

	public void setListCar(List<Car> listCar) {
		this.listCar = listCar;
	}

	
	
	
	
	

}
