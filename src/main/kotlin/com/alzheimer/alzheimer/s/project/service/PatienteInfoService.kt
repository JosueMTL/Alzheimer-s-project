package com.alzheimer.alzheimer.s.project.service

import com.alzheimer.alzheimer.s.project.model.PatienteInfo
import com.alzheimer.alzheimer.s.project.repository.PatienteInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PatienteInfoService {
    @Autowired
    lateinit var patienteInfoRepository: PatienteInfoRepository

    fun list (pageable: Pageable, patienteInfo: PatienteInfo): Page<PatienteInfo> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return patienteInfoRepository.findAll(Example.of(patienteInfo, matcher), pageable)
    }

    fun save(patienteInfo: PatienteInfo): PatienteInfo{
        try{
            return patienteInfoRepository.save(patienteInfo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(patienteInfo: PatienteInfo): PatienteInfo{
        try {
            patienteInfoRepository.findById(patienteInfo.id)
                ?: throw Exception("ID no existe")

            return patienteInfoRepository.save(patienteInfo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(patienteInfo:PatienteInfo): PatienteInfo{
        try{
            val response = patienteInfoRepository.findById(patienteInfo.id)
                ?: throw Exception("ID no existe")
            response.apply {
                address=patienteInfo.address
            }
            return patienteInfoRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):PatienteInfo?{
        return patienteInfoRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = patienteInfoRepository.findById(id)
                ?: throw Exception("ID no existe")
            patienteInfoRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
