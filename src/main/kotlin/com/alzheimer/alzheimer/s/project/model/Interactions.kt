package com.alzheimer.alzheimer.s.project.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Timestamp

@Entity
@Table(name = "configurations")

class Interactions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "users_message")
    var usersMessage: Long? = null

    @Column(name = "assistant_response")
    var assistantResponse: Long? = null

    @Column(name = "date_time_interaction")
    var dateTimeInteraction: Timestamp? = null

    var request: Boolean? = null
    @Column(name = "patientInfo_id")
    var patientInfoId: Int? = null
}