package com.github.wadrob.myset.domain.repository;

import com.github.wadrob.myset.domain.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
