package com.alzheimer.alzheimer.s.project.repository

import com.alzheimer.alzheimer.s.project.model.Caregivers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CaragiversRepository :JpaRepository<Caregivers, Long?>{
    fun findById (id: Long?): Caregivers?
}