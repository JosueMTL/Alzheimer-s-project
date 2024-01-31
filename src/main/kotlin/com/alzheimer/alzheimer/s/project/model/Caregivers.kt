package com.alzheimer.alzheimer.s.project.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "caregivers")
class Caregivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    var name: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "user_name")
    var userName: String? =null

    var gmail: String? = null

    var password: String? = null

    var relationship: String? =null
}
