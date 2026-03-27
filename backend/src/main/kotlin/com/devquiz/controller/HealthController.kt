package com.devquiz.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class HealthController {
    @GetMapping("/health")
    fun health(): Mono<Map<String, String>> {
        return Mono.just(mapOf("status" to "OK"))
    }
}
