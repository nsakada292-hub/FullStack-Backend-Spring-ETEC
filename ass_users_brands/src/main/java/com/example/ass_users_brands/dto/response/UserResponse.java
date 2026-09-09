package com.example.ass_users_brands.dto.response;

import com.example.ass_users_brands.enums.Gender;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long userId;
    private String userName;
    private Gender userGender;
    private String userEmail;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
