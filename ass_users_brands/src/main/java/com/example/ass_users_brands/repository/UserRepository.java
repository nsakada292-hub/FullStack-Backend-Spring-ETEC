package com.example.ass_users_brands.repository;

import com.example.ass_users_brands.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
