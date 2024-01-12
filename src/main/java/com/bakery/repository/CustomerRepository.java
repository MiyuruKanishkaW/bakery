package com.bakery.repository;

import com.bakery.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * Certificate Details Repository
 *
******************************************************************************************************
 ###      Date           Story Point       Task No.          Author            Description
 -----------------------------------------------------------------------------------------------------
  1    10-01-2024                                            NimashL           Created

******************************************************************************************************
*/

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

    Optional<Customer> findByUserName(String userName);
    List<Customer> findByStatus(String status);
}
