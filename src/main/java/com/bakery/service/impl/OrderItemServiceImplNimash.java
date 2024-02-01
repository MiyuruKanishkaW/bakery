//package com.bakery.service.impl;
//
//import com.bakery.domain.Customer;
//import com.bakery.domain.OrderItem;
//import com.bakery.service.OrderItemServiceNimash;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
///*
// * Certificate Details ServiceImpl
// *
//******************************************************************************************************
// ###      Date           Story Point       Task No.          Author            Description
// -----------------------------------------------------------------------------------------------------
//  1    10-01-2024                                            NimashL           Created
//
//******************************************************************************************************
//*/
//
//@Component
//@Transactional
//public class OrderItemServiceImplNimash implements OrderItemServiceNimash {
//
//    @Autowired
//    private OrderItemRepositoryNimash orderItemRepositoryNimash;
//
//    public List<OrderItem> getAllOderItem(){
//        return orderItemRepositoryNimash.findAll();
//
//    }
//    public Optional<OrderItem> getOrderItemById(Long id){
//        Optional<OrderItem> orderItem = orderItemRepositoryNimash.findById(id);
//
//    }
//    public Optional<Customer> getOrderItemByOderId(){
//
//    }
//    public String updateOderItem(Long id, OrderItemResourceNimash orderItemResource){
//        Optional<OrderItem> existingItem = orderItemRepositoryNimash.findById(id);
//        if(existingItem.isPresent()){
//            OrderItem orderItem = existingItem.get();
//            orderItem.setStatus(orderItemResource.getClass());
//            orderItem.setCreatedUser(orderItemResource.);
//        }
//
//    }
//    public String deleteOderItem(Long id){
//
//    }
//}
