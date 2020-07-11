package com.example.caching;

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

}
