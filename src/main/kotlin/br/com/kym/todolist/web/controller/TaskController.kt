package br.com.kym.todolist.web.controller

import br.com.kym.todolist.domain.model.Task
import br.com.kym.todolist.domain.service.TaskService
import br.com.kym.todolist.web.extension.orNotFound
import br.com.kym.todolist.web.request.CreateTaskRequest
import br.com.kym.todolist.web.request.UpdateTaskRequest
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("task")
class TaskController(
    private val taskService: TaskService
) {

    @GetMapping("{id}")
    fun getOne(@PathVariable id: String): Task =
        taskService.getOne(id).orNotFound()


    @GetMapping
    fun getAll(): List<Task> =
        taskService.getAll()


    @PostMapping
    fun save(@RequestBody createTaskRequest: CreateTaskRequest): Task {
        return taskService.save(createTaskRequest.toTask(LocalDateTime.now()))
    }


    @PatchMapping("{id}")
    fun update(@PathVariable id: String, @RequestBody updateTaskRequest: UpdateTaskRequest): Task {
        val task = updateTaskRequest.toTask(id)
        return taskService.update(task).orNotFound()
    }

}