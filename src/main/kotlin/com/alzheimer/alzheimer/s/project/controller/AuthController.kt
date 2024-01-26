package com.alzheimer.alzheimer.s.project.controller

import com.alzheimer.alzheimer.s.project.config.JwtUtil
import com.alzheimer.alzheimer.s.project.dto.LoginDTO
import com.alzheimer.alzheimer.s.project.dto.TokenDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

@RestController
@RequestMapping("/auth")
class AuthController {
    @Autowired
    private val authenticationManager: AuthenticationManager? = null
    @Autowired
    private val jwtUtil: JwtUtil? = null

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDTO): ResponseEntity<*>? {
        val login = UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password)
        val authentication: Authentication = authenticationManager!!.authenticate(login)
        val response = TokenDTO().apply { jwt= jwtUtil!!.create(loginDto.username)}
        return ResponseEntity(response, HttpStatus.OK)
    }
}