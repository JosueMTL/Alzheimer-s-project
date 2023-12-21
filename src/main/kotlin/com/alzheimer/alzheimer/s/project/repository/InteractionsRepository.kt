package com.alzheimer.alzheimer.s.project.repository

import com.alzheimer.alzheimer.s.project.model.Interactions
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InteractionsRepository : JpaRepository<Interactions, Long?> {
    fun findById (id: Long?): Interactions?
}