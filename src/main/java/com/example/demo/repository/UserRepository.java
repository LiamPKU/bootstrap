package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface UserRepository extends JpaRepository<User,Long> {
    Page<User> findByNameLike(String name, Pageable pageable);
    User findByUsername(String username);
}

