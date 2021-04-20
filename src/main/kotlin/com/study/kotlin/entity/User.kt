package com.study.kotlin.entity

import javax.persistence.*

@Entity
class User (
    name: String,
    age: Int,
    address: String
){
    @Id
    @GeneratedValue
    var seq: Long? = null
    var name: String = name
    var age: Int = age
    var address: String = address
}