package com.alzheimer.alzheimer.s.project.controller


import com.alzheimer.alzheimer.s.project.model.PatienteInfo
import com.alzheimer.alzheimer.s.project.service.PatienteInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/patienteInfo")
class PatienteInfoController {
    @Autowired
    lateinit var patienteInfoService: PatienteInfoService

    @GetMapping
    fun list (patienteInfo: PatienteInfo, pageable: Pageable): ResponseEntity<*> {
        val response= patienteInfoService.list(pageable ,patienteInfo)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody patienteInfo: PatienteInfo):ResponseEntity<PatienteInfo>{
        return ResponseEntity(patienteInfoService.save(patienteInfo), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody patienteInfo: PatienteInfo):ResponseEntity<PatienteInfo>{
        return ResponseEntity(patienteInfoService.update(patienteInfo), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody patienteInfo: PatienteInfo):ResponseEntity<PatienteInfo>{
        return ResponseEntity(patienteInfoService.updateName(patienteInfo), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(patienteInfoService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return patienteInfoService.delete(id)
    }
}