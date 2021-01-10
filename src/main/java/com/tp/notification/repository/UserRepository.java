package com.tp.notification.repository;

import com.tp.notification.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByActivationCode(String code);
    User findByEmail(String email);
}