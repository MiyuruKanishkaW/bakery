package com.bakery.repository;

import com.bakery.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//<<<<<<< HEAD
//=======
/*
 * Certificate Details Repository
 *
******************************************************************************************************
 ###      Date           Story Point       Task No.          Author            Description
 -----------------------------------------------------------------------------------------------------
  1    10-01-2024                                            NimashL           Created

******************************************************************************************************
*/

//>>>>>>> 646e5b944c97a69a29afb03f883c1d5bb1466aa6
@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

    Optional<Customer> findByUserName(String userName);

    List<Customer> findByStatus(String status);
}
