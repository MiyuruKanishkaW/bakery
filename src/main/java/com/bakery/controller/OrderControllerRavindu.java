package com.bakery.controller;

import com.bakery.domain.Orders;
import com.bakery.resource.OrderResurceRaivndu;
import com.bakery.resource.UpdateResourceRavindu;
import com.bakery.service.OrderServiceRavindu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value= "api/orders")
@CrossOrigin(value = "*")
@RestController
public class OrderControllerRavindu {

    @Autowired
    public OrderServiceRavindu orderServiceRavindu;
    @PostMapping(value= "create")
    public String saveOrder(@RequestBody OrderResurceRaivndu orderResurceRaivndu){
        return orderServiceRavindu.saveOrder(orderResurceRaivndu);
    }
    @GetMapping(value= "get/order")
    public List<Orders> getAllOder(){
        return orderServiceRavindu.getAllOrder();
    }
    @GetMapping(value = "get/order/referenceCode/{referenceCode}")
    public Optional<Orders> getByReferenceCode(@PathVariable String referenceCode){
        return orderServiceRavindu.getByReferenceCode(referenceCode);
    }
    @GetMapping(value = "get/order/customers/{customers}")
    public List<Orders> getByCustomerId(@PathVariable Long customers){
        return orderServiceRavindu.getByCustomer(customers);
    }
    @GetMapping(value= "get/order/{id}")
    public Optional<Orders> getByOrderById(@PathVariable Long id){
        return orderServiceRavindu.getOrderById(id);
    }
    @PutMapping(value= "update/order/{id}")
    public String updateOrder(@PathVariable Long id, @RequestBody UpdateResourceRavindu updateResourceRavindu){
        return orderServiceRavindu.updateOrder(id, updateResourceRavindu);
    }
    @DeleteMapping(value= "delete/{id}")
    public Orders deleteOrderById(@PathVariable Long id){
        return orderServiceRavindu.deleteById(id);
    }
    @DeleteMapping(value= "delete")
    public void deleteOrder(){
        orderServiceRavindu.deleteAllOrder();

    }

}
