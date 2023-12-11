package org.jguard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JguardSonarStarter

fun main(vararg args: String) {
    runApplication<JguardSonarStarter>(*args)
}
