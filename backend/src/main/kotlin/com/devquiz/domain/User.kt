package com.devquiz.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("users")
data class User(
    @Id val id: Long? = null,
    val email: String,
    val password: String,
    val username: String,
    val role: UserRole = UserRole.USER,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

enum class UserRole {
    USER,
    ADMIN
}
