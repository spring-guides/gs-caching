package com.example.caching

interface BookRepository {
    fun getByIsbn(isbn: String): Book
}
