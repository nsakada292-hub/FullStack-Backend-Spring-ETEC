package com.example.security_spring.Service;

import com.example.security_spring.DTO.Request.LoginRequest;
import com.example.security_spring.DTO.Request.RegisterRequest;
import com.example.security_spring.DTO.Response.LoginResponse;
import com.example.security_spring.DTO.Response.UserResponse;
import com.example.security_spring.Entity.User;
import com.example.security_spring.Exception.EmailAlreadyExists;
import com.example.security_spring.Exception.EmailAndPasswordAreNotMatch;
import com.example.security_spring.Exception.NotFoundException;
import com.example.security_spring.Repository.UserRepository;
import com.example.security_spring.Enum.Role;
import com.example.security_spring.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserResponse register(RegisterRequest registerRequest){
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new EmailAlreadyExists("Email Already Exists!");
        }

        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        user = userRepository.save(user);
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new NotFoundException("email not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new EmailAndPasswordAreNotMatch("Email and Password are not match.");
        }

        String token = jwtService.generateToken(user);

        return LoginResponse.builder()
                .token(token)
                .userResponse(
                        UserResponse.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .email(user.getEmail())
                                .password(user.getPassword())
                                .role(user.getRole())
                                .build()
                )
                .build();
    }

}
