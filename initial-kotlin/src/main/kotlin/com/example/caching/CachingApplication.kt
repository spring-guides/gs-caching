package com.example.caching

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CachingApplication

fun main(args: Array<String>) {
    runApplication<CachingApplication>(*args)
}
