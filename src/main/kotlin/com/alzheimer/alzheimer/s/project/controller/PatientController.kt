package com.alzheimer.alzheimer.s.project.controller


import com.alzheimer.alzheimer.s.project.model.Patient
import com.alzheimer.alzheimer.s.project.service.PatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/patient")
class PatientController {
    @Autowired
    lateinit var patientService: PatientService

    @GetMapping
    fun list (patient: Patient, pageable: Pageable): ResponseEntity<*> {
        val response= patientService.list(pageable ,patient)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody patient: Patient):ResponseEntity<Patient>{
        return ResponseEntity(patientService.save(patient), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody patient: Patient):ResponseEntity<Patient>{
        return ResponseEntity(patientService.update(patient), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody patienteInfo: Patient):ResponseEntity<Patient>{
        return ResponseEntity(patientService.updateName(patienteInfo), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(patientService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return patientService.delete(id)
    }
}