package com.alzheimer.alzheimer.s.project.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "patienteInfo")
class PatienteInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "address")
    var address: String? = null

    @Column(name = "date_birth")
    var dateBirth: Date? = null

    @Column(name = "date_diagnosis")
    var dateDiagnosis: Date? = null

    @Column(name = "stage")
    var stage: Int? = null
}