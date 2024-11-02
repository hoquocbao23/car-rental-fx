package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Car;
import pojo.Customer;

public class CarDao {
	private SessionFactory sessionFactory;
	private Configuration configuration;

	public CarDao(String filename) {
		configuration = new Configuration();
		configuration = configuration.configure(filename);
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public void save(Car car) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.save(car);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void update(Car car) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.update(car);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void delete(Car car) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.delete(car);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public Car findById(int carID) {
    	Session session = sessionFactory.openSession();
    	Car car = null;
    	
    	try {
    		car = session.get(Car.class, carID);
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return car;
    }

    public List<Car> findAll() {
    	Session session = sessionFactory.openSession();
    	List<Car> list = new LinkedList<>();
    	
    	try {
    		list = session.createQuery("from Car", Car.class).getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return list;
    }
    
    public Car findByName(String carName) {
    	Session session = sessionFactory.openSession();
    	
    	Car car = null;
    	
    	try {
    		car = session
    				.createQuery("from Car where carName = :name", Car.class)
    				.setParameter("name", carName)
    				.uniqueResult();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return car;
    	
    }

}
