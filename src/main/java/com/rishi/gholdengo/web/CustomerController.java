package com.rishi.gholdengo.web;

import com.rishi.gholdengo.model.Account;
import com.rishi.gholdengo.model.Customer;
import com.rishi.gholdengo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CustomerController {

   private final CustomerService customerService;

   public CustomerController(CustomerService customerService) {
       this.customerService = customerService;
   }

    @GetMapping("/customers/{id}")
    public Customer get(@PathVariable Integer id){
       Customer customer = customerService.get(id);
       if(customer == null){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
       }
       return customer;
    }

    @GetMapping("/customers")
    public Iterable<Customer> get(){
        return customerService.get();
    }

    @PostMapping("/customers")
    public Customer create(@RequestBody Customer customer){
        return  customerService.save(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer update(@PathVariable Integer id, @RequestBody Customer customer){
       Customer temp =  customerService.get(id);
       if(temp==null){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");}
       temp.setName(customer.getName());
       temp.setPassword(customer.getPassword());
        return  customerService.update(temp);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Integer id){
        Customer customer = customerService.get(id);
        if(customer == null){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        customerService.remove(id);
    }

    @GetMapping("/customers/{id}/accounts")
    public Iterable<Account> getAccounts(@PathVariable Integer id){
       return customerService.getAccounts(id);
    }
}
