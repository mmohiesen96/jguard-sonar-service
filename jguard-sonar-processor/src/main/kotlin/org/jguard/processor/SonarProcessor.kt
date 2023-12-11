package org.jguard.processor

import org.jguard.client.SonarQubeClient
import org.jguard.domain.function.SonarFunction
import org.jguard.domain.model.SonarRequest
import org.jguard.domain.model.issues.SonarIssuesResponse
import org.jguard.domain.model.sonar.qube.enums.Severity
import org.jguard.domain.model.sonar.qube.response.SQIssuesResponse
import org.jguard.domain.model.sonar.qube.response.SQTokenResponse


class SonarProcessor(private val sonarQubeClient: SonarQubeClient) : SonarFunction {

    override fun retrieveIssues(sonarRequest: SonarRequest): SonarIssuesResponse {
        sonarQubeClient.retrieveIssueResponse(sonarRequest).run {
            if (this != null) {
                return buildSonarIssueResponse(this)
            }
        }.run {
            return SonarIssuesResponse(0, 0, 0, 0, 0, 0)
        }
    }

    override fun isProjectFinished(sonarRequest: SonarRequest): Boolean {
        sonarQubeClient.retrieveProjectResponse(sonarRequest).run {
            if (this != null) {
                val projectComponent = components.first { it.key == sonarRequest.projectName }
                return !projectComponent.lastAnalysisDate.isNullOrEmpty()
            }
            return false
        }
    }


    override fun generateToken(sonarRequest: SonarRequest): SQTokenResponse? {
        return sonarQubeClient.generateToken(sonarRequest)
    }

    override fun createProject(sonarRequest: SonarRequest): Int {
        return sonarQubeClient.createProject(sonarRequest).value()
    }

    private fun buildSonarIssueResponse(sqIssuesResponse: SQIssuesResponse): SonarIssuesResponse {
        return SonarIssuesResponse(
            sqIssuesResponse.total,
            sqIssuesResponse.issues.groupingBy { it.severity }.eachCount()[Severity.BLOCKER]?.toLong() ?: 0L,
            sqIssuesResponse.issues.groupingBy { it.severity }.eachCount()[Severity.CRITICAL]?.toLong() ?: 0L,
            sqIssuesResponse.issues.groupingBy { it.severity }.eachCount()[Severity.MAJOR]?.toLong() ?: 0L,
            sqIssuesResponse.issues.groupingBy { it.severity }.eachCount()[Severity.MINOR]?.toLong() ?: 0L,
            sqIssuesResponse.issues.groupingBy { it.severity }.eachCount()[Severity.INFO]?.toLong() ?: 0L
        )
    }
}