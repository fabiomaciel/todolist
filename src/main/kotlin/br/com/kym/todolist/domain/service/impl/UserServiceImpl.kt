package br.com.kym.todolist.domain.service.impl

import br.com.kym.todolist.domain.model.User
import br.com.kym.todolist.domain.service.UserService
import br.com.kym.todolist.infra.database.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun create(user: User): User {
        return userRepository.save(user)
    }

}