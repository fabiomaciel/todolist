package br.com.kym.todolist.domain.service.impl

import br.com.kym.todolist.domain.generator.HashGenerator
import br.com.kym.todolist.domain.provider.JWTTokenProvider
import br.com.kym.todolist.domain.service.LoginService
import br.com.kym.todolist.infra.database.repository.UserRepository
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class LoginServiceImpl(
    private val userRepository: UserRepository,
    private val hashGenerator: HashGenerator,
    private val jwtGenerator: JWTTokenProvider
) : LoginService {
    override fun validate(login: String, password: String): String? {
        return userRepository.findByLogin(login)
            ?.takeIf { hashGenerator.compare(password, it.password!!) }
            ?.let { UsernamePasswordAuthenticationToken(login, it.password, listOf()) }
            ?.let { jwtGenerator.generateToken(login) }
    }
}