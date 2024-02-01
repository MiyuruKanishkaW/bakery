package com.bakery.repository;

import com.bakery.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepositoryAshan extends JpaRepository<OrderItem,Long> {

    List<OrderItem> getByOrderId(Long order);
    Optional<OrderItem> getByStatus(String status);
}
