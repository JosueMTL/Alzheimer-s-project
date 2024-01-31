package com.alzheimer.alzheimer.s.project.repository

import com.alzheimer.alzheimer.s.project.model.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository : JpaRepository<Patient, Long?> {
    fun findById (id: Long?): Patient?
}