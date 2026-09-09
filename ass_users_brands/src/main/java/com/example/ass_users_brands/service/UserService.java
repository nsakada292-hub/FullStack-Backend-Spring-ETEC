package com.example.ass_users_brands.service;

import com.example.ass_users_brands.dto.request.UserRequest;
import com.example.ass_users_brands.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getUserData();
    UserResponse createUserData(UserRequest userRequest);
    void deleteUserData(Long userId);
    UserResponse updateUserData(Long userId, UserRequest userRequest);
}
