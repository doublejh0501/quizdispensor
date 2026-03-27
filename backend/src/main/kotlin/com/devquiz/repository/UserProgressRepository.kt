package com.devquiz.repository

import com.devquiz.domain.UserProgress
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface UserProgressRepository : ReactiveCrudRepository<UserProgress, Long> {
    fun findByUserId(userId: Long): Flux<UserProgress>
    fun findByUserIdAndQuestionId(userId: Long, questionId: Long): Flux<UserProgress>
}
