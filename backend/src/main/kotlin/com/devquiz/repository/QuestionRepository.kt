package com.devquiz.repository

import com.devquiz.domain.Question
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface QuestionRepository : ReactiveCrudRepository<Question, Long> {
    fun findByCategory(category: String): Flux<Question>
}
