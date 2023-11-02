package com.example.enoca6.dto.response;

import com.example.enoca6.dto.AuthorDto;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class AuthorResponse {
    private AuthorDto author;
    private int statusCode;
    private HttpStatus httpStatus;

}
