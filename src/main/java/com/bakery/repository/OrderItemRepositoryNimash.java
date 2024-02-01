package com.bakery.repository;

import com.bakery.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepositoryNimash extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrdersId(Long orderId);

}
