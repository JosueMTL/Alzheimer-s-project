package com.alzheimer.alzheimer.s.project.repository

import com.alzheimer.alzheimer.s.project.model.Reminders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RemindersRepository : JpaRepository<Reminders, Long?> {
    fun findById (id: Long?): Reminders?
}