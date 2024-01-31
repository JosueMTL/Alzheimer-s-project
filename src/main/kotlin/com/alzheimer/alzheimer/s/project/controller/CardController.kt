package com.alzheimer.alzheimer.s.project.controller


import com.alzheimer.alzheimer.s.project.model.Card
import com.alzheimer.alzheimer.s.project.service.CardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/card")
class CardController {
    @Autowired
    lateinit var cardService: CardService

    @GetMapping
    fun list (card: Card, pageable: Pageable): ResponseEntity<*> {
        val response= cardService.list(pageable ,card)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody card: Card):ResponseEntity<Card>{
        return ResponseEntity(cardService.save(card), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody card: Card):ResponseEntity<Card>{
        return ResponseEntity(cardService.update(card), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody card: Card):ResponseEntity<Card>{
        return ResponseEntity(cardService.updateName(card), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(cardService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return cardService.delete(id)
    }
}