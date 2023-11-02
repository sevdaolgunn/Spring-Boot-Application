package com.example.enoca6.controller;

import com.example.enoca6.dto.request.CreateBookRequest;
import com.example.enoca6.dto.request.UpdateBookRequest;
import com.example.enoca6.dto.response.BookListResponse;
import com.example.enoca6.dto.response.BookResponse;
import com.example.enoca6.dto.response.GenericResponse;
import com.example.enoca6.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("/createBook")
    public BookResponse createBook(@RequestBody CreateBookRequest request){
       return bookService.createBook(request);
    }

    @GetMapping("/{bookId}")
    public BookResponse getById(@PathVariable Long bookId){
        return bookService.getById(bookId);
    }

    @GetMapping("/getAllBook")
    public BookListResponse getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping("/getBooksOfAuthor/{authorId}")
    public BookListResponse getBooksByAuthorId(@PathVariable Long authorId){
        return bookService.getBooksByAuthorId(authorId);
    }

    @PutMapping("/update/{bookId}")
    public GenericResponse updateBookById(@PathVariable Long bookId,
                                          @RequestBody UpdateBookRequest request){
        return bookService.updateBookById(bookId,request);
    }
    @DeleteMapping("/delete/{bookId}")
    public GenericResponse deleteBook(@PathVariable Long bookId){
        return bookService.deleteBook(bookId);
    }


}
