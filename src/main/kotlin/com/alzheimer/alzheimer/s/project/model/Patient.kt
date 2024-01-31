package com.alzheimer.alzheimer.s.project.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "patient")
class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    var name: String? = null

    @Column(name = "last_name")
    var lastName: Int? = null

    @Column(name = "date_diagnosis")
    var dateDiagnosis: Date? = null

    var address: String? = null

    var stage: String? = null

    @Column(name = "alarm_id")
    var alarmId: Long? = null
}
