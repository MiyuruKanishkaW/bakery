package com.bakery.service.impl;

import com.bakery.domain.Customer;
import com.bakery.domain.Item;
import com.bakery.domain.OrderItem;
import com.bakery.domain.Orders;
import com.bakery.enums.CommonStatus;
import com.bakery.repository.CustomerRepository;
import com.bakery.repository.ItemRepository;
import com.bakery.repository.OrderItemRepositoryNimash;
import com.bakery.repository.OrderRepositoryNimash;
import com.bakery.resource.OrderItemResourceNimash;
import com.bakery.resource.OrderResourceNimash;
import com.bakery.service.OrderServiceNimash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

/*
 * Certificate Details ServiceImpl
 *
******************************************************************************************************
 ###      Date           Story Point       Task No.          Author            Description
 -----------------------------------------------------------------------------------------------------
  1    10-01-2024                                            NimashL           Created

******************************************************************************************************
*/

@Component
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImplNimash implements OrderServiceNimash {

    @Autowired
    private OrderRepositoryNimash orderRepositoryNimash;
    @Autowired
    private OrderItemRepositoryNimash orderItemRepositoryNimash;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Orders> getAllOrder(){
        return orderRepositoryNimash.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long id){
        Optional<Orders> order = orderRepositoryNimash.findById(id);
        if (order.isPresent()){
            List<OrderItem> orderItems = orderItemRepositoryNimash.findByOrdersId(order.get().getId());
            order.get().setOderItems(orderItems);

            return Optional.ofNullable(order.get());
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Orders> getOrderByReferenceCode(String referenceCode){
        Optional<Orders> order = orderRepositoryNimash.findByReferenceCode(referenceCode);
        if (order.isPresent()){
            List<OrderItem> orderItems = orderItemRepositoryNimash.findByOrdersId(order.get().getId());
            order.get().setOderItems(orderItems);


            return Optional.ofNullable(order.get());
        }else {
            return Optional.empty();
        }
    }

    @Override
    public List<Orders> getOrderByCustomerId(Long customerId) {
        List<Orders> orders = orderRepositoryNimash.findByCustomersId(customerId);

        if (orders.isEmpty()) {
            return null;
        } else {
            List<Orders> ordersWithItems = new ArrayList<>();

            for (Orders order : orders) {
                List<OrderItem> orderItems = orderItemRepositoryNimash.findByOrdersId(order.getId());

                if (orderItems != null && !orderItems.isEmpty()) {
                    order.setOderItems(orderItems);
                }
                ordersWithItems.add(order);
            }
            return ordersWithItems;
        }
    }

    @Override
    public String saveOrder( OrderResourceNimash orderResourceNimash){
        Optional<Customer> getCustomerId = customerRepository.findById(orderResourceNimash.getCustomerId());
        if(getCustomerId.isPresent()) {
            Orders order = new Orders();

            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            java.sql.Timestamp currentTimestamp = new  java.sql.Timestamp(now.getTime());

            order.setReferenceCode(orderResourceNimash.getReferenceCode());
            order.setDescription(orderResourceNimash.getDescription());
            order.setStatus(orderResourceNimash.getStatus());
            order.setCreatedDate(currentTimestamp);
            order.setCreatedUser(orderResourceNimash.getCreatedUser());
            order.setModifiedDate(orderResourceNimash.getModifiedDate());
            order.setModifiedUser(orderResourceNimash.getModifiedUser());
            order.setCustomers(getCustomerId.get());

            Orders saveOrder = orderRepositoryNimash.save(order);

            List<OrderItemResourceNimash> newOrderItem = orderResourceNimash.getOderItems();
            if (newOrderItem.isEmpty()){
                return "order items empty.";
            }else {
                for (OrderItemResourceNimash orderItemList: newOrderItem){
                    Optional<Item> getItem = itemRepository.findById(orderItemList.getItemId());

                    OrderItem saveOrderItem = new OrderItem();

                    saveOrderItem.setItem(getItem.get());
                    saveOrderItem.setOrders(saveOrder);
                    saveOrderItem.setStatus(orderItemList.getStatus());
                    saveOrderItem.setCreatedDate(currentTimestamp);
                    saveOrderItem.setCreatedUser(orderItemList.getCreatedUser());
                    saveOrderItem.setModifiedDate(orderItemList.getModifiedDate());
                    saveOrderItem.setModifiedUser(orderItemList.getModifiedUser());

                    orderItemRepositoryNimash.save(saveOrderItem);

                }
                return "record saved successfully.";
            }

        }else{
            return "customer id not found.";
        }
    }

    @Override
    public String updateOrderById( Long id,  OrderResourceNimash orderResourceNimash){
        Optional<Orders> existingOrder = orderRepositoryNimash.findById(id);
        if (existingOrder.isPresent()){
            Orders order = existingOrder.get();

         //set date and time automatically
            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            java.sql.Timestamp currentTimestamp = new  java.sql.Timestamp(now.getTime());

            order.setDescription(orderResourceNimash.getDescription());
            order.setStatus(orderResourceNimash.getStatus());
            order.setModifiedDate(currentTimestamp);
            order.setModifiedUser(orderResourceNimash.getModifiedUser());

            String newModifiedUser =  order.getModifiedUser();

            String newStatus = order.getStatus();

            if (newStatus.equals("Canceled") || newStatus.equals("Completed")){
                List<OrderItem> items = orderItemRepositoryNimash.findByOrdersId(id);
                if (items != null) {
                    for (OrderItem item : items) {
                        item.setStatus(CommonStatus.INACTIVE.toString());
                        item.setModifiedDate(currentTimestamp);
                        item.setModifiedUser(newModifiedUser);

                        orderRepositoryNimash.save(order);
                    }
                }
            }
            return "record updated successfully.";
        }else {
            return "record not found.";
        }
    }

    @Override
    public String deleteOrderById( Long id){
        Optional<Orders> order = orderRepositoryNimash.findById(id);
        if (order.isPresent()){
            orderRepositoryNimash.deleteById(id);
            return "record deleted successfully,";
        }else {
            return "record not found.";
        }
    }
}
