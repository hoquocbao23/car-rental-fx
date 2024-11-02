package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Customer;

public class CustomerDao {
	private SessionFactory sessionFactory;
	private Configuration configuration;

	public CustomerDao(String filename) {
		configuration = new Configuration();
		configuration = configuration.configure(filename);
		sessionFactory = configuration.buildSessionFactory();
	}
	public void save(Customer customer) {
		Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.save(customer);
    		System.out.println("Testing");
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void update(Customer customer) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	try {
    		session.update(customer);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void delete(Customer customer) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.delete(customer);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public Customer findById(int customerID) {
    	Session session = sessionFactory.openSession();
    	
    	Customer cust = null;
    	
    	try {
    		cust = session.get(Customer.class, customerID);
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return cust;    	
    }
    
    

    public List<Customer> findAll() {
    	Session session = sessionFactory.openSession();
    	List<Customer> list = null;
    	try {
    		list = session.createQuery("from Customer", Customer.class).getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return list;
    }
    
    public Customer findByEmail (String email) {
    	Session session = sessionFactory.openSession();
    	Customer cust = null;
    	
    	try {
    		cust = session
    				.createQuery("from Customer where email = :email", Customer.class)
    				.setParameter("email", email)
    				.uniqueResult();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return cust;
    }

}
