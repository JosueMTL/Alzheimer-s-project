package com.alzheimer.alzheimer.s.project.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "rfid_tags")
class Rfid_tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    var id: Long? = null

    @Column(name = "interaction_id")
    var interactionId: Long? = null

    @Column(name = "users_id")
    var usersId: Long? = null

    @Column(name = "read_date")
    var readDate: Date? = null

    @Column(name = "location")
    var location: String? = null
}
