package com.bakery.service.impl;

import com.bakery.domain.Category;
import com.bakery.repository.CategoryRepository;
import com.bakery.resource.CategoryRequest;
import com.bakery.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


@Component
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String createCategory(CategoryRequest categoryRequest) {

        Category category =new Category();

        category.setName(categoryRequest.getName());
        category.setCode(categoryRequest.getCode());
        category.setDescription(categoryRequest.getDescription());
        category.setImageUrl(categoryRequest.getImageUrl());
        category.setStatus(categoryRequest.getStatus());
        category.setCreatedDate(categoryRequest.getCreatedDate());
        category.setCreatedUser(categoryRequest.getCreatedUser());
        category.setModifiedDate(categoryRequest.getModifiedDate());
        category.setModifiedUser(categoryRequest.getModifiedUser());

        categoryRepository.save(category);
        return "Successfully Created";
    }
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        if(category.isPresent()){
            return Optional.ofNullable(category.get());
        }else{
            return Optional.empty();
        }

    }

    @Override
    public Optional<Category> getCategoryByCode(String code){
        Optional<Category> category=categoryRepository.findByCode(code);
        if(category.isPresent()){
            return Optional.ofNullable(category.get());
        }else{
            return Optional.empty();
        }
    }


    @Override
    public String updateCategory(Long id,Category category) {

        Category excistingCategory = categoryRepository.findById(id).get();

            excistingCategory.setName(category.getName());
            excistingCategory.setCode(category.getCode());
            excistingCategory.setDescription(category.getDescription());
            excistingCategory.setImageUrl(category.getImageUrl());
            excistingCategory.setStatus(category.getStatus());
            excistingCategory.setCreatedDate(category.getCreatedDate());
            excistingCategory.setCreatedUser(category.getCreatedUser());
            excistingCategory.setModifiedDate(category.getModifiedDate());
            excistingCategory.setModifiedUser(category.getModifiedUser());

            categoryRepository.save(excistingCategory);

            return "Successfully Updated";
    }
    @Override
    public String deleteCategoryById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        if(category.isPresent()){
            categoryRepository.deleteById(id);
            return "Successfully Deleted";
        }else {
            return "Not Found";
        }
    }

}
