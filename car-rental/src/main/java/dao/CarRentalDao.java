package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.CarRental;

public class CarRentalDao {
	private SessionFactory sessionFactory;
	private Configuration configuration;

	public CarRentalDao(String filename) {
		configuration = new Configuration();
		configuration = configuration.configure(filename);
		sessionFactory = configuration.buildSessionFactory();
	}
	public void save(CarRental carRental) {
		Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.save(carRental);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void update(CarRental carRental) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.update(carRental);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void delete(CarRental carRental) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	try {
    		session.delete(carRental);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public CarRental findById(int id) {
    	Session session = sessionFactory.openSession();
    	CarRental rental = null;
    	
    	try {
    		rental = session.get(CarRental.class, id);
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return rental;
    }
    
    public List<CarRental> findAllByCustomerId(int customerId) {
    	Session session = sessionFactory.openSession();
    	List<CarRental> list = null;
    	
    	try {
    		list = session
    				.createQuery("from CarRental AS c  where c.customer.customerID = :id", CarRental.class)
    				.setParameter("id", customerId)
    				.getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return list;    	
    }
    
    
    
    public List<CarRental> findAllByCarId (Integer carID) {
    	Session session = sessionFactory.openSession();
    	List<CarRental> list = null;
    	
    	try {
    		list = session
    				.createQuery("from CarRental where carID = :id", CarRental.class)
    				.setParameter("id", carID)
    				.getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return list;
    }
    
    public CarRental findByCarId(int carID) {
    	Session session = sessionFactory.openSession();
    	CarRental rental = null;
    	
    	try {
    		rental = session
    				.createQuery("from CarRental AS c where c.car.carID = :id", CarRental.class)
    				.setParameter("id", carID)
    				.uniqueResult();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return rental;
    }

    public List<CarRental> findAll() {
    	Session session = sessionFactory.openSession();
    	List<CarRental> list = null;
    	
    	try {
    		list = session
    				.createQuery("from CarRental", CarRental.class)
    				.getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return list;
    }
    
    public List<CarRental> findByDateRange(LocalDate startDate, LocalDate endDate) {
    	Session session = sessionFactory.openSession();
        List<CarRental> list = null;
        
        try {
            list = session.createQuery("from CarRental as c where (c.pickupDate between :startDate and :endDate) order by pickupDate desc", CarRental.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            session.close();
        }
        
        return list;
    }

}
