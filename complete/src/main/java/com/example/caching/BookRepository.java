package com.example.caching;

import java.util.List;

public interface BookRepository {

	Book getByIsbn(String isbn);

	Book updateByIsbn(String isbn);

	String deleteByIsbn(String isbn);

	String deleteAllIsbn();

	List<Book> getAllBooks();

}
