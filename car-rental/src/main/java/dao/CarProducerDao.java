package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.CarProducer;

public class CarProducerDao {
	private SessionFactory sessionFactory;
	private Configuration configuration;

	public CarProducerDao(String filename) {
		configuration = new Configuration();
		configuration = configuration.configure(filename);
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public void save(CarProducer carProducer) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.save(carProducer);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void update(CarProducer carProducer) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.update(carProducer);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void delete(CarProducer carProducer) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.delete(carProducer);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public CarProducer findById(int producerID) {
    	Session session = sessionFactory.openSession();
    	CarProducer producer = null;
    	
    	try {
    		producer = session.get(CarProducer.class, producerID);
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return producer;
    }
    
    public CarProducer findByName(String producerName) {
    	Session session = sessionFactory.openSession();
		CarProducer producer = null;

		try {
			
			producer = session.createQuery("from CarProducer where producerName = :producerName", CarProducer.class)
					.setParameter("producerName", producerName).uniqueResult();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}

		return producer;
	}

    public List<CarProducer> findAll() {
    	Session session = sessionFactory.openSession();
    	List<CarProducer> list = null;
    	
    	try {
    		list = session.createQuery("from CarProducer", CarProducer.class).getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return list;    	
    }

}
