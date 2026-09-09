package com.example.crud_image_api.dto.response;

import lombok.Data;

@Data
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String category;
    private Double price;
    private String image;
}
