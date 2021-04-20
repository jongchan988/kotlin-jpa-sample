package com.study.kotlin.repository

import com.study.kotlin.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long?>{
    fun findBySeq(seq: Long): User?
}