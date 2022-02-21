package br.com.kym.todolist.domain.service

interface LoginService {
    fun validate(login: String, password: String): String?
}