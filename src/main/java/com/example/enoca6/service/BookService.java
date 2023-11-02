package com.example.enoca6.service;

import com.example.enoca6.converter.BookConverter;
import com.example.enoca6.dto.BookDto;
import com.example.enoca6.dto.request.CreateBookRequest;
import com.example.enoca6.dto.request.UpdateBookRequest;
import com.example.enoca6.dto.response.BookListResponse;
import com.example.enoca6.dto.response.BookResponse;
import com.example.enoca6.dto.response.GenericResponse;
import com.example.enoca6.entity.Author;
import com.example.enoca6.entity.Book;
import com.example.enoca6.exception.GenericException;
import com.example.enoca6.repository.AuthorRepository;
import com.example.enoca6.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;
    private final AuthorRepository authorRepository;

    public BookResponse createBook(CreateBookRequest request){
        Book book =  bookRepository.save(bookConverter.convertAsEntity(request));
        Optional<Author> author = authorRepository.findById(book.getAuthorId());
        book.setAuthor(author.get());
        return BookResponse.builder()
                .book(bookConverter.convertAsDto(book))
                .statusCode(201)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    public BookResponse getById(Long bookId) {

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            return BookResponse.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .statusCode(404)
                    .build();
        }

        Book book = optionalBook.get();
        BookDto bookDto = bookConverter.convertAsDto(book);
        return BookResponse.builder()
                .book(bookDto)
                .statusCode(200)
                .httpStatus(HttpStatus.ACCEPTED)
                .build();
    }

    public BookListResponse getAllBook(){
        List<Book> bookList = bookRepository.findAll();

        if(bookList.isEmpty()){
            return BookListResponse.builder()
                    .statusCode(404)
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .build();
        }
        List<BookDto> bookDtoList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            bookDtoList.add(bookConverter.convertAsDto(book));
        }
        return BookListResponse.builder()
                .bookList(bookDtoList)
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(200)
                .build();
    }

    public GenericResponse updateBookById(Long bookId, UpdateBookRequest request){
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            return GenericResponse.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("Not found!")
                    .build();
        }
        Book book = optionalBook.get();
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setYearOfPublication(request.getYearOfPublication());
        bookRepository.save(book);

        return GenericResponse.builder()
                .message("Updated!")
                .httpStatus(HttpStatus.ACCEPTED)
                .build();
    }

    public BookListResponse getBooksByAuthorId(Long authorId){
        List<Book> bookList = bookRepository.findByAuthorId(authorId);
        if(bookList.isEmpty()){
            return BookListResponse.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .statusCode(404)
                    .build();
        }
        List<BookDto> bookDtoList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            bookDtoList.add(bookConverter.convertAsDto(book));
        }
        return BookListResponse.builder()
                .bookList(bookDtoList)
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(200)
                .build();

    }
    protected Book findById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(
                ()-> GenericException.builder()
                        .errorMessage("Böyle bir kitap bulunamadı.")
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .build());
    }

    public GenericResponse deleteBook(Long bookId){
        Book book = findById(bookId);
        bookRepository.delete(book);

        return GenericResponse.builder()
                .message("Deleted!")
                .httpStatus(HttpStatus.ACCEPTED)
                .build();
    }

}
