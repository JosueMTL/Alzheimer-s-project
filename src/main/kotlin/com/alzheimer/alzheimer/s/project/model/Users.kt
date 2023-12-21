package com.alzheimer.alzheimer.s.project.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "gmail")
    var gmail: String? = null

    @Column(name = "password")
    var password: String? = null
}
