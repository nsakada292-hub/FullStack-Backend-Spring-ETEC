package com.example.security_spring.Service;

import com.example.security_spring.DTO.Request.ProductRequest;
import com.example.security_spring.DTO.Response.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    ProductResponse create(ProductRequest productRequest, MultipartFile file) throws IOException;
}
