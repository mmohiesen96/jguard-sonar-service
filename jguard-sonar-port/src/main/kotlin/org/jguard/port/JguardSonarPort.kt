package org.jguard.port

import org.jguard.client.SonarQubeClient
import org.jguard.client.SonarQubeClientRest
import org.jguard.processor.SonarProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class JguardSonarPort {

    @Bean
    fun sonarProcessor(): SonarProcessor {
        return SonarProcessor(sonarQubeClient())
    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun sonarQubeClient(): SonarQubeClient {
        return SonarQubeClientRest(restTemplate())
    }
}
