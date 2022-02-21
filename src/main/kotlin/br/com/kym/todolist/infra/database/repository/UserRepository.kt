package br.com.kym.todolist.infra.database.repository

import br.com.kym.todolist.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String> {
    fun findByLogin(login: String): User?
}