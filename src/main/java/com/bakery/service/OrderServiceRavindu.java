package com.bakery.service;

import com.bakery.domain.Orders;
import com.bakery.resource.OrderResurceRaivndu;
import com.bakery.resource.UpdateResourceRavindu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface OrderServiceRavindu {
    String saveOrder(OrderResurceRaivndu orderResourceRavindu);
    List<Orders> getAllOrder();
    Optional<Orders> getOrderById(Long id);
    String updateOrder(Long id, UpdateResourceRavindu updateResourceRavindu);
    void deleteAllOrder();
    Orders deleteById(Long id);
    Optional<Orders> getByReferenceCode(String referenceCode);
    List<Orders> getByCustomer(Long customers);


}
