package br.com.kym.todolist.domain.generator

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Component
class JWTGenerator {
    private val secret = "SECRET"
    private val ISSUER = "TODOLISTAPP"
    private val SUBJECT_USER_DETAILS = "User Details"
    private val CLAIM = "login"

    val idMap = mutableMapOf<String, LocalDateTime>()

    fun generateToken(login: String): String {
        val id = UUID.randomUUID().toString()
        val expirationDate = LocalDateTime.now().plusSeconds(30)
        idMap[id] = expirationDate

        return JWT.create()
            .withSubject(SUBJECT_USER_DETAILS)
            .withClaim(CLAIM, login)
            .withIssuedAt(Date())
            .withIssuer(ISSUER)
            .withJWTId(id)
            .withExpiresAt(Date.from(expirationDate.atZone(ZoneId.systemDefault()).toInstant()))
            .sign(algorithm())
    }

    fun validateToken(token: String): Boolean {
        val verifier = JWT.require(algorithm())
            .withSubject(SUBJECT_USER_DETAILS)
            .withIssuer(ISSUER)
            .build()

        val verify = verifier.verify(token)
        val expire = idMap[verify.id]
        return expire?.let {
            expire.isAfter(LocalDateTime.now())
        } ?: false
    }

    private fun algorithm() = Algorithm.HMAC256(secret)
}