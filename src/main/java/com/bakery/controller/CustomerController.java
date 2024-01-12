package com.bakery.controller;

import com.bakery.domain.Customer;
import com.bakery.resource.CustomerResource;
import com.bakery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * Certificate Details Controller
 *
******************************************************************************************************
 ###      Date           Story Point       Task No.          Author            Description
 -----------------------------------------------------------------------------------------------------
  1    10-01-2024                                            NimashL           Created

******************************************************************************************************
*/

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/userName/{userName}")
    public Optional<Customer> getCustomerByUserName(@PathVariable String userName){
        return customerService.getCustomerByUserName(userName);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/status/{status}")
    public List<Customer> getCustomerByStatus(@PathVariable String status){
        return customerService.getCustomerByStatus(status);
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerResource customerResource){
        return customerService.saveCustomer(customerResource);
    }

    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody CustomerResource customerResource){
        return customerService.updateCustomer(id, customerResource);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
