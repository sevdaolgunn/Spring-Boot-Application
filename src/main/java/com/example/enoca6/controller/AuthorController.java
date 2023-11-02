package com.example.enoca6.controller;

import com.example.enoca6.dto.request.CreateAuthorRequest;
import com.example.enoca6.dto.request.UpdateAuthorRequest;
import com.example.enoca6.dto.response.AuthorListResponse;
import com.example.enoca6.dto.response.AuthorResponse;
import com.example.enoca6.dto.response.GenericResponse;
import com.example.enoca6.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/createAuthor")
    public AuthorResponse createAuthor(@RequestBody CreateAuthorRequest request){
        return authorService.createAuthor(request);
    }

    @GetMapping("/getAllAuthor")
    public AuthorListResponse getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/getAuthor/{authorId}")
    public AuthorResponse getAuthor(@PathVariable Long authorId){
        return authorService.getAuthor(authorId);
    }

    @PutMapping("/update/{authorId}")
    public GenericResponse updateAuthorById(@PathVariable Long authorId,
                                            @RequestBody UpdateAuthorRequest request){
       return authorService.updateAuthorById(authorId,request);
    }

    @DeleteMapping("/delete/{authorId}")
    public GenericResponse deleteAuthor(@PathVariable Long authorId){
        return authorService.deleteAuthor(authorId);
    }
}
