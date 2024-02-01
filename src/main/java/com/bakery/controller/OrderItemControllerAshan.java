package com.bakery.controller;

import com.bakery.domain.OrderItem;
import com.bakery.resource.OrderItemResourceAshan;
import com.bakery.service.OrderItemServiceAshan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderItem")
@CrossOrigin(value = "*")
public class OrderItemControllerAshan {

    @Autowired
    private OrderItemServiceAshan orderItemServiceAshan;

    @GetMapping("/orders/{orders}")
    public List<OrderItem> getByOrderId(@PathVariable Long orders){
        return orderItemServiceAshan.getByOrderId(orders);
    }

    @GetMapping
    public List<OrderItem> getAllOrderItem(){
        return orderItemServiceAshan.getAllOrderItem();
    }

    @GetMapping("/{id}")
    public Optional<OrderItem> getByOrderItemId(@PathVariable Long id){
        return orderItemServiceAshan.getByOrderItemId(id);
    }

    @GetMapping("/status/{status}")
    public Optional<OrderItem> getByStatus(@PathVariable String status){
        return orderItemServiceAshan.getByStatus(status);
    }

    @PutMapping("/{id}")
    public String updateOrderItem(@PathVariable Long id,@RequestBody OrderItemResourceAshan orderItemResourceAshan){
        orderItemResourceAshan.setOrderItem(id);
        return orderItemServiceAshan.updateOrderItem(id,orderItemResourceAshan);
    }


}
