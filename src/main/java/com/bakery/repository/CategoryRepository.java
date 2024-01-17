package com.bakery.repository;

import com.bakery.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByCode(String code);
}
