package com.zeco.jwtdemo2.service;

import com.zeco.jwtdemo2.repository.UserRepository_04;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl_05 implements UserDetailsService {

    private final UserRepository_04 userRepository;

    public UserDetailsServiceImpl_05(UserRepository_04 userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return  userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Users_01 not found"));
    }
}



