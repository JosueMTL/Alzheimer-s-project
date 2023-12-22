package com.alzheimer.alzheimer.s.project.controller


import com.alzheimer.alzheimer.s.project.model.Users
import com.alzheimer.alzheimer.s.project.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UsersController {
    @Autowired
    lateinit var usersService: UsersService

    @GetMapping
    fun list (users: Users, pageable: Pageable): ResponseEntity<*> {
        val response= usersService.list(pageable ,users)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody users: Users):ResponseEntity<Users>{
        return ResponseEntity(usersService.save(users), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody users: Users):ResponseEntity<Users>{
        return ResponseEntity(usersService.update(users), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody users: Users):ResponseEntity<Users>{
        return ResponseEntity(usersService.updateName(users), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(usersService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return usersService.delete(id)
    }
}