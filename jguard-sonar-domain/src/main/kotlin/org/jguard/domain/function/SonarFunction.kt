package org.jguard.domain.function

import org.jguard.domain.model.SonarRequest
import org.jguard.domain.model.issues.SonarIssuesResponse
import org.jguard.domain.model.sonar.qube.response.SQTokenResponse

interface SonarFunction {

    fun retrieveIssues(sonarRequest: SonarRequest): SonarIssuesResponse

    fun isProjectFinished(sonarRequest: SonarRequest): Boolean

    fun generateToken(sonarRequest: SonarRequest): SQTokenResponse?

    fun createProject(sonarRequest: SonarRequest): Int

}
