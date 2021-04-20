package com.study.kotlin.service


import com.study.kotlin.entity.User
import com.study.kotlin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun updateUser(user: User) {
        var ordUserInfo: User? = user.seq?.let { userRepository.findBySeq(it) }
        if (ordUserInfo != null) {
            userRepository.save(user)
        }
    }

    fun save(user: User) {
        userRepository.save(user);
    }

    fun getList(): MutableList<User> {
        return userRepository.findAll()
    }

    fun deleteUser(seq: Long) {
        return userRepository.deleteById(seq)
    }
}