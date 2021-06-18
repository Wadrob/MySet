package com.github.wadrob.myset.domain.repository;

import com.github.wadrob.myset.domain.model.Collection;
import com.github.wadrob.myset.domain.model.Item;
import com.github.wadrob.myset.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

    @Override
    List<Collection> findAll();

    @Override
    Collection save(Collection collection);

    @Override
    Optional <Collection> findById(Long id);

    @Override
    void deleteById(Long id);

    List <Collection> findAllByUser(User user);

}
