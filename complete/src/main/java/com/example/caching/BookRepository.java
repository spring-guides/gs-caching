package com.example.caching;

public interface BookRepository {

	Book getByIsbn(String isbn);

	Book updateByIsbn(String isbn);

	void deleteByIsbn(String isbn);

}
