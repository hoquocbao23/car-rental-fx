package repository.customer;

import java.util.List;

import pojo.Customer;



public interface ICustomerRepository {
	void save(Customer customer);
	void update(Customer customer);
    
    void delete(Customer customer);
    void deleteById(int customerId);
    
    Customer findById(int customerId);
    List<Customer> findAll();
	Customer findByEmail(String email);
	
}
