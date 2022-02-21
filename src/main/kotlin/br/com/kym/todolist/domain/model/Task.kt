package br.com.kym.todolist.domain.model

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Task(
    @Id
    @GenericGenerator(name = "id", strategy = "br.com.kym.todolist.domain.generator.UUIDGeneratorId")
    @GeneratedValue(generator = "id")
    val id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val creationDate: LocalDateTime? = null,
    val updateDate: LocalDateTime? = null,
    val status: TaskStatus? = null
)
