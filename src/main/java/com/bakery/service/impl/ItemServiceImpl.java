package com.bakery.service.impl;

import com.bakery.domain.Item;
import com.bakery.repository.ItemRepository;
import com.bakery.resource.ItemResource;
import com.bakery.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Certificate Details SeviceImpl
 * ********************************************************************************************************************
 *  ###      Date             Story point       Task No        Author         Description
 *  -------------------------------------------------------------------------------------------------------------------
 *  01       08-01-2024                                        Ravindu        Created
 *
 *  *******************************************************************************************************************
 */

@Component
public class ItemServiceImpl implements ItemService {

    @Autowired
    public ItemRepository itemRepository;
@Override
    public String saveItem(ItemResource itemResource) {
        // Item item= new Item();
        return itemRepository.save(itemResource);
    }
@Override
    public List<Item> getAllItems(){
    return itemRepository.findAll();
}
@Override
    public Optional<Item> getItemByCode(String code){
    return itemRepository.findCode(code);
}
@Override
    public List<Item> getItemByCatagory(Long catagoryId){
    return itemRepository.findByCatagoryId(catagoryId);
}
@Override
    public Optional<Item> getItemById(Long id){
    return itemRepository.findById(id);
}
@Override
    public String updateItem(Long id, ItemResource itemResource){
    //get old records from the entity
    return itemRepository.save(itemResource);
}
@Override
    public Item deleteAllItem(){
    return null;
}
@Override
    public void deleteById(Long id){
    itemRepository.deleteById(id);
}
}
