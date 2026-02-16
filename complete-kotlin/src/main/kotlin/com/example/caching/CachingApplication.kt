package com.example.caching

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class CachingApplication

fun main(args: Array<String>) {
    runApplication<CachingApplication>(*args)
}
