package com.example.enoca6.converter;

import com.example.enoca6.dto.AuthorDto;
import com.example.enoca6.dto.request.CreateAuthorRequest;
import com.example.enoca6.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public Author convertAsEntity(CreateAuthorRequest request){
        return Author.builder()
                .fullName(request.getFullName())
                .build();
    }

    public AuthorDto convertAsDto(Author author){
        return AuthorDto.builder()
                .id(author.getId())
                .fullName(author.getFullName())
                .build();
    }
}
