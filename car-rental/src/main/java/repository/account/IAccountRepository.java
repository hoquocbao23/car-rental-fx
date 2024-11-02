package repository.account;

import java.util.List;

import pojo.Account;

public interface IAccountRepository {
	void save(Account account);
	void update(Account account);
    
    void delete(Account account);
    void deleteByEmail(String email);
    
    Account findByEmail(String email);
  
    List<Account> findAll();
}
