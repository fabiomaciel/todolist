package br.com.kym.todolist.domain.service.impl

import br.com.kym.todolist.domain.model.Task
import br.com.kym.todolist.domain.service.TaskService
import br.com.kym.todolist.infra.database.repository.TaskRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class TaskServiceImpl(
    private val taskRepository: TaskRepository
) : TaskService {

    override fun getOne(id: String): Optional<Task> =
        taskRepository.findById(id)


    override fun getAll(): List<Task> =
        taskRepository.findAll()

    override fun save(task: Task): Task {
        return taskRepository.save(task)
    }

    override fun update(task: Task): Optional<Task> =
        getOne(task.id!!)
            .map {
                taskRepository.save(updateTask(it, task))
            }

    private fun updateTask(
        current: Task,
        updated: Task
    ) = current.copy(
        title = updated.title ?: current.title,
        description = updated.description ?: current.description,
        status = updated.status ?: current.status,
        updateDate = LocalDateTime.now()
    )
}