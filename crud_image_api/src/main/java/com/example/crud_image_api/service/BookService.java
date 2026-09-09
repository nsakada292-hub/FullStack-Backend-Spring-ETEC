package com.example.crud_image_api.service;

import com.example.crud_image_api.dto.request.BookRequest;
import com.example.crud_image_api.dto.response.BookResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {
    BookResponse create(BookRequest bookRequest, MultipartFile file)throws IOException;
    List<BookResponse> read();
    void deleteData(Long id);
    BookResponse update(BookRequest bookRequest, MultipartFile file, Long id)throws IOException;
}
