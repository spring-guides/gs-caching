package com.example.caching;

public interface BookRepository {

	Book getByIsbn(String isbn);
	Book putByIsbn(String isbn);

}
