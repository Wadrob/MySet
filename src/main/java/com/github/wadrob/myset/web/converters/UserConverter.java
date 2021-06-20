package com.github.wadrob.myset.web.converters;

import com.github.wadrob.myset.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import com.github.wadrob.myset.domain.model.User;

public class UserConverter implements Converter<String, User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String source) {
        return userRepository.findById(Long.parseLong(source)).get();
    }
}
