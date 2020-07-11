package com.example.caching;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

	@Override
	@Cacheable(value = "books", key = "#isbn")
	public Book getByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, "Some book");
	}

	@Override
	@CachePut(value = "books", key = "#isbn")
	public Book updateByIsbn(String isbn) {
		return new Book(isbn, "Update book");
	}

	@Override
	@CacheEvict(value = "books", key = "#isbn")
	public String deleteByIsbn(String isbn) {
		return "delete books";
	}

	@Override
	@CacheEvict(value = "books", allEntries = true)
	public String deleteAllIsbn() {
		return "delete books";
	}

	// Don't do this at home
	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	@Cacheable(value = "books")
	@Override
	public List<Book> getAllBooks() {
		
		System.out.println("getting all the books from db");
		
		 List<Book> books = new ArrayList<Book>();
		
		 Book book1 = new Book("b1", "all book");
		 Book book2 = new Book("b2", "all book");
		 Book book3 = new Book("b3", "all book");
		 Book book4 = new Book("b4", "all book");
		 Book book5 = new Book("b5", "all book");
		 books.add(book1);
		 books.add(book2);
		 books.add(book3);
		 books.add(book4);
		 books.add(book5);
		 
		return books;
	}

}
