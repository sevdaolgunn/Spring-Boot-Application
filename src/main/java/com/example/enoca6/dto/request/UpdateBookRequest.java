package com.example.enoca6.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateBookRequest {
    private String title;
    private Long yearOfPublication;
    private Long isbn;
}
