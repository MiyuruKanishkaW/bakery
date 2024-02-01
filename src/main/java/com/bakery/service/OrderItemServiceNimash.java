package com.bakery.service;

import com.bakery.domain.OrderItem;
import com.bakery.resource.OrderItemResourceNimash;
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
public interface OrderItemServiceNimash {

     List<OrderItem> getAllOderItem();

     Optional<OrderItem> getOrderItemById(@PathVariable Long id);

     List<OrderItem> getOrderItemByOderId(@PathVariable Long orderId);

     String updateOderItem(@PathVariable Long id, @RequestBody OrderItemResourceNimash orderItemResourceNimash);

     String deleteOderItem(@PathVariable Long id);

}
