package br.com.kym.todolist.web.filter

import br.com.kym.todolist.domain.generator.JWTGenerator
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtFilter(
    private val jwtGenerator: JWTGenerator
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        val header: String? = request.getHeader(HttpHeaders.AUTHORIZATION)

        if (header == null || (header.isEmpty() || !header.startsWith("Bearer "))) {
            chain.doFilter(request, response);
            return
        }
        val token: String = header.split(" ")[1].trim();
        if (!jwtGenerator.validateToken(token)) {
            chain.doFilter(request, response);
            return
        }
    }
}