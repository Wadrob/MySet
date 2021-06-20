package com.github.wadrob.myset.domain.repository;

import com.github.wadrob.myset.domain.model.Tag;
import com.github.wadrob.myset.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List <Tag> findAllByUser(User user);
}
