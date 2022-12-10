package br.com.alef

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestWithSpringBootApplication

fun main(args: Array<String>) {
	runApplication<RestWithSpringBootApplication>(*args)
}
