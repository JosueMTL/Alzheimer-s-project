package com.alzheimer.alzheimer.s.project.controller


import com.alzheimer.alzheimer.s.project.model.Configurations
import com.alzheimer.alzheimer.s.project.service.ConfigurationsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/configurations")
class ConfiguratiosController {
    @Autowired
    lateinit var configurationsService: ConfigurationsService

    @GetMapping
    fun list (configurations: Configurations, pageable: Pageable): ResponseEntity<*> {
        val response= configurationsService.list(pageable ,configurations)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody configurations: Configurations):ResponseEntity<Configurations>{
        return ResponseEntity(configurationsService.save(configurations), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody configurations: Configurations):ResponseEntity<Configurations>{
        return ResponseEntity(configurationsService.update(configurations), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody configurations: Configurations):ResponseEntity<Configurations>{
        return ResponseEntity(configurationsService.updateName(configurations), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(configurationsService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return configurationsService.delete(id)
    }
}