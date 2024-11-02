package repository.account;

import java.util.List;

import dao.AccountDao;
import pojo.Account;


public class AccountRepository implements IAccountRepository{
	
	private AccountDao dao;
	
	public AccountRepository(String filename) {
		dao = new AccountDao(filename );
	}
	
	
	@Override
	public void save(Account account) {
		dao.save(account);
		
	}

	@Override
	public void update(Account account) {
		dao.update(account);
		
	}

	@Override
	public void delete(Account account) {
		dao.delete(account);
	}
	
	@Override
	public void deleteByEmail (String email) {
		dao.delete(null);
	}

	@Override
	public Account findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}

	
	
}
