package com.bakery.service.impl;

import com.bakery.domain.Category;
import com.bakery.domain.Item;
import com.bakery.repository.CategoryRepository;
import com.bakery.repository.ItemRepository;
import com.bakery.resource.ItemResource;
import com.bakery.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    public ItemRepository itemRepository;
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public String saveItem(ItemResource itemResource) {
        Item item = new Item();
        Optional<Category> existingCategory = categoryRepository.findById(itemResource.getCategory());
        if (existingCategory.isPresent()) {
            Optional<Item> existingCode=  itemRepository.findByCode(itemResource.getCode());
            if(existingCode.isPresent()) {
            }else{
                return "Code is dublecated";
            }

                item.setCategory(existingCategory.get());
                item.setCade(itemResource.getCode());
                item.setName(itemResource.getName());
                item.setPrice(itemResource.getPrice());
                item.setDescription(itemResource.getDescription());
                item.setDiscount(itemResource.getDiscount());
                item.setImageUrl(itemResource.getImageURL());
                item.setStatus(itemResource.getStatus());
                item.setModifiedDate(itemResource.getModifiedDate());
                item.setModifiedUser(itemResource.getModifiedUser());
                item.setCreatedDate(itemResource.getCreatedDate());
                item.setCreatedUser(itemResource.getCreatedUser());
                item.setSalePrice(itemResource.getSalePrice());

                Item saveItem = itemRepository.save(item);
                itemRepository.save(saveItem);
                // Item item= new Item();
                return "Saved successfully";

        } else {
            return "Your data unable to saved";
        }
    }

    @Override
    public List<Item> getAllItems(){
        List<Item> itemList= itemRepository.findAll();
        if(itemList.isEmpty()) {
           return null;
        }else {
            return itemRepository.findAll();
        }
    }

    @Override
    public Optional<Item> getItemByCode(String code) {
        return itemRepository.findByCode(code);
    }


    @Override
    public List<Item> getItemByCategory(Long category){
        return itemRepository.findByCategoryId(category);

    }

    @Override
    public Optional<Item> getItemById(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            return Optional.ofNullable(itemOptional.get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String updateItem(Long id, ItemResource itemResource){
        Optional<Item> existingItem= itemRepository.findById(id);
        Optional<Category> existingCategotry= categoryRepository.findById(itemResource.getCategory());
        if(existingItem.isPresent()) {
            Item newItem = new Item();

            newItem.setCade(itemResource.getCode());
            newItem.setCategory(existingCategotry.get());
            newItem.setName(itemResource.getName());
            newItem.setSalePrice(itemResource.getSalePrice());
            newItem.setPrice(itemResource.getPrice());
            newItem.setStatus(itemResource.getStatus());
            newItem.setImageUrl(itemResource.getImageURL());
            newItem.setDescription(itemResource.getDescription());
            newItem.setDiscount(itemResource.getDiscount());
            newItem.setCreatedDate(itemResource.getCreatedDate());
            newItem.setCreatedUser(itemResource.getCreatedUser());
            newItem.setModifiedDate(itemResource.getModifiedDate());
            newItem.setModifiedUser(itemResource.getModifiedUser());

            Item updateItem = itemRepository.save(newItem);
            itemRepository.save(updateItem);

            //get old records from the entity
            return "Updated successfully!";
        }else{
            return "Your data didn't updated!";
        }
    }

    @Override
    public Item deleteAllItem(){
        itemRepository.deleteAll();
        return null;
    }

    @Override
    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }
}
