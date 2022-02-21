package br.com.kym.todolist.web.request

import br.com.kym.todolist.domain.model.Task
import br.com.kym.todolist.domain.model.TaskStatus
import java.time.LocalDateTime

data class CreateTaskRequest(
    val nome: String,
    val descricao: String
) {

    fun toTask(data: LocalDateTime) =
        Task(null, nome, descricao, data, data, TaskStatus.TODO)

}