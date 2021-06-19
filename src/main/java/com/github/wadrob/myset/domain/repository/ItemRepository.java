package com.github.wadrob.myset.domain.repository;

import com.github.wadrob.myset.domain.model.Collection;
import com.github.wadrob.myset.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByCollection(Collection collection);

}
