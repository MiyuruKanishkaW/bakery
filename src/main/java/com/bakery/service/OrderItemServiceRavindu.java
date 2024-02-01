package com.bakery.service;

import com.bakery.domain.OrderItem;
import com.bakery.resource.OrderItemResourceRavindu;
import com.bakery.resource.UpdateOrderItemRecourceRavndu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface OrderItemServiceRavindu {
//    String saveOrderItem(OrderItemResourceRavindu orderItemResourceRavindu);
//    List<OrderItem> getAllOrderItem();
//    Optional<OrderItem> getOrderItemByOrderId(Long id);
      String updateOrderItem(Long id, UpdateOrderItemRecourceRavndu updateOrderItemRecourceRavndu);
//
//    void deleteById(Long id);
//    OrderItem deleteAllOrderItem();

}
