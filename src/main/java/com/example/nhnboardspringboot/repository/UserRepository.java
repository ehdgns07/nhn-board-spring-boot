package com.example.nhnboardspringboot.repository;


import com.example.nhnboardspringboot.domain.user.UserDto;
import com.example.nhnboardspringboot.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDto findByUsername(String username);
}
