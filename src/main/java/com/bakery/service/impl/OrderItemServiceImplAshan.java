package com.bakery.service.impl;


import com.bakery.domain.Item;
import com.bakery.domain.OrderItem;
import com.bakery.domain.Orders;
import com.bakery.repository.ItemRepository;
import com.bakery.repository.OrderItemRepositoryAshan;
import com.bakery.resource.OrderItemResourceAshan;
import com.bakery.service.OrderItemServiceAshan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Component
@Transactional(rollbackFor = Exception.class)
public class OrderItemServiceImplAshan implements OrderItemServiceAshan {

    @Autowired
    private OrderItemRepositoryAshan orderItemRepositoryAshan;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<OrderItem> getByOrderId(Long orders) {
        return orderItemRepositoryAshan.getByOrderId(orders);
    }

    @Override
    public List<OrderItem> getAllOrderItem() {
        return orderItemRepositoryAshan.findAll();
    }

    @Override
    public Optional<OrderItem> getByOrderItemId(Long id) {
        return orderItemRepositoryAshan.findById(id);
    }

    @Override
    public Optional<OrderItem> getByStatus(String status) {
        return orderItemRepositoryAshan.getByStatus(status);
    }

    @Override
    public String updateOrderItem(Long id , OrderItemResourceAshan orderItemResourceAshan){

        OrderItem existingOrderItem = orderItemRepositoryAshan.findById(id).get();

        if(existingOrderItem!=null) {

            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());


            existingOrderItem.setStatus("INACTIVE");
            existingOrderItem.setModifiedDate(currentTimestamp);
            orderItemRepositoryAshan.save(existingOrderItem);

            OrderItem newOrderItem = new OrderItem();

            Orders existingOrder = existingOrderItem.getOrder();
            Item existingItem = itemRepository.findById(orderItemResourceAshan.getItem()).get();

            newOrderItem.setOrder(existingOrder);
            newOrderItem.setItem(existingItem);
            newOrderItem.setStatus(orderItemResourceAshan.getStatus());
            newOrderItem.setCreatedDate(currentTimestamp);
            newOrderItem.setCreatedUser(orderItemResourceAshan.getCreatedUser());
            newOrderItem.setModifiedDate(currentTimestamp);
            newOrderItem.setModifiedUser(orderItemResourceAshan.getModifiedUser());

            orderItemRepositoryAshan.save(newOrderItem);

        }else{
            return "Order Item Not Found";
        }

        return "Order Item Successfully Updated";
    }


}
