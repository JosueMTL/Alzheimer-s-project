package com.alzheimer.alzheimer.s.project.model

import java.sql.Date
import jakarta.persistence.*

@Entity
@Table(name = "rfid_tags")
class RFIDTag {
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


