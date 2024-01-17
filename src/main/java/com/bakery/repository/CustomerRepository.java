package com.bakery.repository;

import com.bakery.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

    Optional<Customer> findByUserName(String userName);

    List<Customer> findByStatus(String status);
}
