package br.com.kym.todolist.domain.generator

interface HashGenerator {
    fun generate(value: String): String

    fun compare(plainValue: String, hash: String): Boolean
}