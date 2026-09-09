package com.example.ass_users_brands.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBrandResponse {
    private Long userId;
    private String username; // adjust field name to match your User entity
    private List<BrandResponse> brands;
}
