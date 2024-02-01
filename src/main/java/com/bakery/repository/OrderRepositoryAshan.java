package com.bakery.repository;

import com.bakery.domain.OrderItem;
import com.bakery.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepositoryAshan extends JpaRepository<Orders,Long> {

    Optional<Orders> getOrderByReferenceCode(String referenceCode);

    List<Orders> getOrderByCustomerId(Long customer);

}