package com.alzheimer.alzheimer.s.project.service

import com.alzheimer.alzheimer.s.project.model.Caregivers
import com.alzheimer.alzheimer.s.project.repository.CaragiversRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CaragiversService {
    @Autowired
    lateinit var caragiversRepository: CaragiversRepository

    fun list (pageable: Pageable, users: Caregivers): Page<Caregivers> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return caragiversRepository.findAll(Example.of(users, matcher), pageable)
    }

    fun save(caregivers: Caregivers): Caregivers{
        try{
            return caragiversRepository.save(caregivers)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(caregivers: Caregivers): Caregivers{
        try {
            caragiversRepository.findById(caregivers.id)
                ?: throw Exception("ID no existe")

            return caragiversRepository.save(caregivers)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(caregivers:Caregivers): Caregivers{
        try{
            val response = caragiversRepository.findById(caregivers.id)
                ?: throw Exception("ID no existe")
            response.apply {
                password=caregivers.password
            }
            return caragiversRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Caregivers?{
        return caragiversRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = caragiversRepository.findById(id)
                ?: throw Exception("ID no existe")
            caragiversRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
