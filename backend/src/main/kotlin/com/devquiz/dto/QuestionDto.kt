package com.devquiz.dto

import com.devquiz.domain.Difficulty
import com.devquiz.domain.QuestionType

data class QuestionResponse(
    val id: Long,
    val category: String,
    val questionText: String,
    val questionType: QuestionType,
    val options: List<String>?,
    val difficulty: Difficulty
)

data class QuestionWithAnswerResponse(
    val id: Long,
    val category: String,
    val questionText: String,
    val questionType: QuestionType,
    val options: List<String>?,
    val correctAnswer: String,
    val explanation: String?,
    val difficulty: Difficulty
)

data class CreateQuestionRequest(
    val category: String,
    val questionText: String,
    val questionType: QuestionType,
    val options: List<String>?,
    val correctAnswer: String,
    val explanation: String?,
    val difficulty: Difficulty
)

data class SubmitAnswerRequest(
    val questionId: Long,
    val answer: String
)

data class SubmitAnswerResponse(
    val isCorrect: Boolean,
    val correctAnswer: String,
    val explanation: String?
)
