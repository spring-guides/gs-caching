package com.example.caching

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
class SimpleBookRepository : BookRepository {

    @Cacheable("books")
    override fun getByIsbn(isbn: String): Book {
        simulateSlowService()
        return Book(isbn, "Some book")
    }

    // Don't do this at home
    private fun simulateSlowService() {
         Thread.sleep(3000L)
    }
}