package com.bakery.controller;

import com.bakery.domain.Customer;
import com.bakery.resource.CustomerResource;
import com.bakery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class customerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();

    }

    @GetMapping("/username")
    public Optional<Customer> getCustomerByUserName(@PathVariable String userName){
        return customerService.getCustomerByUserName(userName);

    }

    @GetMapping("/id")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);

    }

    @GetMapping("/status")
    public Optional<Customer> getCustomerByStatus(@PathVariable String status){
        return customerService.getCustomerByStatus(status);

    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerResource customerResource){
        return customerService.saveCustomer(customerResource);

    }

    @PutMapping("/id")
    public String updateCustomer(@PathVariable Long id, @RequestBody CustomerResource customerResource){
        return customerService.updateCustomer(id, customerResource);

    }

    @DeleteMapping("/id")
    public String deleteCustomer(Long id){
        return customerService.deleteCustomer(id);

    }
}
