package com.example.crud_api_spring.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class Product {
    @Id // Primary key (like in pdAdmin)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment (count number of id auto)
    private Long id;
    private String productName;
    private Integer qty;
    private Double price;

}
