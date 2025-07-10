package com.bookmanagementsystem;

import com.bookmanagementsystem.dao.BookDAO;
import com.bookmanagementsystem.dao.BookDAOImpl;
import com.bookmanagementsystem.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BookManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementSystemApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(BookDAO bookDAO) {
		return runner -> {
			// Create book
			createBook(bookDAO);

			// Find book by id
			findBookById(bookDAO);

			// List all books
			listBooks(bookDAO);


		};
	}


	private void createBook(BookDAO bookDAO) {
		System.out.println("Creating a new book...");
		Book book = new Book("No Way Out", "Ben Ski", "Adventure");
		bookDAO.save(book);
		System.out.println("Saved book with ID: " + book.getId());
	}

	private void findBookById(BookDAO bookDAO) {
		// Select what book to find by id
		Book book = bookDAO.findById(1);
		if (book !=null) {
			System.out.println("Found: " + book);
		} else {
			System.out.println("Book not found.");
		}
	}

	private void listBooks(BookDAO bookDAO) {
		List<Book> books = bookDAO.findAll();
		for (Book b : books) {
			System.out.println(b);
		}
	}

}
