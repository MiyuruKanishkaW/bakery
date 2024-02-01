package com.bakery.controller;

//import com.bakery.domain.Order;
import com.bakery.domain.OrderItem;
import com.bakery.resource.OrderItemResourceRavindu;
import com.bakery.resource.OrderResurceRaivndu;
import com.bakery.resource.UpdateOrderItemRecourceRavndu;
import com.bakery.service.OrderItemServiceRavindu;
import com.bakery.service.OrderServiceRavindu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "api/orderItem")
@RestController
public class OrderItemControllerRavindu {

    @Autowired
    public OrderItemServiceRavindu orderItemServiceRavindu;
      @PutMapping(value= "update/{id}")
      public String updateOrderItem(@PathVariable Long id, @RequestBody UpdateOrderItemRecourceRavndu updateOrderItemRepository){
          return orderItemServiceRavindu.updateOrderItem(id, updateOrderItemRepository);
       }

}
