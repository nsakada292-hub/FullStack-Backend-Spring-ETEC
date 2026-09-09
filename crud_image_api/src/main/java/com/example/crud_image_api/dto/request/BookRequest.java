package com.example.crud_image_api.dto.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private String category;
    private Double price;
    private String image;
}
