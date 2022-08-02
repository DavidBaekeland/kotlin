package com.dev4.thymeleaf2.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    var firstName: String,
    var lastName: String,
    var email: String
) {
}