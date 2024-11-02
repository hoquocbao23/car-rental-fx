package pojo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "car_rental")
@Data
public class CarRental implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rentalId;
	
	@Column(nullable = false)
	private LocalDate pickupDate;

	@Column(nullable = false)
	private LocalDate returnDate;
	
	@Column(nullable = false)
	private float rentPrice;
	
	@Column(nullable = false)
	private String Status;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public float getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(float rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	public int getCarID() {
		return car.getCarID();
	}
	
	public String getCarName() {
		return car.getCarName();
	}
	
	
	public int getCustomerID() {
		return customer.getCustomerID();
	}
	
	public int getRentalId() {
		return rentalId;
	}
	
	
	
	
	
	
	

}
