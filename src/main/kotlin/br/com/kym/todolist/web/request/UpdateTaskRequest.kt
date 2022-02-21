package br.com.kym.todolist.web.request

import br.com.kym.todolist.domain.model.Task
import br.com.kym.todolist.domain.model.TaskStatus

data class UpdateTaskRequest(
    val nome: String? = null,
    val descricao: String? = null,
    val status: TaskStatus? = null
) {
    fun toTask(id: String) =
        Task(id = id, title = nome, description = descricao, status = status)
}