package com.example.security_spring.Controller;

import com.example.security_spring.DTO.Request.ProductRequest;
import com.example.security_spring.DTO.Response.ApiResponse;
import com.example.security_spring.DTO.Response.ProductResponse;
import com.example.security_spring.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/index")
    public ApiResponse<ProductResponse> create(@ModelAttribute ProductRequest productRequest,
                                               @RequestParam("file") MultipartFile file) throws IOException {

        return new ApiResponse<>(
                "created",
                201,
                productService.create(productRequest, file));
    }

}
