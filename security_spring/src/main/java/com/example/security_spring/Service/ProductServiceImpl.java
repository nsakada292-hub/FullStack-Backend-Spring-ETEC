package com.example.security_spring.Service;

import com.example.security_spring.DTO.Request.ProductRequest;
import com.example.security_spring.DTO.Response.ProductResponse;
import com.example.security_spring.Entity.Product;
import com.example.security_spring.Entity.User;
import com.example.security_spring.Exception.NotFoundException;
import com.example.security_spring.Repository.ProductRepository;
import com.example.security_spring.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public ProductResponse create(ProductRequest productRequest, MultipartFile file) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found"));

        String fileName = file.getOriginalFilename();
        String fileUrl = UUID.randomUUID().toString() + "-" + fileName;

        Path path = Paths.get("pheaktra");
        String imageUrl = "http://localhost:8080/pheaktra/" + fileUrl;

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        Files.copy(file.getInputStream(), path.resolve(fileUrl));

        Product product = Product.builder()
                .proName(productRequest.getProName())
                .price(productRequest.getPrice())
                .qty(productRequest.getQty())
                .image(imageUrl)
                .user(user)
                .build();

        product = productRepository.save(product);

        return ProductResponse.builder()
                .id(product.getId())
                .proName(product.getProName())
                .price(product.getPrice())
                .qty(product.getQty())
                .image(product.getImage())
                .admin_name(user.getName())
                .build();
    }
}
