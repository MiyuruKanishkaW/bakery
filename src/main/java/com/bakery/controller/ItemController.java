package com.bakery.controller;

import com.bakery.domain.Item;
import com.bakery.resource.ItemResource;
import com.bakery.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Certificate Details Controller
 * ********************************************************************************************************************
 *  ###      Date             Story point       Task No        Author         Description
 *  -------------------------------------------------------------------------------------------------------------------
 *  01       08-01-2024                                        Ravindu        Created
 *
 *  *******************************************************************************************************************
 */

@RestController
@RequestMapping(value = "/api/item")
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @PostMapping(value = "/create")
    public String saveItem(@RequestBody ItemResource itemResource){
        return itemService.saveItem(itemResource);
    }
    @GetMapping(value = "/all")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
    @GetMapping(value = "/code/{code}")
    public Optional<Item> getItemByCode(@PathVariable String code){
        return itemService.getItemByCode(code);
    }
    @GetMapping(value = "/category/{category}")
    public List<Item> getItemByCategory(@PathVariable Long category){
        return itemService.getItemByCategory(category);
    }
    @GetMapping(value = "/{id}")
    public Optional<Item> getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }
    @PutMapping(value = "/update/{id}")
    public String updateItem(@PathVariable Long id, @RequestBody ItemResource itemResource){

        return itemService.updateItem(id, itemResource);
    }
    @DeleteMapping(value = "/delete")
    public Item deleteAllItem(){
        return itemService.deleteAllItem();
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id){
        itemService.deleteById(id);
    }


}