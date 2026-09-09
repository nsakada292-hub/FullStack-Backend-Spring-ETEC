package com.example.ass_users_brands.repository;

import com.example.ass_users_brands.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByUser_UserId(Long userId);

    long countByUser_UserId(Long userId);
}
