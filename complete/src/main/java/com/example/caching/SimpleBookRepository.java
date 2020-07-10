package com.example.caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

	@Override
	@Cacheable(cacheNames = "books", key = "#isbn")
	public Book getByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, "Some book");
	}

	@Override
	@CachePut(cacheNames = "books" , key = "#isbn")
	public Book updateBokByIsbn(String isbn) {
		return new Book(isbn, "Update book");
	}

	@Override
	@CacheEvict(cacheNames = "books", allEntries = true)
	public void deleteBookCache(String isbn) {
		// TODO Auto-generated method stub

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
