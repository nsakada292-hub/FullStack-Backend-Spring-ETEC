package com.example.ass_users_brands.service;

import com.example.ass_users_brands.dto.request.UserRequest;
import com.example.ass_users_brands.dto.response.UserResponse;
import com.example.ass_users_brands.entity.User;
import com.example.ass_users_brands.exception.UserInfoNotFound;
import com.example.ass_users_brands.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getUserData() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setUserId(user.getUserId());
            userResponse.setUserName(user.getUserName());
            userResponse.setUserGender(user.getUserGender());
            userResponse.setUserEmail(user.getUserEmail());
            userResponse.setCreateAt(user.getCreateAt()); // should still work since `user` is same reference
            userResponse.setUpdateAt(user.getUpdateAt());

            userResponses.add(userResponse);
        }

        return userResponses;
    }

    @Override
    public UserResponse createUserData(UserRequest userRequest){
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setUserEmail(userRequest.getUserEmail());
        user.setUserGender(userRequest.getUserGender());
        user = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserName(user.getUserName());
        userResponse.setUserGender(user.getUserGender());
        userResponse.setUserEmail(user.getUserEmail());
        userResponse.setCreateAt(user.getCreateAt()); // should still work since `user` is same reference
        userResponse.setUpdateAt(user.getUpdateAt());

        return userResponse;
    }

    @Override
    public void deleteUserData(Long userId) {
        User user1 = userRepository.findById(userId)
                        .orElseThrow(() -> new UserInfoNotFound("User Not Found! PLease Check Your User ID Again."));

        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse updateUserData(Long userId, UserRequest userRequest){
        User user1 = userRepository.findById(userId)
                .orElseThrow(() -> new UserInfoNotFound("User Not Found! PLease Check Your User ID Again."));

        user1.setUserName(userRequest.getUserName());
        user1.setUserEmail(userRequest.getUserEmail());
        user1.setUserGender(userRequest.getUserGender());
        user1.setUpdateAt(LocalDateTime.now());  // updateAt
        user1= userRepository.save(user1);

        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user1.getUserId());
        userResponse.setUserName(user1.getUserName());
        userResponse.setUserGender(user1.getUserGender());
        userResponse.setUserEmail(user1.getUserEmail());
        userResponse.setCreateAt(user1.getCreateAt()); // should still work since `user` is same reference
        userResponse.setUpdateAt(user1.getUpdateAt());

        return userResponse;
    }
}

