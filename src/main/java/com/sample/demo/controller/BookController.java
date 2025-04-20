package com.sample.demo.controller;

import com.sample.demo.dto.BookDTO;
import com.sample.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class BookController {


    private final BookService bookService;


    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBook(@RequestParam(defaultValue = "0") int offset,
                                                    @RequestParam(defaultValue = "10") int limit) {
        List<BookDTO> books = bookService.getAllBooks(offset, limit);
        return ResponseEntity.ok(books);
    }


    @PostMapping("/save")
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.saveBook(bookDTO));
    }
}
