package com.alzheimer.alzheimer.s.project.service

import com.alzheimer.alzheimer.s.project.model.Rfid_tags
import com.alzheimer.alzheimer.s.project.repository.Rfid_tagsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class Rfid_tagsService {
    @Autowired
    lateinit var rfid_tagsRepository: Rfid_tagsRepository

    fun list (pageable: Pageable, rfid_tags: Rfid_tags): Page<Rfid_tags> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return rfid_tagsRepository.findAll(Example.of(rfid_tags, matcher), pageable)
    }

    fun save(rfid_tags: Rfid_tags): Rfid_tags{
        try{
            return rfid_tagsRepository.save(rfid_tags)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(rfid_tags: Rfid_tags): Rfid_tags{
        try {
            rfid_tagsRepository.findById(rfid_tags.id)
                ?: throw Exception("ID no existe")

            return rfid_tagsRepository.save(rfid_tags)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(rfid_tags:Rfid_tags): Rfid_tags{
        try{
            val response = rfid_tagsRepository.findById(rfid_tags.id)
                ?: throw Exception("ID no existe")
            response.apply {
                location=rfid_tags.location
            }
            return rfid_tagsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Rfid_tags?{
        return rfid_tagsRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = rfid_tagsRepository.findById(id)
                ?: throw Exception("ID no existe")
            rfid_tagsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
