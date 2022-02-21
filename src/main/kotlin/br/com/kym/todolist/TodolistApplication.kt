package br.com.kym.todolist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TodolistApplication

fun main(args: Array<String>) {
	runApplication<TodolistApplication>(*args)
}
