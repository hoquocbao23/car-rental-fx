package repository.customer;

import java.util.List;

import dao.CustomerDao;
import pojo.Customer;



public class CustomerRepository implements ICustomerRepository{
	
	private CustomerDao dao;
	
	public CustomerRepository(String filename) {
		dao = new CustomerDao(filename);
	}
	
	
	@Override
	public void save(Customer customer) {
		dao.save(customer);
		 
	}

	@Override
	public void update(Customer customer) {
		dao.update(customer);
		 
	}

	@Override
	public void delete(Customer customer) {
		dao.delete(customer);
	}
	
	@Override
	public void deleteById (int customerId) {
		delete(
				dao.findById(customerId)
		);
	}

	@Override
	public Customer findById(int customerId) {
		return dao.findById(customerId);
	}

	@Override
	public List<Customer> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Customer findByEmail (String email) {
		return dao.findByEmail(email);
	}
}
