package com.aarash.nplusone.repository;

import com.aarash.nplusone.dto.AuthorDTO;
import com.aarash.nplusone.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuthorRepo extends JpaRepository<Author, UUID> {

//    @EntityGraph(attributePaths = {"books"})
//    @Query("SELECT a FROM Author a JOIN FETCH a.books")
    List<Author> findAll();


    @Query("SELECT new com.aarash.nplusone.dto.AuthorDTO(a.authorId,a.name, b.title) FROM Author a JOIN a.books b")
    List<AuthorDTO> findAllAuthorsWithBook();
}
