package com.example.ass_users_brands.service;

import com.example.ass_users_brands.dto.request.BrandRequest;
import com.example.ass_users_brands.dto.request.UserRequest;
import com.example.ass_users_brands.dto.response.BrandResponse;
import com.example.ass_users_brands.dto.response.UserBrandResponse;
import com.example.ass_users_brands.dto.response.UserResponse;
import com.example.ass_users_brands.entity.Brand;
import com.example.ass_users_brands.entity.User;
import com.example.ass_users_brands.exception.BrandInfoNotFound;
import com.example.ass_users_brands.exception.UserInfoNotFound;
import com.example.ass_users_brands.repository.BrandRepository;
import com.example.ass_users_brands.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService{
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;

    @Override
    public BrandResponse createBrandData(BrandRequest brandRequest, MultipartFile file)throws IOException {
        User user = userRepository.findById(brandRequest.getUserId())
                .orElseThrow(() -> new UserInfoNotFound("User Not Found! Please Check Your User ID Again."));

        String fileName = file.getOriginalFilename();
        String fileUrl = UUID.randomUUID().toString() + "_" + fileName;
        Path path = Paths.get("uploads");
        String imageUrl = "http://localhost:8080/uploads/"+fileUrl;
        if (!Files.exists(path)){
            Files.createDirectories(path);
        }
        Files.copy(file.getInputStream(),path.resolve(fileUrl));

        Brand brand = new Brand();
        brand.setBrandName(brandRequest.getBrandName());
        brand.setBrandImage(imageUrl);
        brand.setUser(user);
        brand.setCreateAt(LocalDateTime.now());   // createAt
        brand.setUpdateAt(LocalDateTime.now());   // updateAt
        brand= brandRepository.save(brand);

        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setBrandId(brand.getBrandId());
        brandResponse.setBrandName(brand.getBrandName());
        brandResponse.setBrandImage(brand.getBrandImage());
        brandResponse.setCreateAt(brand.getCreateAt()); // should still work since `user` is same reference
        brandResponse.setUpdateAt(brand.getUpdateAt());

        brandResponse.setUserId(user.getUserId());

        return brandResponse;
    }

    @Override
    public List<BrandResponse> getBrandData() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandResponse> brandResponses = new ArrayList<>();
        for (Brand brand : brands) {
            BrandResponse brandResponse = new BrandResponse();
            brandResponse.setBrandId(brand.getBrandId());
            brandResponse.setBrandName(brand.getBrandName());
            brandResponse.setBrandImage(brand.getBrandImage());
            brandResponse.setUserId(brand.getUser().getUserId());
            brandResponse.setCreateAt(brand.getCreateAt()); // should still work since `user` is same reference
            brandResponse.setUpdateAt(brand.getUpdateAt());

            brandResponses.add(brandResponse);
        }

        return brandResponses;
    }

    @Override
    public void deleteBrandData(Long brandId) {
        brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandInfoNotFound("Brand Not Found! PLease Check Your Brand ID Again."));

        brandRepository.deleteById(brandId);
    }

    @Override
    public BrandResponse updateBrandData(Long brandId, BrandRequest brandRequest, MultipartFile file)throws IOException{
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandInfoNotFound("Brand Not Found! PLease Check Your Brand ID Again."));
        User user = userRepository.findById(brandRequest.getUserId())
                .orElseThrow(() -> new UserInfoNotFound("User Not Found! Please Check Your User ID Again."));

        String fileName = file.getOriginalFilename();
        String fileUrl = UUID.randomUUID().toString() + "_" + fileName;
        Path path = Paths.get("uploads");
        String imageUrl = "http://localhost:8080/uploads/"+fileUrl;

        Files.copy(file.getInputStream(),path.resolve(fileUrl));

//        Brand brand = new Brand();
        brand.setBrandName(brandRequest.getBrandName());
        brand.setBrandImage(imageUrl);
        brand.setUser(user);
        brand.setCreateAt(LocalDateTime.now());   // createAt
        brand.setUpdateAt(LocalDateTime.now());   // updateAt
        brand= brandRepository.save(brand);

        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setBrandId(brand.getBrandId());
        brandResponse.setBrandName(brand.getBrandName());
        brandResponse.setBrandImage(brand.getBrandImage());
        brandResponse.setCreateAt(brand.getCreateAt()); // should still work since `user` is same reference
        brandResponse.setUpdateAt(brand.getUpdateAt());

        brandResponse.setUserId(user.getUserId());

        return brandResponse;
    }


//    Get Brand by User and Count Brand by User !!!

    @Override
    public long countBrandsByUser(Long userId) {
        return brandRepository.countByUser_UserId(userId);
    }

    @Override
    public UserBrandResponse getBrandsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        List<Brand> brands = brandRepository.findByUser_UserId(userId);

        List<BrandResponse> brandResponses = new ArrayList<>();
        for (Brand brand : brands) {
            BrandResponse brandResponse = new BrandResponse();
            brandResponse.setBrandId(brand.getBrandId());
            brandResponse.setBrandName(brand.getBrandName());
            brandResponse.setBrandImage(brand.getBrandImage());
            brandResponse.setCreateAt(brand.getCreateAt());
            brandResponse.setUpdateAt(brand.getUpdateAt());
            brandResponse.setUserId(brand.getUser().getUserId());
            brandResponses.add(brandResponse);
        }

        return new UserBrandResponse(
                user.getUserId(),
                user.getUserName(), // adjust getter to match your User entity
                brandResponses
        );
    }

}
