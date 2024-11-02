package service.customer;

import java.util.List;

import pojo.Customer;
import repository.customer.CustomerRepository;
import repository.customer.ICustomerRepository;




public class CustomerService implements ICustomerService{
	
	private final ICustomerRepository repo;
	
	public CustomerService() {
		repo = new CustomerRepository("hibernate.cfg.xml");
	}
	
	
	@Override
	public void save(Customer customer) {
		 repo.save(customer);
	}

	@Override
	public void update(Customer customer) {
		 repo.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		repo.delete(customer);
	}
	
	@Override
	public void deleteById (Integer customerId) {
		repo.deleteById(customerId);
	}

	@Override
	public Customer findById(int customerId) {
		return repo.findById(customerId);
	}

	@Override
	public List<Customer> findAll() {
		return repo.findAll();
	}
	
	@Override
	public Customer authenticate(String email, String password) {
		Customer cust = repo.findByEmail(email);
		System.out.println(cust);
		if (cust != null && cust.getPassword().equals(password))
			return cust;
		return null;
	}
}
