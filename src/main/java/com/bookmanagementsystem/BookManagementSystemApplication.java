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
			//createBook(bookDAO);

			// Find book by id
			//findBookById(bookDAO);

			// List all books
			//listBooks(bookDAO);

			// Find Book by Author
			//findBookByAuthor(bookDAO);

			// Update book
			//updateBook(bookDAO);

			// Delete book
			//deleteBook(bookDAO);

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

	public void findBookByAuthor(BookDAO bookDAO) {
		String authorName = "Ben Ski";

		List<Book> books = bookDAO.findByAuthor(authorName);

		if(books.isEmpty()) {
			System.out.println("No books found for author: " + authorName);
		} else {
			for (Book b : books) {
				System.out.println(b);
			}
		}
	}

	public void updateBook(BookDAO bookDAO) {
		// Select what book to update
		int bookId = 2;
		Book theBook = bookDAO.findById(bookId);
		if (theBook != null) {
			System.out.println("Updating book...");
			// setting new book title
			theBook.setTitle("Updated title");
			bookDAO.update(theBook);
			System.out.println("Updated: " + theBook);
		} else {
			System.out.println("Book not found");
		}
	}

	private void deleteBook(BookDAO bookDAO) {
		int bookId = 2;
		System.out.println("Deleted book with ID: " + bookId);
		bookDAO.delete(bookId);
	}

}
