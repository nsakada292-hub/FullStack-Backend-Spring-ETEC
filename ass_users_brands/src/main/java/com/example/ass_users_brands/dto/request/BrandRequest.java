package com.example.ass_users_brands.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BrandRequest {
    private String brandName;
    private String brandImage;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private Long userId;
}
