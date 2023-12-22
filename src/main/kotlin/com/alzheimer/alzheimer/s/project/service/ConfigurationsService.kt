package com.alzheimer.alzheimer.s.project.service

import com.alzheimer.alzheimer.s.project.model.Configurations
import com.alzheimer.alzheimer.s.project.repository.ConfigurationsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ConfigurationsService {
    @Autowired
    lateinit var configurationsRepository: ConfigurationsRepository

    fun list (pageable: Pageable, configurations: Configurations): Page<Configurations> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return configurationsRepository.findAll(Example.of(configurations, matcher), pageable)
    }

    fun save(configurations: Configurations): Configurations{
        try{
            return configurationsRepository.save(configurations)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(configurations: Configurations): Configurations{
        try {
            configurationsRepository.findById(configurations.id)
                ?: throw Exception("ID no existe")

            return configurationsRepository.save(configurations)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(configurations:Configurations): Configurations{
        try{
            val response = configurationsRepository.findById(configurations.id)
                ?: throw Exception("ID no existe")
            response.apply {
                alertTones=configurations.alertTones
            }
            return configurationsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Configurations?{
        return configurationsRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = configurationsRepository.findById(id)
                ?: throw Exception("ID no existe")
            configurationsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
