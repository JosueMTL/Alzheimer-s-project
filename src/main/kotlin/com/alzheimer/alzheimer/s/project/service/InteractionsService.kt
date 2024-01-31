package com.alzheimer.alzheimer.s.project.service

import com.alzheimer.alzheimer.s.project.model.Interactions
import com.alzheimer.alzheimer.s.project.repository.InteractionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InteractionsService {
    @Autowired
    lateinit var interactionsRepository: InteractionsRepository

    fun list (pageable: Pageable, interactions: Interactions): Page<Interactions> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return interactionsRepository.findAll(Example.of(interactions, matcher), pageable)
    }

    fun save(interactions: Interactions): Interactions{
        try{
            return interactionsRepository.save(interactions)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(interactions: Interactions): Interactions{
        try {
            interactionsRepository.findById(interactions.id)
                ?: throw Exception("ID no existe")

            return interactionsRepository.save(interactions)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(interactions:Interactions): Interactions{
        try{
            val response = interactionsRepository.findById(interactions.id)
                ?: throw Exception("ID no existe")
            response.apply {
                message=interactions.message
            }
            return interactionsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Interactions?{
        return interactionsRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = interactionsRepository.findById(id)
                ?: throw Exception("ID no existe")
            interactionsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
