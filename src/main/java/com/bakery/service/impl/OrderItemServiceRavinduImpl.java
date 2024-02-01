package com.bakery.service.impl;//package com.bakery.service.impl;
//import com.bakery.domain.OrderItem;
import com.bakery.domain.Item;
import com.bakery.domain.OrderItem;
import com.bakery.enums.CommonStatus;
import com.bakery.exceptions.NoRecordFoundException;
import com.bakery.exceptions.UserNotFound;
import com.bakery.repository.ItemRepository;
import com.bakery.repository.OrderItemRepositoryRavindu;
import com.bakery.repository.OrderRepositoryRavindu;
import com.bakery.resource.OrderItemResourceRavindu;
import com.bakery.resource.UpdateOrderItemRecourceRavndu;
import com.bakery.service.OrderItemServiceRavindu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
@Service
public class OrderItemServiceRavinduImpl implements OrderItemServiceRavindu {

    @Autowired
    public OrderItemRepositoryRavindu orderItemRepositoryRavindu;
    @Autowired
    public ItemRepository itemRepository;
    @Autowired
    public OrderRepositoryRavindu orderRepositoryRavindu;
      @Override
      public String updateOrderItem(Long id, UpdateOrderItemRecourceRavndu updateOrderItemRecourceRavndu) {

          Calendar calendar= Calendar.getInstance();
          java.util.Date now= calendar.getTime();
          java.sql.Timestamp currentTimesTamp= new java.sql.Timestamp(now.getTime());

          OrderItem orderItems = orderItemRepositoryRavindu.findById(id).get();

          if(orderItems!=null){

              orderItems.setStatus(CommonStatus.INACTIVE.toString());
              orderItems.getModifiedDate(currentTimesTamp);
              orderItems.setModifiedUser(updateOrderItemRecourceRavndu.getModifiedUser());

              orderItemRepositoryRavindu.save(orderItems);

              Item getItem =itemRepository.findById(updateOrderItemRecourceRavndu.getItemId()).get();

              OrderItem newOrderItem = new OrderItem();

              newOrderItem.setItemId(getItem);
              newOrderItem.setStatus(CommonStatus.ACTIVE.toString());
              newOrderItem.setModifiedDate(currentTimesTamp);
              newOrderItem.setModifiedUser(updateOrderItemRecourceRavndu.getModifiedUser());
              newOrderItem.setCreatedUser(orderItems.getCreatedUser());
              newOrderItem.setCreatedDate(orderItems.getCreatedDate());
              newOrderItem.setOrderId(orderItems.getOrderId());

              orderItemRepositoryRavindu.save(newOrderItem);

              return "Updated successfully!";
          }
          throw new UserNotFound("Your customer id not found!");
      }

  }
