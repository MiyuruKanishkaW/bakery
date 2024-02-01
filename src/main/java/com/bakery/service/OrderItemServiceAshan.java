package com.bakery.service;

import com.bakery.domain.OrderItem;
import com.bakery.resource.OrderItemResourceAshan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderItemServiceAshan {

    List<OrderItem> getByOrderId(Long orders);

    List<OrderItem> getAllOrderItem();

    Optional<OrderItem> getByOrderItemId(Long id);

    Optional<OrderItem> getByStatus(String status);

    String updateOrderItem(Long id , OrderItemResourceAshan orderItemResourceAshan);
}

