package com.example.caching;

public interface BookRepository {

	Book getByIsbn(String isbn);
	Book updateBokByIsbn(String isbn);

}
