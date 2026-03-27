package com.devquiz.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("questions")
data class Question(
    @Id val id: Long? = null,
    val category: String,
    val questionText: String,
    val questionType: QuestionType,
    val options: List<String>? = null,
    val correctAnswer: String,
    val explanation: String? = null,
    val difficulty: Difficulty,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

enum class QuestionType {
    OX,
    MULTIPLE_CHOICE
}

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
