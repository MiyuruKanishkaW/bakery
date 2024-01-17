package com.bakery.service;

import com.bakery.domain.Item;
import com.bakery.resource.ItemResource;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    String saveItem(ItemResource itemResource);
    List<Item> getAllItems();
    Optional<Item> getItemByCode(String code);
    List<Item> getItemByCatagory(Long Catagory);
    Optional<Item> getItemById(Long id);
    String updateItem(Long id, ItemResource itemResource);
    Item deleteAllItem();
    void deleteById(Long id);

}
