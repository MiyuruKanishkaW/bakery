package com.bakery.service;

import com.bakery.domain.Orders;
import com.bakery.resource.OrderResourceAshan;
import com.bakery.resource.UpdateOrderItemResourceAshan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderServiceAshan {


    String createOrder(OrderResourceAshan orderResourceAshan);
    List<Orders> getAllOrder();
    Optional<Orders> getOrderById(Long id);
    Optional<Orders> getOrderByReferenceCode(String referenceCode);
    List<Orders> getOrderByCustomerId(Long customer);

    String updateOrder(Long id, OrderResourceAshan orderResourceAshan);

//    String updateOrder(Long id, UpdateOrderItemResourceAshan updateOrderItemResourceAshan);

    String deleteOrderById(Long id);


}
