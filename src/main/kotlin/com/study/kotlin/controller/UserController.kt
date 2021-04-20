package com.study.kotlin.controller


import com.study.kotlin.entity.User
import com.study.kotlin.repository.UserRepository
import com.study.kotlin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping("/user", produces = ["application/json"])
    private fun getUsers(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(userService.getList())
    }

    @PostMapping("/user")
    private fun seveUser(@RequestBody user: User): ResponseEntity<Any> {
        userService.save(user)
        return ResponseEntity
            .ok()
            .body(true)
    }

    @PutMapping("/user", produces = ["application/json"])
    private fun updateUser(@RequestBody user: User): ResponseEntity<Any> {
        user.seq?.let { userService.updateUser(user) }
        return ResponseEntity
            .ok()
            .body(true)
    }

    @DeleteMapping("/user/{seq}")
    private fun deleteUser(@PathVariable seq:Long): ResponseEntity<Any> {
        userService.deleteUser(seq)

        return ResponseEntity
            .ok()
            .body(true)
    }
}