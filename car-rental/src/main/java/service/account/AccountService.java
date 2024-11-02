package service.account;

import java.util.List;

import pojo.Account;
import repository.account.AccountRepository;
import repository.account.IAccountRepository;



public class AccountService implements IAccountService{
	
	private IAccountRepository repo;
	
	public AccountService() {
		repo = new AccountRepository("hibernate.cfg.xml");
	}
	
	@Override
	public void save(Account account) {
		 repo.save(account);
	}

	@Override
	public void update(Account account) {
		 repo.update(account);
	}

	@Override
	public void delete(Account account) {
		repo.delete(account);
	}
	
//	@Override
//	public void deleteById(int accountId) {
//		repo.deleteById(accountId);
//	}

	@Override
	public Account findByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public List<Account> findAll() {
		return repo.findAll();
	}

	
	
}
