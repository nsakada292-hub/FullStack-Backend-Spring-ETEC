package com.example.ass_users_brands.controller;

import com.example.ass_users_brands.dto.request.UserRequest;
import com.example.ass_users_brands.dto.response.UserResponse;
import com.example.ass_users_brands.entity.User;
import com.example.ass_users_brands.repository.UserRepository;
import com.example.ass_users_brands.service.UserService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    public List<UserResponse> getUserData(){
        return userService.getUserData();
    }
    @PostMapping
    public UserResponse createUserData(@RequestBody UserRequest userRequest){
        return userService.createUserData(userRequest);
    }
    @DeleteMapping("/{userId}")
    public void deleteUserData(@PathVariable Long userId){
        userService.deleteUserData(userId);
    }
    @PutMapping("/{userId}")
    public UserResponse updateUserData(@PathVariable Long userId, @RequestBody UserRequest userRequest){
        return userService.updateUserData(userId, userRequest);
    }

}
