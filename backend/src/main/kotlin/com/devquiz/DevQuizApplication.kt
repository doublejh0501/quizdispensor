package com.devquiz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DevQuizApplication

fun main(args: Array<String>) {
    runApplication<DevQuizApplication>(*args)
}
