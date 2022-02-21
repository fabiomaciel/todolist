package br.com.kym.todolist.web.exceptions

import br.com.kym.todolist.domain.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class TaskNotFoundException : NotFoundException("Task Not Found") {
}