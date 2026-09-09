package com.example.security_spring.Service;

import com.example.security_spring.DTO.Request.LoginRequest;
import com.example.security_spring.DTO.Request.RegisterRequest;
import com.example.security_spring.DTO.Response.LoginResponse;
import com.example.security_spring.DTO.Response.UserResponse;


public interface AuthService {
    UserResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}