package br.com.kym.todolist.web.controller

import br.com.kym.todolist.domain.service.LoginService
import br.com.kym.todolist.web.exceptions.InvalidCredentialsException
import br.com.kym.todolist.web.request.LoginRequest
import br.com.kym.todolist.web.response.LoginResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(
    private val loginService: LoginService
) {

    @PostMapping
    fun save(@RequestBody loginRequest: LoginRequest): LoginResponse {
        return loginService.validate(loginRequest.login, loginRequest.password)?.let {
            LoginResponse(it)
        } ?: throw InvalidCredentialsException()
    }

}