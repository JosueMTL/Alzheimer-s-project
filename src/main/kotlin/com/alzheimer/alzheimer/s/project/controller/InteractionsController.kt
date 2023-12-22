package com.alzheimer.alzheimer.s.project.controller


import com.alzheimer.alzheimer.s.project.model.Interactions
import com.alzheimer.alzheimer.s.project.service.InteractionsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/interactions")
class InteractionsController {
    @Autowired
    lateinit var interactionsService: InteractionsService

    @GetMapping
    fun list (interactions: Interactions, pageable: Pageable): ResponseEntity<*> {
        val response= interactionsService.list(pageable ,interactions)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody interactions: Interactions):ResponseEntity<Interactions>{
        return ResponseEntity(interactionsService.save(interactions), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody interactions: Interactions):ResponseEntity<Interactions>{
        return ResponseEntity(interactionsService.update(interactions), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody interactions: Interactions):ResponseEntity<Interactions>{
        return ResponseEntity(interactionsService.updateName(interactions), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(interactionsService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return interactionsService.delete(id)
    }
}