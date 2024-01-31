package com.alzheimer.alzheimer.s.project.controller

import com.alzheimer.alzheimer.s.project.model.Alarm
import com.alzheimer.alzheimer.s.project.service.AlarmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alarm")
class AlarmController {
    @Autowired
    lateinit var alarmService: AlarmService

    @GetMapping
    fun list(alarm: Alarm, pageable: Pageable): ResponseEntity<List<Alarm>> {
        val response = alarmService.list(pageable, alarm)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun save(@RequestBody alarm: Alarm): ResponseEntity<Alarm> {
        return ResponseEntity.ok(alarmService.save(alarm))
    }

    @PutMapping
    fun update(@RequestBody alarm: Alarm): ResponseEntity<Alarm> {
        return ResponseEntity.ok(alarmService.update(alarm))
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<Alarm> {
        return ResponseEntity.ok(alarmService.listById(id).orElse(null))
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<String> {
        val success = alarmService.delete(id)
        return if (success) {
            ResponseEntity.ok("Deleted successfully")
        } else {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deletion failed")
        }
    }
}
