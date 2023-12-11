package org.jguard.client

import org.jguard.domain.model.SonarRequest
import org.jguard.domain.model.sonar.qube.response.SQIssuesResponse
import org.jguard.domain.model.sonar.qube.response.SQProjectsResponse
import org.jguard.domain.model.sonar.qube.response.SQTokenResponse
import org.springframework.http.HttpStatusCode

interface SonarQubeClient {
    fun generateToken(sonarRequest: SonarRequest): SQTokenResponse?
    fun createProject(sonarRequest: SonarRequest): HttpStatusCode
    fun retrieveProjectResponse(sonarRequest: SonarRequest): SQProjectsResponse?
    fun retrieveIssueResponse(sonarRequest: SonarRequest): SQIssuesResponse?
}