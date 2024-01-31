package com.alzheimer.alzheimer.s.project.service

import com.alzheimer.alzheimer.s.project.model.Card
import com.alzheimer.alzheimer.s.project.repository.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CardService {
    @Autowired
    lateinit var cardRepository: CardRepository

    fun list (pageable: Pageable, card: Card): Page<Card> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return cardRepository.findAll(Example.of(card, matcher), pageable)
    }

    fun save(card: Card): Card{
        try{
            return cardRepository.save(card)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(card: Card): Card{
        try {
            cardRepository.findById(card.id)
                ?: throw Exception("ID no existe")

            return cardRepository.save(card)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(card:Card): Card{
        try{
            val response = cardRepository.findById(card.id)
                ?: throw Exception("ID no existe")
            response.apply {
                location=card.location
            }
            return cardRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Card?{
        return cardRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = cardRepository.findById(id)
                ?: throw Exception("ID no existe")
            cardRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
