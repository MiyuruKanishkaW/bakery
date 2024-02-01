package com.bakery.repository;

import com.bakery.domain.OrderItem;
import com.bakery.domain.Orders;
import com.bakery.resource.OrderResurceRaivndu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepositoryRavindu extends JpaRepository<Orders, Long> {

    Optional<Orders> findByReferenceCode(String referenceCode);
    List<Orders> findByCustomers_Id(Long customers);

    //Orders existsById(Orders order);
}
