package br.com.kym.todolist.infra.database.repository

import br.com.kym.todolist.domain.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, String>