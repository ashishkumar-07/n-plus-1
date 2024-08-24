package com.aarash.nplusone.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthorDTO {
    private UUID authorId;

    private String name;

    private String bookTitle;

    public AuthorDTO(UUID authorId, String name, String title) {
        this.authorId = authorId;
        this.name = name;
        this.bookTitle = title;
    }
}
