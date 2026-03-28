package com.devquiz.controller

import com.devquiz.domain.Difficulty
import com.devquiz.domain.QuestionType
import com.devquiz.dto.QuestionResponse
import com.devquiz.dto.SubmitAnswerRequest
import com.devquiz.dto.SubmitAnswerResponse
import com.devquiz.service.QuestionService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@WebFluxTest(QuestionController::class)
@Import(com.devquiz.config.SecurityConfig::class)
class QuestionControllerTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @MockkBean
    private lateinit var questionService: QuestionService

    @Test
    @WithMockUser
    fun `GET all questions should return 200 with questions`() {
        // given
        val questions = listOf(
            QuestionResponse(
                id = 1L,
                category = "자료구조",
                questionText = "스택은 LIFO이다?",
                questionType = QuestionType.OX,
                options = null,
                difficulty = Difficulty.EASY,
                correctAnswer = "O",
                explanation = "스택은 Last In First Out 구조입니다."
            ),
            QuestionResponse(
                id = 2L,
                category = "네트워크",
                questionText = "TCP는 연결지향이다?",
                questionType = QuestionType.OX,
                options = null,
                difficulty = Difficulty.EASY,
                correctAnswer = "O",
                explanation = "TCP는 연결 지향 프로토콜입니다."
            )
        )
        every { questionService.getAllQuestions() } returns Flux.fromIterable(questions)

        // when & then
        webTestClient.get()
            .uri("/api/questions")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(QuestionResponse::class.java)
            .hasSize(2)
    }

    @Test
    @WithMockUser
    fun `GET questions by category should return filtered questions`() {
        // given
        val category = "자료구조"
        val questions = listOf(
            QuestionResponse(
                id = 1L,
                category = category,
                questionText = "스택은 LIFO이다?",
                questionType = QuestionType.OX,
                options = null,
                difficulty = Difficulty.EASY,
                correctAnswer = "O",
                explanation = "스택은 Last In First Out 구조입니다."
            )
        )
        every { questionService.getQuestionsByCategory(category) } returns Flux.fromIterable(questions)

        // when & then
        webTestClient.get()
            .uri("/api/questions/category/{category}", category)
            .exchange()
            .expectStatus().isOk
            .expectBodyList(QuestionResponse::class.java)
            .hasSize(1)
    }

    @Test
    @WithMockUser
    fun `GET question by id should return question`() {
        // given
        val questionId = 1L
        val question = QuestionResponse(
            id = questionId,
            category = "자료구조",
            questionText = "스택은 LIFO이다?",
            questionType = QuestionType.OX,
            options = null,
            difficulty = Difficulty.EASY,
            correctAnswer = "O",
            explanation = "스택은 Last In First Out 구조입니다."
        )
        every { questionService.getQuestionById(questionId) } returns Mono.just(question)

        // when & then
        webTestClient.get()
            .uri("/api/questions/{id}", questionId)
            .exchange()
            .expectStatus().isOk
            .expectBody(QuestionResponse::class.java)
            .isEqualTo(question)
    }

    @Test
    @WithMockUser
    fun `POST submit answer should return result`() {
        // given
        val userId = 1L
        val request = SubmitAnswerRequest(questionId = 1L, answer = "O")
        val response = SubmitAnswerResponse(
            isCorrect = true,
            correctAnswer = "O",
            explanation = "정답입니다!"
        )
        every { questionService.submitAnswer(userId, request) } returns Mono.just(response)

        // when & then
        webTestClient.mutateWith(csrf())
            .post()
            .uri("/api/questions/submit")
            .header("X-User-Id", userId.toString())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .exchange()
            .expectStatus().isOk
            .expectBody(SubmitAnswerResponse::class.java)
            .isEqualTo(response)
    }
}
