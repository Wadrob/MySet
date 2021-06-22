package com.github.wadrob.myset.domain.service;

import com.github.wadrob.myset.domain.model.User;
import com.github.wadrob.myset.domain.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private  final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional <User> optionalUser = userRepository.findByEmail(email);
        return optionalUser
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        List.of(
                                new SimpleGrantedAuthority(user.getRole())
                        )
                ))
                .orElseThrow(()-> new UsernameNotFoundException("Email " + email + "not found" ));
    }
}
