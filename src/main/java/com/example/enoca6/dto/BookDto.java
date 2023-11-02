package com.example.enoca6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class BookDto {
    private Long id;
    private String title;
    private Long yearOfPublication;
    private Long isbn;
    private String authorName;
}
