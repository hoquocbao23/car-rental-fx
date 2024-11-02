package service.account;

import java.util.List;

import pojo.Account;



public interface IAccountService {
	void save(Account account);
	void update(Account account);
    
    void delete(Account account);
    //void deleteById(int accountId);
    
    Account findByEmail(String email);
  
    List<Account> findAll();
}
