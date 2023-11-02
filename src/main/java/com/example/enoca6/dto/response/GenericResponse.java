package com.example.enoca6.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class GenericResponse {
    private String message;
    private HttpStatus httpStatus;



}
