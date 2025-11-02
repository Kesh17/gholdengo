package com.rishi.gholdengo.repository;

import com.rishi.gholdengo.model.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {
}
