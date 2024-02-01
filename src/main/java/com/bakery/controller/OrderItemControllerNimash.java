package com.bakery.controller;

import com.bakery.domain.OrderItem;
import com.bakery.resource.OrderItemResourceNimash;
import com.bakery.service.OrderItemServiceNimash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/orderitem-nimash")
public class OrderItemControllerNimash {

    @Autowired
    private OrderItemServiceNimash orderItemServiceNimash;

    @GetMapping("/all")
    List<OrderItem> getAllOderItem(){
        return orderItemServiceNimash.getAllOderItem();
    }

    @GetMapping("/{id}")
    Optional<OrderItem> getOrderItemById(@PathVariable Long id){
        return orderItemServiceNimash.getOrderItemById(id);
    }

    @GetMapping("/orderId/{orderId}")
    List<OrderItem> getOrderItemByOderId(@PathVariable Long orderId){
        return orderItemServiceNimash.getOrderItemByOderId(orderId);
    }

    @PutMapping("/{id}")
    String updateOderItem(@PathVariable Long id, @RequestBody OrderItemResourceNimash orderItemResourceNimash){
        return orderItemServiceNimash.updateOderItem(id, orderItemResourceNimash);
    }

    @DeleteMapping("/{id}")
    String deleteOderItem(@PathVariable Long id){
        return orderItemServiceNimash.deleteOderItem(id);
    }
}
