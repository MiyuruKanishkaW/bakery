package com.bakery.service.impl;

import com.bakery.domain.Item;
import com.bakery.domain.OrderItem;
import com.bakery.domain.Orders;
import com.bakery.repository.ItemRepository;
import com.bakery.repository.OrderItemRepositoryNimash;
import com.bakery.resource.OrderItemResourceNimash;
import com.bakery.service.OrderItemServiceNimash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
public class OrderItemServiceImplNimash implements OrderItemServiceNimash {

    @Autowired
    private OrderItemRepositoryNimash orderItemRepositoryNimash;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<OrderItem> getAllOderItem(){
        return orderItemRepositoryNimash.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItemById( Long id){
        Optional<OrderItem> orderItem = orderItemRepositoryNimash.findById(id);
        if (orderItem.isPresent()){
            return Optional.ofNullable(orderItem.get());
        }else {
            return Optional.empty();
        }
    }

    @Override
    public List<OrderItem> getOrderItemByOderId( Long orderId){
        return orderItemRepositoryNimash.findByOrdersId(orderId);
    }

    @Override
    public String updateOderItem( Long id,  OrderItemResourceNimash orderItemResourceNimash){
        OrderItem existingOrderItem = orderItemRepositoryNimash.findById(id).get();

        if(existingOrderItem!=null) {

            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            java.sql.Timestamp currentTimestamp = new  java.sql.Timestamp(now.getTime());

            existingOrderItem.setStatus("INACTIVE");
            existingOrderItem.setModifiedDate(currentTimestamp);

            orderItemRepositoryNimash.save(existingOrderItem);

            OrderItem newOrderItem = new OrderItem();

            Orders existingOrder = existingOrderItem.getOrders();
            Item existingItem = itemRepository.findById(orderItemResourceNimash.getItemId()).get();

            newOrderItem.setOrders(existingOrder);
            newOrderItem.setItem(existingItem);
            newOrderItem.setStatus(orderItemResourceNimash.getStatus());
            newOrderItem.setCreatedDate(currentTimestamp);
            newOrderItem.setCreatedUser(orderItemResourceNimash.getCreatedUser());
            newOrderItem.setModifiedDate(orderItemResourceNimash.getModifiedDate());
            newOrderItem.setModifiedUser(orderItemResourceNimash.getModifiedUser());

            orderItemRepositoryNimash.save(newOrderItem);

        }else{
            return "Order Item Not Found";
        }
        return "Order Item Successfully Updated";
    }

    @Override
    public String deleteOderItem( Long id){
        Optional<OrderItem> orderItem = orderItemRepositoryNimash.findById(id);
        if (orderItem.isPresent()){
            orderItemRepositoryNimash.deleteById(id);
            return "record deleted successfully.";
        }else {
            return "record not found.";
        }
    }
}
