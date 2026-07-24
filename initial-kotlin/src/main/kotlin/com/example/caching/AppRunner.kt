package com.example.caching

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class AppRunner(private val bookRepository: BookRepository) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String) {
        logger.info(".... Fetching books")
        logger.info("isbn-1234 -->${bookRepository.getByIsbn("isbn-1234")}")
        logger.info("isbn-1234 -->${bookRepository.getByIsbn("isbn-1234")}")
        logger.info("isbn-1234 -->${bookRepository.getByIsbn("isbn-1234")}")
    }
}