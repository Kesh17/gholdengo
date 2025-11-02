package com.rishi.gholdengo.web;

import com.rishi.gholdengo.model.Transactions;
import com.rishi.gholdengo.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    private final TransactionService transactionService;

    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public Iterable<Transactions> get(){
        return transactionService.get();
    }

    @PostMapping("/transactions")
    public Transactions transfer(@RequestBody Transactions transactions){
        switch (transactions.getTransactionsType()){
            case DEPOSIT:
                transactionService.deposit(transactions.getAccountId(), transactions.getAmount());
                break;
            case WITHDRAW:
                transactionService.withdraw(transactions.getAccountId(), transactions.getAmount());
                break;
            case TRANSFER:
                transactionService.transfer(transactions.getAccountId(), transactions.getFromAccountId(),transactions.getAmount());
                break;
        }
        return transactionService.save(transactions);
    }
}
