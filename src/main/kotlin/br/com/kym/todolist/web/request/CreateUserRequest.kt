package br.com.kym.todolist.web.request

import br.com.kym.todolist.domain.model.User

data class CreateUserRequest(
    val user: String,
    val password: String
) {
    fun toUser(encrypt: (String) -> String) =
        User(
            login = user,
            password = encrypt(password)
        )
}
