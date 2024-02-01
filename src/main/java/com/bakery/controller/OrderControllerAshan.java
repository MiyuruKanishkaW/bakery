package com.bakery.controller;

import com.bakery.domain.Orders;
import com.bakery.resource.OrderResourceAshan;
import com.bakery.resource.UpdateOrderItemResourceAshan;
import com.bakery.service.OrderServiceAshan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/orders")
public class OrderControllerAshan {

    @Autowired
    private OrderServiceAshan orderServiceAshan;

    @PostMapping
    public String createOrder(@RequestBody OrderResourceAshan orderResourceAshan){
        return orderServiceAshan.createOrder(orderResourceAshan);
    }

    @GetMapping
    public List<Orders> getAllOrder(){
        return orderServiceAshan.getAllOrder();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOrderById(@PathVariable Long id){
        return orderServiceAshan.getOrderById(id);
    }

    @GetMapping("/referenceCode/{referenceCode}")
    public Optional<Orders> getOrderByReferenceCode(@PathVariable String referenceCode){
        return orderServiceAshan.getOrderByReferenceCode(referenceCode);
    }

    @GetMapping("/customer/{customer}")
    public List<Orders> getOrderByCustomerId(@PathVariable Long customer){
        return orderServiceAshan.getOrderByCustomerId(customer);
    }

    @PutMapping("/{id}")
    public String updateOrder(@PathVariable Long id, @RequestBody OrderResourceAshan orderResourceAshan){
        orderResourceAshan.setOrderId(id);
        return orderServiceAshan.updateOrder(id, orderResourceAshan);
    }


//    @PutMapping("/{id}")
//    public String updateOrder(@PathVariable Long id,@RequestBody UpdateOrderItemResourceAshan updateOrderItemResourceAshan){
//        updateOrderItemResourceAshan.setOrderId(id);
//        return orderServiceAshan.updateOrder(id, updateOrderItemResourceAshan);
//    }



    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable Long id){
        return orderServiceAshan.deleteOrderById(id);
    }

}
