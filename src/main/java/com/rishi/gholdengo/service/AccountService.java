package com.rishi.gholdengo.service;

import com.rishi.gholdengo.model.Account;
import com.rishi.gholdengo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account get(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Iterable<Account> get(){
        return accountRepository.findAll();
    }

    public Account save(Account account){
        return accountRepository.save(account);
    }

    public Account update(Account account){
        return accountRepository.save(account);
    }

    public void remove(Integer id){
        accountRepository.deleteById(id);
    }
}
