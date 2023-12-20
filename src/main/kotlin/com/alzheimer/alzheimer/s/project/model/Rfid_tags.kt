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
    var interactionId: Int? = null

    @Column(name = "users_id")
    var usersId: Int? = null

    @Column(name = "read_date")
    var readDate: Date? = null

    @Column(name = "location")
    var location: String? = null

    @ManyToOne
    @JoinColumn(name = "interaction_id", insertable = false, updatable = false)
    var interaction: Interactions? = null

    @ManyToOne
    @JoinColumn(name = "users_id", insertable = false, updatable = false)
    var user: Users? = null
}
