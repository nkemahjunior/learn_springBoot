package com.zeco.jwtdemo2.repository;

import com.zeco.jwtdemo2.entity.Users_01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;



public interface UserRepository_04 extends JpaRepository<Users_01, Integer> {

     Optional<Users_01> findByUsername(String username);
}
