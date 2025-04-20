package com.sample.demo.service;


import com.sample.demo.dto.BookDTO;
import com.sample.demo.mapper.BookMapper;
import com.sample.demo.model.Book;
import com.sample.demo.respository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class BookService {
    private final BookRepository bookRepo;
    private final BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    public Optional<BookDTO> getBookById(Long id) {
        return bookRepo.findById(id)
                .map(bookMapper::toDTO);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book newBook = bookRepo.save(bookMapper.toEntity(bookDTO));
        return bookMapper.toDTO(newBook);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
