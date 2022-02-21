package br.com.kym.todolist.web.controller

import br.com.kym.todolist.domain.generator.HashGenerator
import br.com.kym.todolist.domain.model.User
import br.com.kym.todolist.domain.service.UserService
import br.com.kym.todolist.web.request.CreateUserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,
    private val hashGenerator: HashGenerator
) {

    @PostMapping
    fun save(@RequestBody createUserRequest: CreateUserRequest): User {
        return userService.create(createUserRequest.toUser { hashGenerator.generate(it) })
    }

}