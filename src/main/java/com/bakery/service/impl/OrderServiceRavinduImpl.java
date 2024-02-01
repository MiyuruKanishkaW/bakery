package com.bakery.service.impl;

import com.bakery.domain.Customer;
import com.bakery.domain.Item;
import com.bakery.domain.Orders;
import com.bakery.domain.OrderItem;
import com.bakery.enums.CommonStatus;
import com.bakery.exceptions.NoRecordFoundException;
import com.bakery.exceptions.UserNotFound;
import com.bakery.repository.CustomerRepository;
import com.bakery.repository.ItemRepository;
import com.bakery.repository.OrderItemRepositoryRavindu;
import com.bakery.repository.OrderRepositoryRavindu;
import com.bakery.resource.OrderItemResourceRavindu;
import com.bakery.resource.OrderResurceRaivndu;
import com.bakery.resource.UpdateResourceRavindu;
import com.bakery.service.OrderServiceRavindu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceRavinduImpl implements OrderServiceRavindu {

    @Autowired
    public OrderRepositoryRavindu orderRepositoryRavindu;
    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public OrderItemRepositoryRavindu orderItemRepositoryRavindu;
    @Autowired
    public ItemRepository itemRepository;


    @Override
    public String saveOrder(OrderResurceRaivndu orderResourceRavindu) {

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

        Orders order = new Orders();
        Optional<Customer> existingCustomer= customerRepository.findById(orderResourceRavindu.getCustomers());

        if(existingCustomer.isPresent()) {

            order.setReferenceCode(orderResourceRavindu.getReferenceCode());
            order.setStatus(orderResourceRavindu.getStatus());
            order.setModifiedUser(orderResourceRavindu.getModifiedUser());
            order.setDescription(orderResourceRavindu.getDescription());
            order.setModifiedDate(currentTimestamp);
            order.setCreatedUser(orderResourceRavindu.getCreatedUser());
            order.setCreatedDate(currentTimestamp);
            order.setCustomers(existingCustomer.get());

            Orders save = orderRepositoryRavindu.save(order);

            List<OrderItemResourceRavindu> orderItem= orderResourceRavindu.getOrderItems();
            if(orderItem !=null){

                for(OrderItemResourceRavindu itemResourceRavindu:orderItem) {

                    Optional<Item> getItemId= itemRepository.findById(itemResourceRavindu.getItemId());

                    if(getItemId.isPresent()) {

                        OrderItem getItem = new OrderItem();

                        getItem.setStatus(itemResourceRavindu.getStatus());
                        getItem.setCreatedDate(currentTimestamp);
                        getItem.setCreatedUser(itemResourceRavindu.getCreatedUser());
                        getItem.setModifiedDate(currentTimestamp);
                        getItem.setModifiedUser(itemResourceRavindu.getModifiedUser());
                        getItem.setOrderId(save);
                        getItem.setItemId(getItemId.get());

                        orderItemRepositoryRavindu.save(getItem);

                        return save.getId().toString();
                    }else{
                        throw new NoRecordFoundException("Your Item id is not found! ");
                    }
                }
            }else{
                throw new NoRecordFoundException("You didn't enter any order items");

            }

            return "Your recorde successfully saved!";
        }else{
            throw new UserNotFound("Your customer id not found!");
        }

    }

    @Override
    public List<Orders> getAllOrder() {
        return orderRepositoryRavindu.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long id) {
        Optional<Orders> ordersOptional = orderRepositoryRavindu.findById(id);
        if (ordersOptional.isPresent()) {
            List<OrderItem> orderItemsList = orderItemRepositoryRavindu.findByOrderId_Id(id);
            ordersOptional.get().setOrderItems(orderItemsList);
            return ordersOptional;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Orders> getByReferenceCode(String referenceCode){
        Optional<Orders> ordersOptional = orderRepositoryRavindu.findByReferenceCode(referenceCode);
        if (ordersOptional.isPresent()){
            List<OrderItem> orderItemList = orderItemRepositoryRavindu.findByOrderId_Id(ordersOptional.get().getId());
            ordersOptional.get().setOrderItems(orderItemList);
            return ordersOptional;
        }

        return Optional.empty();
    }
    @Override
    public List<Orders> getByCustomer(Long customerId) {
        List<Orders> ordersList = orderRepositoryRavindu.findByCustomers_Id(customerId);
        List<Orders> result = new ArrayList<>();

        if (ordersList != null) {
            for (Orders orders : ordersList) {
                List<OrderItem> orderItemList = orderItemRepositoryRavindu.findByOrderId_Id(orders.getId());
                orders.setOrderItems(orderItemList);
                result.add(orders);
            }
        }
        return result.isEmpty() ? null : result;
    }
    @Override
    public String updateOrder(Long id, UpdateResourceRavindu updateResourceRavindu) {

        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(System.currentTimeMillis());

        Optional<Orders> getByIdOrder = orderRepositoryRavindu.findById(id);
        if (getByIdOrder.isPresent()) {
            Orders updateOrder = getByIdOrder.get();
            updateOrder.setStatus(updateResourceRavindu.getStatus());
            updateOrder.setModifiedDate(currentTimestamp);
            updateOrder.setModifiedUser(updateResourceRavindu.getModifiedUser());

            Orders updatedOrder = orderRepositoryRavindu.save(updateOrder);

            if (updatedOrder.getStatus().equals(CommonStatus.COMPLETED.toString()) || updatedOrder.getStatus().equals(CommonStatus.CANCELED.toString())) {
                List<OrderItem> updateStatus = orderItemRepositoryRavindu.findByOrderId_Id(id);

                if (updateStatus.isEmpty()) {
                    throw new NoRecordFoundException("Items are not available to update...");
                } else {
                    for (OrderItem item : updateStatus) {

                        item.setStatus(CommonStatus.INACTIVE.toString());
                        item.setModifiedUser(updateResourceRavindu.getModifiedUser());
                        item.setModifiedDate(currentTimestamp);

                        orderItemRepositoryRavindu.save(item);
                    }
                    return "Updated successfully!";
                }
            }
        }
        throw new NoRecordFoundException("Order not found!");

        }


    @Override
    public void deleteAllOrder() {
        orderRepositoryRavindu.deleteAll();
    }

    @Override
    public Orders deleteById(Long id) {
        orderRepositoryRavindu.deleteById(id);
        return null;
    }
}
