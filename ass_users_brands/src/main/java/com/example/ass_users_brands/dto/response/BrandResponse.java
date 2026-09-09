package com.example.ass_users_brands.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BrandResponse {
    private Long brandId;
    private String brandName;
    private String brandImage;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private Long userId;

}
