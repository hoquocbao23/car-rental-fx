package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Review;

public class ReviewDao {
	private SessionFactory sessionFactory;
	private Configuration configuration;

	public ReviewDao(String filename) {
		configuration = new Configuration();
		configuration = configuration.configure(filename);
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public void save(Review review) {
		Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.save(review);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void update(Review review) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.update(review);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public void delete(Review review) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	try {
    		session.delete(review);
    		t.commit();
    	} catch (Exception ex) {
    		t.rollback();
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    }

    public Review findById(int id) {
    	Session session = sessionFactory.openSession();
    	
    	Review review = null;
    	
    	try {
    		review = session.get(Review.class, id);
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return review;
    }
    
    public List<Review> findAllByCustomerId (Integer customerId) {
    	Session session = sessionFactory.openSession();
    	List<Review> list = null;
    	
    	try {
    		list = session
    				.createQuery("from Review where customerID = :id", Review.class)
    				.setParameter("id", customerId)
    				.getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return list;
    }
    
    public List<Review> findAllByCarId (Integer carID) {
    	Session session = sessionFactory.openSession();
    	
    	List<Review> list = null;
    	
    	try {
    		list = session
    				.createQuery("from Review where carID = :id", Review.class)
    				.setParameter("id", carID)
    				.getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	
        return list;
    	
    }

    public List<Review> findAll() {
    	Session session = sessionFactory.openSession();
    	List<Review> list = null;
    	
    	try {
    		list = session
    				.createQuery("from Review", Review.class)
    				.getResultList();
    	} catch (Exception ex) {
    		System.out.println(ex);
    	} finally {
    		session.close();
    	}
    	return list;
    }

}
