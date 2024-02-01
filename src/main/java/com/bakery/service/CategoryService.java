package com.bakery.service;

import com.bakery.domain.Category;
import com.bakery.resource.CategoryRequest;
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
@Service
public interface CategoryService {
    public String createCategory(CategoryRequest categoryRequest);

    public List<Category> getAllCategory();

    public Optional<Category> getCategoryById(Long id);

    public Optional<Category> getCategoryByCode(String code);

    public String updateCategory(Long id,Category category);

    public String deleteCategoryById(Long id);
}
