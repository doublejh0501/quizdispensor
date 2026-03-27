package com.devquiz.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user_progress")
data class UserProgress(
    @Id val id: Long? = null,
    val userId: Long,
    val questionId: Long,
    val isCorrect: Boolean,
    val userAnswer: String,
    val attemptedAt: LocalDateTime = LocalDateTime.now()
)
