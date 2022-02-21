package br.com.kym.todolist.web.extension

import br.com.kym.todolist.domain.model.Task
import br.com.kym.todolist.web.exceptions.TaskNotFoundException
import java.util.*

fun Optional<Task>.orNotFound() = this.orElseThrow { TaskNotFoundException() }