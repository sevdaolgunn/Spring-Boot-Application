package com.example.enoca6.service;

import com.example.enoca6.converter.AuthorConverter;
import com.example.enoca6.dto.AuthorDto;
import com.example.enoca6.dto.request.CreateAuthorRequest;
import com.example.enoca6.dto.request.UpdateAuthorRequest;
import com.example.enoca6.dto.response.AuthorListResponse;
import com.example.enoca6.dto.response.AuthorResponse;
import com.example.enoca6.dto.response.GenericResponse;
import com.example.enoca6.entity.Author;
import com.example.enoca6.entity.Book;
import com.example.enoca6.exception.GenericException;
import com.example.enoca6.repository.AuthorRepository;
import com.example.enoca6.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;
    private final BookRepository bookRepository;
    public AuthorResponse createAuthor(CreateAuthorRequest request){

        Author author = authorRepository.save(authorConverter.convertAsEntity(request));
        return  AuthorResponse.builder()
                .author(authorConverter.convertAsDto(author))
                .statusCode(201)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    public AuthorListResponse getAllAuthor(){
        List<Author> authorList = authorRepository.findAll();
        if (authorList.isEmpty()){
            return AuthorListResponse.builder()
                    .statusCode(404)
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .build();
        }
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for (int i = 0; i < authorList.size(); i++) {
            Author author = authorList.get(i);
            authorDtoList.add(authorConverter.convertAsDto(author));
        }
        return AuthorListResponse.builder()
                .authorList(authorDtoList)
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(200)
                .build();
    }

    public AuthorResponse getAuthor(Long authorId){
       Optional<Author> optionalAuthor = authorRepository.findById(authorId);
       if (optionalAuthor.isEmpty()){
           return AuthorResponse.builder()
                   .statusCode(404)
                   .httpStatus(HttpStatus.NOT_FOUND)
                   .build();
       }
       Author author = optionalAuthor.get();
       AuthorDto authorDto = authorConverter.convertAsDto(author);
       return AuthorResponse.builder()
               .author(authorDto)
               .httpStatus(HttpStatus.ACCEPTED)
               .statusCode(200)
               .build();
    }

    protected Author findById(Long authorId){
        return authorRepository.findById(authorId).orElseThrow(
                ()-> GenericException.builder()
                        .errorMessage("Böyle bir yazar bulunamadı.")
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .build());
    }

    public GenericResponse updateAuthorById(Long authorId, UpdateAuthorRequest request){

        Author foundAuthor = findById(authorId);
        foundAuthor.setFullName(request.getFullName());

        authorRepository.save(foundAuthor);
        return GenericResponse.builder()
                .message("Updated!")
                .httpStatus(HttpStatus.ACCEPTED)
                .build();
    }
    @Transactional
    public GenericResponse deleteAuthor(Long authorId){
        Author author = findById(authorId);

        List<Book> bookList = bookRepository.findByAuthorId(authorId);
        for (int i = 0; i < bookList.size(); i++) {
            bookRepository.delete(bookList.get(i));
        }
        authorRepository.delete(author);
        return GenericResponse.builder()
                .message("Deleted!")
                .httpStatus(HttpStatus.ACCEPTED)
                .build();
    }
}
