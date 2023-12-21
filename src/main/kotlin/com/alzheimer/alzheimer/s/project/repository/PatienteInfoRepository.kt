package com.alzheimer.alzheimer.s.project.repository

import com.alzheimer.alzheimer.s.project.model.PatienteInfo
import com.alzheimer.alzheimer.s.project.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatienteInfoRepository : JpaRepository<PatienteInfo, Long?> {
    fun findById (id: Long?): PatienteInfo?
}