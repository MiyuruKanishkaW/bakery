package com.bakery.service.impl;

import com.bakery.domain.Customer;
import com.bakery.repository.CustomerRepository;
import com.bakery.resource.CustomerResource;
import com.bakery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();

    }

    @Override
    public Optional<Customer> getCustomerByUserName(String userName){
        Optional<Customer> customer = customerRepository.findById(Long.valueOf(userName));
        if (customer.isPresent()){
            return Optional.ofNullable(customer.get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> getCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return Optional.ofNullable(customer.get());
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> getCustomerByStatus(String status){
        Optional<Customer> customer = customerRepository.findById(Long.valueOf(status));
        if (customer.isPresent()){
            return Optional.ofNullable(customer.get());
        }else {
            return Optional.empty();
        }
    }

    @Override
    public String saveCustomer(CustomerResource customerResource){
        Customer customer = new Customer();

        customer.setFirstName(customerResource.getFirstName());
        customer.setLastName(customerResource.getLastName());
        customer.setEmail(customerResource.getEmail());
        customer.setContactNumber(customerResource.getContactNumber());
        customer.setUserName(customerResource.getUserName());
        customer.setStatus(customerResource.getStatus());
        customer.setCreatedDate(customerResource.getCreatedDate());
        customer.setCreatedUser(customerResource.getCreatedUser());
        customer.setModifiedDate(customerResource.getModifiedDate());
        customer.setModifiedUser(customerResource.getModifiedUser());

        customerRepository.save(customer);
        return "record saved successfully";

    }

    @Override
    public String updateCustomer(Long id, CustomerResource customerResource){
        Optional<Customer> exitingCustomer = customerRepository.findById(id);
        if(exitingCustomer.isPresent()){
            Customer customer = exitingCustomer.get();
            customer.setFirstName(customerResource.getFirstName());
            customer.setLastName(customerResource.getLastName());
            customer.setEmail(customerResource.getEmail());
            customer.setContactNumber(customerResource.getContactNumber());
            customer.setUserName(customerResource.getUserName());
            customer.setStatus(customerResource.getStatus());
            customer.setCreatedDate(customerResource.getCreatedDate());
            customer.setCreatedUser(customerResource.getCreatedUser());
            customer.setModifiedDate(customerResource.getModifiedDate());
            customer.setModifiedUser(customerResource.getModifiedUser());

            customerRepository.save(customer);
            return "record update successfully";
        }else {
            return "record not found";
        }
    }

    @Override
    public String deleteCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            customerRepository.deleteById(id);
            return "record delete successfully";
        }else {
            return "record not found";
        }

    }
}
