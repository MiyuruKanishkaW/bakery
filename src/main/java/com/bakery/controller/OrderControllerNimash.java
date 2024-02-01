package com.bakery.controller;

import com.bakery.domain.Orders;
import com.bakery.resource.OrderResourceNimash;
import com.bakery.service.OrderServiceNimash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * Certificate Details Controller
 *
******************************************************************************************************
 ###      Date           Story Point       Task No.          Author            Description
 -----------------------------------------------------------------------------------------------------
  1    23-01-2024                                            NimashL           Created

******************************************************************************************************
*/

@RestController
@RequestMapping(value = "/orders-nimash")
@CrossOrigin(origins = "*")
public class OrderControllerNimash {

    @Autowired
    private OrderServiceNimash orderServiceNimash;

    @GetMapping("/all")
    public List<Orders> getAllOrder(){
        return orderServiceNimash.getAllOrder();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOrderById(@PathVariable Long id){
        return orderServiceNimash.getOrderById(id);

    }

    @GetMapping("/referenceCode/{referenceCode}")
    public Optional<Orders> getOrderByReferenceCode(@PathVariable String referenceCode){
        return orderServiceNimash.getOrderByReferenceCode(referenceCode);

    }

    @GetMapping("/customerId/{customerId}")
    public List<Orders> getOrderByCustomerId(@PathVariable Long customerId){
        return orderServiceNimash.getOrderByCustomerId(customerId);

    }

    @PostMapping("/save")
    public String saveOrder(@RequestBody OrderResourceNimash orderResourceNimash){
        return orderServiceNimash.saveOrder(orderResourceNimash);

    }

    @PutMapping("/{id}")
    public String updateOrderById(@PathVariable Long id, @RequestBody OrderResourceNimash orderResourceNimash){
        return orderServiceNimash.updateOrderById(id,orderResourceNimash);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable Long id){
        return orderServiceNimash.deleteOrderById(id);

    }
}
