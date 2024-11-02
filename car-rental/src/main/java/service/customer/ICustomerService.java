package service.customer;

import java.util.List;

import pojo.Customer;

 

public interface ICustomerService {
	void save(Customer customer);
	void update(Customer customer);
    
    void delete(Customer customer);
    void deleteById(Integer customerId);
    
    Customer findById(int customerId);
    List<Customer> findAll();
	Customer authenticate(String email, String password);
	
    
}
