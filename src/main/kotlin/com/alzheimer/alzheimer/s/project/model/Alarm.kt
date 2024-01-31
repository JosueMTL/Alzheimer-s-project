package com.alzheimer.alzheimer.s.project.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Time
import java.util.Date

@Entity
@Table(name = "alarm")
class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    var title: String? = null

    var time: Time? = null
    var repeat: Boolean? = null
    var date: Date? = null
    @Column(name = "caregivers_id")
    var caregiversId: Long? = null
}
