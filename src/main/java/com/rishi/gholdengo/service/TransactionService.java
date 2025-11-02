package com.rishi.gholdengo.service;

import com.rishi.gholdengo.model.Account;
import com.rishi.gholdengo.model.Transactions;
import com.rishi.gholdengo.repository.AccountRepository;
import com.rishi.gholdengo.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {
    private final TransactionsRepository transactionsRepository;
    private final AccountService accountService;

    public TransactionService(TransactionsRepository transactionsRepository, AccountRepository accountRepository, AccountService accountService) {
        this.transactionsRepository = transactionsRepository;
        this.accountService = accountService;
    }

    public Iterable<Transactions> get(){
        return transactionsRepository.findAll();
    }

    public Transactions get(Integer id){
        return transactionsRepository.findById(id).orElse(null);
    }

    public Transactions save(Transactions transactions){
        return transactionsRepository.save(transactions);
    }

    public Transactions update(Transactions transactions){
        return transactionsRepository.save(transactions);
    }

    public void remove(Integer id){
        transactionsRepository.deleteById(id);
    }

    public void withdraw(Integer id, BigDecimal amount){
        Account account = accountService.get(id);
        account.setBalance(account.getBalance().subtract(amount));
        accountService.save(account);
    }

    public void deposit(Integer id, BigDecimal amount){
        Account account = accountService.get(id);
        account.setBalance(account.getBalance().add(amount));
        accountService.save(account);
    }

    public void transfer(Integer fromAccountId, Integer toAccountId, BigDecimal amount){
        withdraw(fromAccountId, amount);
        deposit(toAccountId, amount);
    }
}
