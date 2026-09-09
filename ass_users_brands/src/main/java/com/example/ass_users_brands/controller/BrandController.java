package com.example.ass_users_brands.controller;

import com.example.ass_users_brands.dto.request.BrandRequest;
import com.example.ass_users_brands.dto.response.BrandResponse;
import com.example.ass_users_brands.dto.response.UserBrandResponse;
import com.example.ass_users_brands.repository.BrandRepository;
import com.example.ass_users_brands.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/brand")
public class BrandController {
    private final BrandRepository brandRepository;
    private final BrandService brandService;

    @PostMapping
    public BrandResponse createBrandData(@ModelAttribute BrandRequest brandRequest,@RequestParam("file") MultipartFile file)throws IOException{
        return brandService.createBrandData(brandRequest, file);
    }

    @GetMapping
    public List<BrandResponse> getBrandData(){
        return brandService.getBrandData();
    }

    @DeleteMapping("/{brandId}")
    public void deleteBrandData(@PathVariable Long brandId){
        brandService.deleteBrandData(brandId);
    }

    @PutMapping("/{brandId}")
    public BrandResponse updateBrandData(@PathVariable Long brandId,@ModelAttribute BrandRequest brandRequest, @RequestParam("file") MultipartFile file)throws IOException{
        return brandService.updateBrandData(brandId, brandRequest, file);
    }

    @GetMapping("/{userId}/count")
    public long countBrandsByUser(@PathVariable Long userId){
        return brandService.countBrandsByUser(userId);
    }

    @GetMapping("/{userId}/brands")
    public UserBrandResponse getBrandsByUser(@PathVariable Long userId){
        return brandService.getBrandsByUser(userId);
    }

}
