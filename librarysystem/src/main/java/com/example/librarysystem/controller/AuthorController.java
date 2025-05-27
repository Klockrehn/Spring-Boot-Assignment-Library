package com.example.librarysystem.controller;

import com.example.librarysystem.dto.AuthorDTO;
import com.example.librarysystem.entity.Author;
import com.example.librarysystem.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return authors.stream()
                .map(authorService::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/name/{lastName}")
    public List<AuthorDTO> getAuthorsByLastName(@PathVariable String lastName) {
        List<Author> authors = authorService.getAuthorsByLastName(lastName);
        return authors.stream()
                .map(authorService::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setBirthYear(authorDTO.getBirthYear());
        author.setNationality(authorDTO.getNationality());

        Author savedAuthor = authorService.createAuthor(author);
        return authorService.convertToDTO(savedAuthor);
    }
}
