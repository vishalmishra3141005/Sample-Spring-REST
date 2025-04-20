package com.sample.demo.controller;

import com.sample.demo.dto.BookDTO;
import com.sample.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class BookController {


    private final BookService bookService;


    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBook() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }


    @PostMapping("/save")
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.saveBook(bookDTO));
    }
}
