package br.com.kym.todolist.domain.service

import br.com.kym.todolist.domain.model.Task
import java.util.*

interface TaskService {
    fun getOne(id: String): Optional<Task>
    fun getAll(): List<Task>
    fun save(task: Task): Task
    fun update(task: Task): Optional<Task>
}