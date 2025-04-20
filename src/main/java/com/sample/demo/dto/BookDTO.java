package com.sample.demo.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;
}
