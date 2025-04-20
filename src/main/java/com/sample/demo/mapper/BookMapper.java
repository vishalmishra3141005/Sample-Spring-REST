package com.sample.demo.mapper;

import com.sample.demo.dto.BookDTO;
import com.sample.demo.model.Book;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class BookMapper {

    private final ModelMapper modelMapper;


    public BookDTO toDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public Book toEntity(BookDTO dto) {
        return modelMapper.map(dto, Book.class);
    }
}
