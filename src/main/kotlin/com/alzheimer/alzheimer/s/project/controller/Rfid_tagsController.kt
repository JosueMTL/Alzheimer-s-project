package com.alzheimer.alzheimer.s.project.controller


import com.alzheimer.alzheimer.s.project.model.Rfid_tags
import com.alzheimer.alzheimer.s.project.service.Rfid_tagsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rfid_tags")
class Rfid_tagsController {
    @Autowired
    lateinit var rfid_tagsService: Rfid_tagsService

    @GetMapping
    fun list (rfid_tags: Rfid_tags, pageable: Pageable): ResponseEntity<*> {
        val response= rfid_tagsService.list(pageable ,rfid_tags)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody rfid_tags: Rfid_tags):ResponseEntity<Rfid_tags>{
        return ResponseEntity(rfid_tagsService.save(rfid_tags), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody rfid_tags: Rfid_tags):ResponseEntity<Rfid_tags>{
        return ResponseEntity(rfid_tagsService.update(rfid_tags), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody rfid_tags: Rfid_tags):ResponseEntity<Rfid_tags>{
        return ResponseEntity(rfid_tagsService.updateName(rfid_tags), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(rfid_tagsService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return rfid_tagsService.delete(id)
    }
}