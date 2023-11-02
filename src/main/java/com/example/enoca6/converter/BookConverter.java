package com.example.enoca6.converter;

import com.example.enoca6.dto.AuthorDto;
import com.example.enoca6.dto.BookDto;
import com.example.enoca6.dto.request.CreateBookRequest;
import com.example.enoca6.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public Book convertAsEntity(CreateBookRequest request){
        return Book.builder()
                .title(request.getTitle())
                .isbn(request.getIsbn())
                .yearOfPublication(request.getYearOfPublication())
                .authorId(request.getAuthorId())
                .build();
    }

    public BookDto convertAsDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .authorName(book.getAuthor().getFullName())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .yearOfPublication(book.getYearOfPublication())
                .build();
    }
}
