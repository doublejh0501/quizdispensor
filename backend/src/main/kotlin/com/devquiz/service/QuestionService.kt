package com.devquiz.service

import com.devquiz.domain.Question
import com.devquiz.dto.*
import com.devquiz.repository.QuestionRepository
import com.devquiz.repository.UserProgressRepository
import com.devquiz.domain.UserProgress
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
    private val userProgressRepository: UserProgressRepository
) {
    fun getAllQuestions(): Flux<QuestionResponse> {
        return questionRepository.findAll()
            .map { it.toResponse() }
    }

    fun getQuestionsByCategory(category: String): Flux<QuestionResponse> {
        return questionRepository.findByCategory(category)
            .map { it.toResponse() }
    }

    fun getQuestionById(id: Long): Mono<QuestionResponse> {
        return questionRepository.findById(id)
            .map { it.toResponse() }
    }

    fun createQuestion(request: CreateQuestionRequest): Mono<QuestionResponse> {
        val question = Question(
            category = request.category,
            questionText = request.questionText,
            questionType = request.questionType,
            options = request.options,
            correctAnswer = request.correctAnswer,
            explanation = request.explanation,
            difficulty = request.difficulty
        )
        return questionRepository.save(question)
            .map { it.toResponse() }
    }

    fun submitAnswer(userId: Long, request: SubmitAnswerRequest): Mono<SubmitAnswerResponse> {
        return questionRepository.findById(request.questionId)
            .flatMap { question ->
                val isCorrect = question.correctAnswer == request.answer
                val userProgress = UserProgress(
                    userId = userId,
                    questionId = request.questionId,
                    isCorrect = isCorrect,
                    userAnswer = request.answer
                )
                userProgressRepository.save(userProgress)
                    .map {
                        SubmitAnswerResponse(
                            isCorrect = isCorrect,
                            correctAnswer = question.correctAnswer,
                            explanation = question.explanation
                        )
                    }
            }
    }

    private fun Question.toResponse() = QuestionResponse(
        id = id!!,
        category = category,
        questionText = questionText,
        questionType = questionType,
        options = options,
        difficulty = difficulty
    )
}
