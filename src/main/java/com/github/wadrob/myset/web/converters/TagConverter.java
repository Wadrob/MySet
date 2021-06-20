package com.github.wadrob.myset.web.converters;

import com.github.wadrob.myset.domain.model.Tag;
import com.github.wadrob.myset.domain.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class TagConverter implements Converter<String, Tag> {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag convert(String source) {
        return tagRepository.findById(Long.parseLong(source)).get();
    }
}
