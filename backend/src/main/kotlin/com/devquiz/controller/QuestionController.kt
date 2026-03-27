package com.devquiz.controller

import com.devquiz.dto.*
import com.devquiz.service.QuestionService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = ["http://localhost:3000"])
class QuestionController(
    private val questionService: QuestionService
) {
    @GetMapping
    fun getAllQuestions(): Flux<QuestionResponse> {
        return questionService.getAllQuestions()
    }

    @GetMapping("/category/{category}")
    fun getQuestionsByCategory(@PathVariable category: String): Flux<QuestionResponse> {
        return questionService.getQuestionsByCategory(category)
    }

    @GetMapping("/{id}")
    fun getQuestionById(@PathVariable id: Long): Mono<QuestionResponse> {
        return questionService.getQuestionById(id)
    }

    @PostMapping
    fun createQuestion(@RequestBody request: CreateQuestionRequest): Mono<QuestionResponse> {
        return questionService.createQuestion(request)
    }

    @PostMapping("/submit")
    fun submitAnswer(
        @RequestHeader("X-User-Id") userId: Long,
        @RequestBody request: SubmitAnswerRequest
    ): Mono<SubmitAnswerResponse> {
        return questionService.submitAnswer(userId, request)
    }
}
