package com.example.enoca6.dto.response;

import com.example.enoca6.dto.BookDto;
import com.example.enoca6.entity.Book;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BookResponse {
    private BookDto book;
    private int statusCode;
    private HttpStatus httpStatus;
}
