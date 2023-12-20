package com.alzheimer.alzheimer.s.project.model

import jakarta.persistence.*
import java.sql.Time
import java.util.Date

@Entity
@Table(name = "reminders")
class Reminders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var title: Long? = null
    var description: Long? = null
    var date: Date? = null
    var time: Time? = null
    var status: Long? = null
    var active: Boolean? = null

    @Column(name = "users_id")
    var usersId: Int? = null
    @Column(name = "patientInfo_id")
    var patientInfoId: Int? = null
}
