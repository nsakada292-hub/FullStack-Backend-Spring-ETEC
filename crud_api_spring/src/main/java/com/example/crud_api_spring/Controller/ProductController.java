package com.example.crud_api_spring.Controller;

import com.example.crud_api_spring.Entity.Product;
import com.example.crud_api_spring.Repository.ProductRepository;
import com.example.crud_api_spring.exception.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
//    private final ProductRepository productRepository;
//    public ProductController(ProductRepository productRepository){
//        this.productRepository=productRepository;                          // brer ah nis kor ban
//    }

    @Autowired  // yk repo pi package Repository
    private ProductRepository productRepository;       // ah nis kor ban

    @GetMapping("/")
        public String index(){
        return ("Hello Spring Boot");
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/getData")
    public List<Product> getDate(){
        return productRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        productRepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        Product product1 = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product not found"));

        product1.setProductName(product.getProductName());
        product1.setQty(product.getQty());
        product1.setPrice(product.getPrice());
        return productRepository.save(product1);
    }

}
