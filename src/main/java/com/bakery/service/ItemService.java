package com.bakery.service;

import com.bakery.domain.Item;
import com.bakery.resource.ItemResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ItemService {
    String saveItem(ItemResource itemResource);
    List<Item> getAllItems();
    Optional<Item> getItemByCode(String code);
    List<Item> getItemByCategory(Long category);
    Optional<Item> getItemById(Long id);
    String updateItem(Long id, ItemResource itemResource);
    Item deleteAllItem();
    void deleteById(Long id);

}
