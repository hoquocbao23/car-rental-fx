package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Account;

public class AccountDao {
	private SessionFactory sessionFactory;
	private Configuration configuration;

	public AccountDao(String filename) {
		configuration = new Configuration();
		configuration = configuration.configure(filename);
		sessionFactory = configuration.buildSessionFactory();
	}

	public void save(Account account) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(account);
			t.commit();
		} catch (Exception ex) {
			t.rollback();
			System.out.println(ex);
		} finally {
			session.close();
		}
	}

	public void update(Account account) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(account);
			tr.commit();
		} catch (Exception ex) {
			tr.rollback();
			System.out.println(ex);
		} finally {
			session.close();
		}
	}

	public void delete(Account account) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		try {
			session.delete(account);
			tr.commit();
		} catch (Exception ex) {
			tr.rollback();
			System.out.println(ex);
		} finally {
			session.close();
		}
	}

	public Account findByEmail(String email ) {
		Session session = sessionFactory.openSession();
		Account account = null;
		try {
			account = session.get(Account.class, email);
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return account;
	}

	public List<Account> findAll() {
		Session session = sessionFactory.openSession();
		List<Account> list = new LinkedList<>();

		try {
			list = session.createQuery("from Account", Account.class).getResultList();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}

		return list;
	}

}
