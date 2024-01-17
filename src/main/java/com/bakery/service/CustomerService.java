package com.bakery.service;

import com.bakery.domain.Customer;
import com.bakery.resource.CustomerResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CustomerService {

    List<Customer> getAllCustomer();

    Optional<Customer> getCustomerByUserName(String userName);

    Optional<Customer> getCustomerById(Long id);

    List<Customer> getCustomerByStatus(String status);

    String saveCustomer(CustomerResource customerResource);

    String updateCustomer(Long id,CustomerResource customerResource);

    String deleteCustomer(Long id);





}
