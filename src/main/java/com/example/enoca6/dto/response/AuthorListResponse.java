package com.example.enoca6.dto.response;

import com.example.enoca6.dto.AuthorDto;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class AuthorListResponse {
    private List<AuthorDto> authorList;
    private int statusCode;
    private HttpStatus httpStatus;

}
