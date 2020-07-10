package com.example.caching;

public interface BookRepository {

	Book getByIsbn(String isbn);

	Book updateByIsbn(String isbn);

	String deleteByIsbn(String isbn);

	String deleteAllIsbn();

}
