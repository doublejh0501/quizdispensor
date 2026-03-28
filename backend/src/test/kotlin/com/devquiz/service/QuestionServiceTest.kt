package com.devquiz.service

import com.devquiz.domain.Difficulty
import com.devquiz.domain.Question
import com.devquiz.domain.QuestionType
import com.devquiz.domain.UserProgress
import com.devquiz.dto.CreateQuestionRequest
import com.devquiz.dto.SubmitAnswerRequest
import com.devquiz.repository.QuestionRepository
import com.devquiz.repository.UserProgressRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.time.LocalDateTime

class QuestionServiceTest {

    private val questionRepository: QuestionRepository = mockk()
    private val userProgressRepository: UserProgressRepository = mockk()
    private val questionService = QuestionService(questionRepository, userProgressRepository)

    @Test
    fun `getAllQuestions should return all questions`() {
        // given
        val questions = listOf(
            createSampleQuestion(1L, "자료구조", "스택은 LIFO이다?", QuestionType.OX),
            createSampleQuestion(2L, "네트워크", "TCP는 연결지향이다?", QuestionType.OX)
        )
        every { questionRepository.findAll() } returns Flux.fromIterable(questions)

        // when
        val result = questionService.getAllQuestions()

        // then
        StepVerifier.create(result)
            .expectNextMatches { it.id == 1L && it.category == "자료구조" }
            .expectNextMatches { it.id == 2L && it.category == "네트워크" }
            .verifyComplete()

        verify { questionRepository.findAll() }
    }

    @Test
    fun `getQuestionsByCategory should return filtered questions`() {
        // given
        val category = "자료구조"
        val questions = listOf(
            createSampleQuestion(1L, category, "스택은 LIFO이다?", QuestionType.OX)
        )
        every { questionRepository.findByCategory(category) } returns Flux.fromIterable(questions)

        // when
        val result = questionService.getQuestionsByCategory(category)

        // then
        StepVerifier.create(result)
            .expectNextMatches { it.category == category }
            .verifyComplete()

        verify { questionRepository.findByCategory(category) }
    }

    @Test
    fun `getQuestionById should return question when exists`() {
        // given
        val questionId = 1L
        val question = createSampleQuestion(questionId, "자료구조", "스택은 LIFO이다?", QuestionType.OX)
        every { questionRepository.findById(questionId) } returns Mono.just(question)

        // when
        val result = questionService.getQuestionById(questionId)

        // then
        StepVerifier.create(result)
            .expectNextMatches { it.id == questionId }
            .verifyComplete()

        verify { questionRepository.findById(questionId) }
    }

    @Test
    fun `createQuestion should save and return question`() {
        // given
        val request = CreateQuestionRequest(
            category = "자료구조",
            questionText = "스택은 LIFO이다?",
            questionType = QuestionType.OX,
            options = null,
            correctAnswer = "O",
            explanation = "스택은 Last In First Out 구조입니다.",
            difficulty = Difficulty.EASY
        )
        val savedQuestion = createSampleQuestion(1L, request.category, request.questionText, request.questionType)
        every { questionRepository.save(any()) } returns Mono.just(savedQuestion)

        // when
        val result = questionService.createQuestion(request)

        // then
        StepVerifier.create(result)
            .expectNextMatches { it.category == request.category }
            .verifyComplete()

        verify { questionRepository.save(any()) }
    }

    @Test
    fun `submitAnswer should return correct when answer is right`() {
        // given
        val userId = 1L
        val questionId = 1L
        val correctAnswer = "O"
        val request = SubmitAnswerRequest(questionId = questionId, answer = correctAnswer)
        val question = createSampleQuestion(questionId, "자료구조", "스택은 LIFO이다?", QuestionType.OX)
        val userProgress = UserProgress(
            id = 1L,
            userId = userId,
            questionId = questionId,
            isCorrect = true,
            userAnswer = correctAnswer
        )

        every { questionRepository.findById(questionId) } returns Mono.just(question)
        every { userProgressRepository.save(any()) } returns Mono.just(userProgress)

        // when
        val result = questionService.submitAnswer(userId, request)

        // then
        StepVerifier.create(result)
            .expectNextMatches { it.isCorrect && it.correctAnswer == correctAnswer }
            .verifyComplete()

        verify { questionRepository.findById(questionId) }
        verify { userProgressRepository.save(any()) }
    }

    @Test
    fun `submitAnswer should return incorrect when answer is wrong`() {
        // given
        val userId = 1L
        val questionId = 1L
        val wrongAnswer = "X"
        val correctAnswer = "O"
        val request = SubmitAnswerRequest(questionId = questionId, answer = wrongAnswer)
        val question = createSampleQuestion(questionId, "자료구조", "스택은 LIFO이다?", QuestionType.OX)
        val userProgress = UserProgress(
            id = 1L,
            userId = userId,
            questionId = questionId,
            isCorrect = false,
            userAnswer = wrongAnswer
        )

        every { questionRepository.findById(questionId) } returns Mono.just(question)
        every { userProgressRepository.save(any()) } returns Mono.just(userProgress)

        // when
        val result = questionService.submitAnswer(userId, request)

        // then
        StepVerifier.create(result)
            .expectNextMatches { !it.isCorrect && it.correctAnswer == correctAnswer }
            .verifyComplete()

        verify { questionRepository.findById(questionId) }
        verify { userProgressRepository.save(any()) }
    }

    private fun createSampleQuestion(
        id: Long,
        category: String,
        questionText: String,
        questionType: QuestionType
    ): Question {
        return Question(
            id = id,
            category = category,
            questionText = questionText,
            questionType = questionType,
            options = null,
            correctAnswer = "O",
            explanation = "테스트 해설",
            difficulty = Difficulty.EASY,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
}
