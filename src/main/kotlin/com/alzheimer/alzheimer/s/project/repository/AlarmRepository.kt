package com.alzheimer.alzheimer.s.project.repository

import com.alzheimer.alzheimer.s.project.model.Alarm
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.sql.Time
import java.util.Date
import java.util.List

interface AlarmRepository : JpaRepository<Alarm, Long?> {
    fun findByTitleAndTimeAndRepeatAndDateAndCaregiversId(
        title: String?,
        time: Time?,
        repeat: Boolean?,
        date: Date?,
        caregiversId: Long?,
        pageable: Pageable
    ): List<Alarm>
}
