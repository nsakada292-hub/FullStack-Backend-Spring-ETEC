package com.example.security_spring.DTO.Request;

import com.example.security_spring.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String proName;
    private Integer qty;
    private Double price;
    private String image;
    private User user;
}
