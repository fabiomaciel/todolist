package br.com.kym.todolist.domain.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "USERS")
data class User(
    @Id
    @GenericGenerator(name = "id", strategy = "br.com.kym.todolist.domain.generator.UUIDGeneratorId")
    @GeneratedValue(generator = "id")
    val id: String? = null,
    val login: String? = null,
    val password: String? = null
)