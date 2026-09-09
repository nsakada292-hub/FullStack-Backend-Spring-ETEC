package com.example.crud_api_spring.Repository;

import com.example.crud_api_spring.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
