package com.rishi.gholdengo.web;

import com.rishi.gholdengo.model.Account;
import com.rishi.gholdengo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AccountContoller {

    private final AccountService accountService;

   public AccountContoller(AccountService accountService){
       this.accountService= accountService;
   }

   @GetMapping("/accounts")
    public Iterable<Account> get(){
       return accountService.get();
   }

    @GetMapping("/accounts/{id}")
    public Account get(@PathVariable Integer id){
        Account account = accountService.get(id);
        if(account == null){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        return account;
    }

    @PostMapping("/accounts")
    public Account create(@RequestBody Account account){
       return accountService.save(account);
    }
}
