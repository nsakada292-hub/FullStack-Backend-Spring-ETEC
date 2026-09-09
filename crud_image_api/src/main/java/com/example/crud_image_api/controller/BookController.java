package com.example.crud_image_api.controller;

import com.example.crud_image_api.dto.request.BookRequest;
import com.example.crud_image_api.dto.response.ApiResponse;
import com.example.crud_image_api.dto.response.BookResponse;
import com.example.crud_image_api.entity.Book;
import com.example.crud_image_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

//    @GetMapping
//    public String index(){
//        return "Helloooooooooooo";
//    }

    @PostMapping
    public BookResponse create(@ModelAttribute BookRequest bookRequest,@RequestParam("file") MultipartFile file)throws IOException{
        return bookService.create(bookRequest, file);
    }

//    @GetMapping
//    public List<BookResponse> read(){
//        return bookService.read();
//    }

    @GetMapping
    public ApiResponse<List<BookResponse>> read(){
        return new ApiResponse<>("Get Data Sucessfully!", 200, bookService.read());
    }

    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable Long id){
        bookService.deleteData(id);
    }

    @PutMapping("/{id}")
    public BookResponse update(@ModelAttribute BookRequest bookRequest,@RequestParam("file") MultipartFile file,@PathVariable Long id)throws IOException{
        return bookService.update(bookRequest, file, id);
    }
}
