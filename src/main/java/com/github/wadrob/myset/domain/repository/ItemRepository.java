package com.github.wadrob.myset.domain.repository;

import com.github.wadrob.myset.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Override
    List<Item> findAll();

    @Override
    Item save(Item item);

    @Override
    Optional<Item> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
