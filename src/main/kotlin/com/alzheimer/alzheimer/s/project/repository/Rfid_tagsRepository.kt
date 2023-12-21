package com.alzheimer.alzheimer.s.project.repository

import com.alzheimer.alzheimer.s.project.model.Rfid_tags
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Rfid_tagsRepository :JpaRepository<Rfid_tags, Long?> {
    fun findById (id: Long?): Rfid_tags?
}