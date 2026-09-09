package com.example.security_spring.Controller;

import com.example.security_spring.DTO.Request.LoginRequest;
import com.example.security_spring.DTO.Request.RegisterRequest;
import com.example.security_spring.DTO.Response.ApiResponse;
import com.example.security_spring.DTO.Response.LoginResponse;
import com.example.security_spring.DTO.Response.UserResponse;
import com.example.security_spring.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<UserResponse> register(@RequestBody RegisterRequest registerRequest){
        return new ApiResponse<>(
                "Register Successfully!",
                201,
                authService.register(registerRequest));
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ApiResponse<>(
                "Login successfully!",
                200,
                authService.login(loginRequest)
        );
    }

}
