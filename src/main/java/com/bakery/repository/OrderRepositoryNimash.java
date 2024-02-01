package com.bakery.repository;

import com.bakery.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepositoryNimash extends JpaRepository<Orders, Long> {

    Optional<Orders> findByReferenceCode(String referenceCode);
    List<Orders> findByCustomersId(Long customerId);
}
