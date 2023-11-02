package com.example.enoca6.dto.response;

import com.example.enoca6.dto.BookDto;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BookListResponse {
    private List<BookDto> bookList;
    private int statusCode;
    private HttpStatus httpStatus;
}
