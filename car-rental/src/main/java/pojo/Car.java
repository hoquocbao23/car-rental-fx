package pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;



@Entity
@Table(name = "car")

public class Car implements Serializable {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int carID;

	    @Column(nullable = false)
	    private String carName;

	    @Column(nullable = false)
	    private int carModelYear;

	    @Column(nullable = false)
	    private String color;

	    @Column(nullable = false)
	    private int capacity;

	    @Column(nullable = false)
	    private String description;

	    @Column(nullable = false)
	    private LocalDateTime importDate;

	    
	    @Column(nullable = false)
	    private float rentPrice;

	    @Column(nullable = false)
	    private String status;
	    
	    @ManyToOne()
	    @JoinColumn(name = "producerId")
	    private CarProducer carProducer;

		public int getCarID() {
			return carID;
		}

		public void setCarID(int carID) {
			this.carID = carID;
		}

		public String getCarName() {
			return carName;
		}

		public void setCarName(String carName) {
			this.carName = carName;
		}

		public int getCarModelYear() {
			return carModelYear;
		}

		public void setCarModelYear(int carModelYear) {
			this.carModelYear = carModelYear;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public LocalDateTime getImportDate() {
			return importDate;
		}

		public void setImportDate(LocalDateTime importDate) {
			this.importDate = importDate;
		}

		public float getRentPrice() {
			return rentPrice;
		}

		public void setRentPrice(float rentPrice) {
			this.rentPrice = rentPrice;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public CarProducer getCarProducer() {
			return carProducer;
		}

		public void setCarProducer(CarProducer carProducer) {
			this.carProducer = carProducer;
		}
		
		public String getProducerName() {
			return carProducer.getProducerName();
		}
	    
	    
	    
	   
	    
	   
	

}
