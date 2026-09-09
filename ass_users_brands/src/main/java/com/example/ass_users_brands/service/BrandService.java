package com.example.ass_users_brands.service;

import com.example.ass_users_brands.dto.request.BrandRequest;
import com.example.ass_users_brands.dto.request.UserRequest;
import com.example.ass_users_brands.dto.response.BrandResponse;
import com.example.ass_users_brands.dto.response.UserResponse;
import com.example.ass_users_brands.dto.response.UserBrandResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BrandService {
    List<BrandResponse> getBrandData();
    BrandResponse createBrandData(BrandRequest brandRequest, MultipartFile file)throws IOException;
    void deleteBrandData(Long brandId);
    BrandResponse updateBrandData(Long brandId, BrandRequest brandRequest, MultipartFile file)throws IOException;


//    For get brand by user and count by user
    long countBrandsByUser(Long userId);
    UserBrandResponse getBrandsByUser(Long userId);
}
