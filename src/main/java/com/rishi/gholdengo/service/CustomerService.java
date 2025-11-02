package com.rishi.gholdengo.service;

import com.rishi.gholdengo.model.Account;
import com.rishi.gholdengo.model.Customer;
import com.rishi.gholdengo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer get(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Iterable<Customer> get(){
        return customerRepository.findAll();
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

   public Customer update(Customer customer){
       return customerRepository.save(customer);
   }

   public void remove(Integer id){
       customerRepository.deleteById(id);
   }

   public Iterable<Account> getAccounts(Integer id){
       return customerRepository.findByAllAccountsByCustomerId(id);
   }
}
