package com.bakery.service;

import com.bakery.domain.Orders;
import com.bakery.resource.OrderResourceNimash;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/*
 * Certificate Details Service
 *
******************************************************************************************************
 ###      Date           Story Point       Task No.          Author            Description
 -----------------------------------------------------------------------------------------------------
  1    10-01-2024                                            NimashL           Created

******************************************************************************************************
*/

@Service
public interface OrderServiceNimash {

     List<Orders> getAllOrder();

     Optional<Orders> getOrderById(@PathVariable Long id);

     Optional<Orders> getOrderByReferenceCode(@PathVariable String referenceCode);

     List<Orders> getOrderByCustomerId(@PathVariable Long customerId);

     String saveOrder(@RequestBody OrderResourceNimash orderResourceNimash);

     String updateOrderById(@PathVariable Long id, @RequestBody OrderResourceNimash orderResourceNimash);

     String deleteOrderById(@PathVariable Long id);
}
