package com.aarash.nplusone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @UuidGenerator
    private UUID authorId;

    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Book> books;
                                
    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                '}';
    }
}

