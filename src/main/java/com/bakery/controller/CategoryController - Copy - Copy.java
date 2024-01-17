package com.bakery.controller;

import com.bakery.domain.Category;
import com.bakery.resource.CategoryRequest;
import com.bakery.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



/**
 * Certificate Details Domain
 *
 *******************************************************************************************************
 *  ###   Date         Story Point   Task No       Author       Description
 *------------------------------------------------------------------------------------------------------
 *    1   12-01-2024                 category-1    ashansen      Created
 *
 *******************************************************************************************************
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;   

    @PostMapping
    public String createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/code/{code}")
    public Optional<Category> getCategoryByCode(@PathVariable String code){
        return categoryService.getCategoryByCode(code);
    }


    @PutMapping("/{id}")
    public String updateCategory(@PathVariable Long id,@RequestBody Category category){
        category.setId(id);
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryById (@PathVariable Long id){
        return categoryService.deleteCategoryById(id);
    }
}
