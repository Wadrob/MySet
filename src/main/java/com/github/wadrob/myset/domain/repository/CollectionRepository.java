package com.github.wadrob.myset.domain.repository;

import com.github.wadrob.myset.domain.model.Collection;
import com.github.wadrob.myset.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

    List <Collection> findAllByUser(User user);

}
