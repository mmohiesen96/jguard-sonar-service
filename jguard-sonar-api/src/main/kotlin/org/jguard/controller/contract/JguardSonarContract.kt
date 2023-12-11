package org.jguard.controller.contract

import org.jguard.domain.model.SonarRequest
import org.jguard.domain.model.issues.SonarIssuesResponse
import org.jguard.domain.model.sonar.qube.response.SQTokenResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/v1/jguard")
interface JguardSonarContract {

    @GetMapping("issues")
    fun retrieveIssues(
        @RequestBody sonarRequest: SonarRequest,
    ): ResponseEntity<SonarIssuesResponse>

    @GetMapping("project")
    fun isProjectFinished(
        @RequestBody sonarRequest: SonarRequest,
    ): ResponseEntity<Boolean>

    @PostMapping("project")
    fun createProject(
        @RequestBody sonarRequest: SonarRequest,
    ): ResponseEntity<Boolean>

    @PostMapping("token")
    fun generateToken(
        @RequestBody sonarRequest: SonarRequest,
    ): ResponseEntity<SQTokenResponse>

}