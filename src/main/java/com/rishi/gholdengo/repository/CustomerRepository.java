package com.rishi.gholdengo.repository;

import com.rishi.gholdengo.model.Account;
import com.rishi.gholdengo.model.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query("select * from account where customer_id = :customerId")
    List<Account> findByAllAccountsByCustomerId(Integer customerId);
}