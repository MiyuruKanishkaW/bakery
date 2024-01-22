package com.bakery.repository;

import com.bakery.domain.Item;
import com.bakery.resource.ItemResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByCode(String code);
    List<Item> findByCategoryId(Long category);
}
