package com.aarash.nplusone;

import com.aarash.nplusone.dto.AuthorDTO;
import com.aarash.nplusone.entity.Author;
import com.aarash.nplusone.entity.Book;
import com.aarash.nplusone.repository.AuthorRepo;
import com.aarash.nplusone.repository.BookRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NPlusOneApplicationTests {
	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private AuthorRepo authorRepo;

	@BeforeAll
	public void setup() {
		Author author1 = new Author();
		author1.setName("Author 1");

		Author author2 = new Author();
		author2.setName("Author 2");

		authorRepo.save(author1);
		authorRepo.save(author2);

		Book book1 = new Book();
		book1.setTitle("Book 1");
		book1.setAuthor(author1);

		Book book2 = new Book();
		book2.setTitle("Book 2");
		book2.setAuthor(author2);

		bookRepo.save(book1);
		bookRepo.save(book2);
	}

	@Test
	public void test_fetchAllAuthors() {

		List<Author> allAuthor = authorRepo.findAll();
		allAuthor.forEach(author ->{
			System.out.println(author.getBooks());
		});
		assertEquals(2, allAuthor.size());
	}

	@Test
	public void test_fetchAllAuthorsUsingDTO() {

		List<AuthorDTO> allAuthor = authorRepo.findAllAuthorsWithBook();
		allAuthor.forEach(author ->{
			System.out.println(author);
		});
		assertEquals(2, allAuthor.size());

	}

	@Test
	public void test_fetchAllBooks() {

		List<Book> books = bookRepo.findAll();

		assertEquals(2, books.size());

		books.forEach(book -> System.out.println(book.getAuthor().getName()));
	}

}
