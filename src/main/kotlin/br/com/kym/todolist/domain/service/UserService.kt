package br.com.kym.todolist.domain.service

import br.com.kym.todolist.domain.model.User

interface UserService {
    fun create(user: User): User
}