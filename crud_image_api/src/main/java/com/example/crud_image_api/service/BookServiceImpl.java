package com.example.crud_image_api.service;

import com.example.crud_image_api.dto.request.BookRequest;
import com.example.crud_image_api.dto.response.BookResponse;
import com.example.crud_image_api.entity.Book;
import com.example.crud_image_api.exception.BookInfoNotFound;
import com.example.crud_image_api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

//    ber brer file trv tea mean throw IOException always
    @Override
    public BookResponse create(BookRequest bookRequest, MultipartFile file)throws IOException {
//    Ah nis jab name file image mk
        String fileName= file.getOriginalFilename();

//    ah nis vea bomleang fileName yg tv UUID kom duplicate knea
        String fileUrl= UUID.randomUUID().toString()+"_"+fileName;

//    this create to ykk file yg tv dak knong folder uploads but ber folder ng ot mean vea ng create oy yg auto mg
        Path path= Paths.get("uploads");
        String imageUrl= "http://localhost:8080/uploads/"+fileUrl;

        if (!Files.exists(path)){
            Files.createDirectories(path);
        }

//    ah nis tver oy rub yg pel send in postman arch mer khernh or a-rch oy frontend mer khernh ban

//        move rub yg pi drive C: or D: jol knong folder bos yg
        Files.copy(file.getInputStream(),path.resolve(fileUrl));
        Book book=new Book();
        book.setImage(imageUrl);
        book.setTitle(bookRequest.getTitle());
        book.setCategory(bookRequest.getCategory());
        book.setAuthor(bookRequest.getAuthor());
        book.setPrice(bookRequest.getPrice());
        book=bookRepository.save(book);


        BookResponse bookResponse=new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setCategory(book.getCategory());
        bookResponse.setPrice(book.getPrice());
        bookResponse.setImage(book.getImage());
        return bookResponse;

    }

    @Override
    public List<BookResponse> read() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        for (Book book : books) {
            BookResponse bookResponse = new BookResponse();
            bookResponse.setId(book.getId());
            bookResponse.setTitle(book.getTitle());
            bookResponse.setAuthor(book.getAuthor());
            bookResponse.setCategory(book.getCategory());
            bookResponse.setPrice(book.getPrice());
            bookResponse.setImage(book.getImage());

//            Don't forget to add to bookResponse
            bookResponses.add(bookResponse);
        }
        return bookResponses;
    }

    @Override
    public void deleteData(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookInfoNotFound("Information Not Found! Please Check ID Again."));
        bookRepository.deleteById(id);
    }

    @Override
    public BookResponse update(BookRequest bookRequest, MultipartFile file, Long id)throws IOException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookInfoNotFound("Information Not Found! Please Check ID Again."));


//    Ah nis jab name file image mk
        String fileName= file.getOriginalFilename();

//    ah nis vea bomleang fileName yg tv UUID kom duplicate knea
        String fileUrl= UUID.randomUUID().toString()+"_"+fileName;

//    this create to ykk file yg tv dak knong folder uploads but ber folder ng ot mean vea ng create oy yg auto mg
        Path path= Paths.get("uploads");
        String imageUrl= "http://localhost:8080/uploads/"+fileUrl;

//        pel update bach sse ah nis kor ban
//        if (!Files.exists(path)){
//            Files.createDirectories(path);
//        }

//    ah nis tver oy rub yg pel send in postman arch mer khernh or a-rch oy frontend mer khernh ban

//        move rub yg pi drive C: or D: jol knong folder bos yg
        Files.copy(file.getInputStream(),path.resolve(fileUrl));
//        Book book=new Book();
        book.setImage(imageUrl);
        book.setTitle(bookRequest.getTitle());
        book.setCategory(bookRequest.getCategory());
        book.setAuthor(bookRequest.getAuthor());
        book.setPrice(bookRequest.getPrice());
        book=bookRepository.save(book);

        BookResponse bookResponse=new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setCategory(book.getCategory());
        bookResponse.setPrice(book.getPrice());
        bookResponse.setImage(book.getImage());
        return bookResponse;

    }
}
