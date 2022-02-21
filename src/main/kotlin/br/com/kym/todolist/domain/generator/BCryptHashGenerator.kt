package br.com.kym.todolist.domain.generator

import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Component

@Component
class BCryptHashGenerator : HashGenerator {

    override fun generate(value: String): String =
        BCrypt.hashpw(value, BCrypt.gensalt())

    override fun compare(plainValue: String, hash: String) =
        BCrypt.checkpw(plainValue, hash)

}