package com.dev4.thymeleaf2.models

import org.springframework.data.relational.core.mapping.Table
import javax.persistence.*

@Entity
class Message(
    var author: String? ="",
    var message: String? = "",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?= null,

    ) {

}