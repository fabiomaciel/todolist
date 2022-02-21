package br.com.kym.todolist.web.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class InvalidCredentialsException : RuntimeException("Invalid Credentials") {
}