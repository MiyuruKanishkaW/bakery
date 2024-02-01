package com.bakery.service.impl;

import com.bakery.domain.Customer;
import com.bakery.domain.Item;
import com.bakery.domain.OrderItem;
import com.bakery.domain.Orders;
import com.bakery.enums.CommonStatus;
import com.bakery.repository.CustomerRepository;
import com.bakery.repository.ItemRepository;
import com.bakery.repository.OrderItemRepositoryAshan;
import com.bakery.repository.OrderRepositoryAshan;
import com.bakery.resource.OrderItemResourceAshan;
import com.bakery.resource.OrderResourceAshan;
import com.bakery.resource.UpdateOrderItemResourceAshan;
import com.bakery.service.OrderServiceAshan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
@Component
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImplAshan implements OrderServiceAshan {

    @Autowired
    private OrderRepositoryAshan orderRepositoryAshan;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderItemRepositoryAshan orderItemRepositoryAshan;


    Calendar calendar = Calendar.getInstance();
    java.util.Date now = calendar.getTime();
    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

    @Override
    public String createOrder(OrderResourceAshan orderResourceAshan) {

        Orders orders = new Orders();

        Optional<Customer> customer = customerRepository.findById(orderResourceAshan.getCustomer());


            orders.setCustomer(customer.get());
            orders.setReferenceCode(orderResourceAshan.getReferenceCode());
            orders.setDescription(orderResourceAshan.getDescription());
            orders.setStatus(orderResourceAshan.getStatus());
            orders.setCreatedDate(currentTimestamp);
            orders.setCreatedUser(orderResourceAshan.getCreatedUser());
            orders.setModifiedDate(orderResourceAshan.getModifiedDate());
            orders.setModifiedUser(orderResourceAshan.getModifiedUser());

            Orders savedOrder= orderRepositoryAshan.save(orders);

            List <OrderItemResourceAshan> orderItem = orderResourceAshan.getOrderItems();
            if(orderItem !=null){


                for(OrderItemResourceAshan orderItemInOrderItemList:orderItem){
                    OrderItem orderItemNew=new OrderItem();

                    Item exsistingItem =itemRepository.findById(orderItemInOrderItemList.getItem()).get();

                    orderItemNew.setStatus(orderItemInOrderItemList.getStatus());
                    orderItemNew.setCreatedDate(currentTimestamp);
                    orderItemNew.setCreatedUser(orderItemInOrderItemList.getCreatedUser());
                    orderItemNew.setModifiedDate(orderItemInOrderItemList.getModifiedDate());
                    orderItemNew.setModifiedUser(orderItemInOrderItemList.getModifiedUser());
                    orderItemNew.setOrder(savedOrder);
                    orderItemNew.setItem(exsistingItem);

                    orderItemRepositoryAshan.save(orderItemNew);
                }

            }else{
                return "Not found";
            }

            return "Successfully Created";
        }


    @Override
    public List<Orders> getAllOrder(){
        return orderRepositoryAshan.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long id){
        Optional<Orders> order =orderRepositoryAshan.findById(id);
        if(order.isPresent()){
            List<OrderItem> orderItems =orderItemRepositoryAshan.getByOrderId(order.get().getId());
            if(orderItems!=null && !orderItems.isEmpty()){
                order.get().setOrderItems(orderItems);
            }
            return Optional.ofNullable(order.get());
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Orders> getOrderByReferenceCode(String referenceCode){
        Optional<Orders> order =orderRepositoryAshan.getOrderByReferenceCode(referenceCode);
        if(order.isPresent()){
            List<OrderItem> orderItems=orderItemRepositoryAshan.getByOrderId(order.get().getId());
            if(orderItems!=null && !orderItems.isEmpty()){
                order.get().setOrderItems(orderItems);
            }
            return Optional.ofNullable(order.get());
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<Orders> getOrderByCustomerId(Long customerId){
        List<Orders> orders =orderRepositoryAshan.getOrderByCustomerId(customerId);
        if(orders.isEmpty()){
            return new ArrayList<>();
        }
        List<Orders> ordersWithItems = new ArrayList<>();

        for (Orders order : orders) {
            List<OrderItem> orderItems = orderItemRepositoryAshan.getByOrderId(order.getId());
            if (orderItems != null && !orderItems.isEmpty()) {
                order.setOrderItems(orderItems);
            }
            ordersWithItems.add(order);
        }
        return ordersWithItems;
    }

    @Override
    public String updateOrder(Long id, OrderResourceAshan orderResourceAshan){

        Orders existingOrder = orderRepositoryAshan.findById(id).get();
        if(existingOrder!=null){

            existingOrder.setStatus(orderResourceAshan.getStatus());
            existingOrder.setDescription(orderResourceAshan.getDescription());
            existingOrder.setModifiedDate(currentTimestamp);
            existingOrder.setModifiedUser(orderResourceAshan.getModifiedUser());

            orderRepositoryAshan.save(existingOrder);

            String status =orderResourceAshan.getStatus();

            if(status.equals("completed") || status.equals("cancelled")){

                List<OrderItem> existingOrderItem = orderItemRepositoryAshan.getByOrderId(id);

                for(OrderItem updateOrderItem :existingOrderItem){

                updateOrderItem.setStatus(String.valueOf(CommonStatus.INACTIVE)); //orderResourceAshan.getStatus()
                updateOrderItem.setModifiedDate(currentTimestamp);
                updateOrderItem.setModifiedUser(orderResourceAshan.getModifiedUser());

                orderItemRepositoryAshan.save(updateOrderItem);

                 }
            }
        }else{
            return "Order Not found";
        }
        return "Update successfully";
    }


//    @Override
//    public String updateOrder(Long id, UpdateOrderItemResourceAshan updateOrderItemResourceAshan){
//
//
//
//    }

    @Override
    public String deleteOrderById(Long id){
        orderRepositoryAshan.deleteById(id);
        return "Successfully Deleted";
    }

}
