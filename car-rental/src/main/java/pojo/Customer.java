package pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "customer")
@Data
@Getter
@Setter
public class Customer implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private String identityCard;

    @Column(nullable = false)
    private String licenceNumber;

    @Column(nullable = false)
    private LocalDate licenceDate;

//    @Column(nullable = false)
//    private String email;

//    @Column(nullable = false)
//    private String password;

    
    @JoinColumn(nullable = false, name = "email")
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public String getIdentityCard() {
		return identityCard;
	}


	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}


	public String getLicenceNumber() {
		return licenceNumber;
	}


	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}


	public LocalDate getLicenceDate() {
		return licenceDate;
	}


	public void setLicenceDate(LocalDate licenceDate) {
		this.licenceDate = licenceDate;
	}


	public String getEmail() {
		return account.getEmail();
	}
//
//
//	public void setEmail(String email) {
//		this.email = email;
//	}


	public String getPassword() {
		return account.getPasword();
	}


	


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	
	
    
    
    
    
    
    
	

}
