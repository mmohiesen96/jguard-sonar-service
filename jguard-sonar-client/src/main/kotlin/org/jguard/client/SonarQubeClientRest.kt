package org.jguard.client

import org.jguard.domain.model.SonarRequest
import org.jguard.domain.model.sonar.qube.response.SQIssuesResponse
import org.jguard.domain.model.sonar.qube.response.SQProjectsResponse
import org.jguard.domain.model.sonar.qube.response.SQTokenResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatusCode
import org.springframework.http.RequestEntity
import org.springframework.web.client.RestTemplate
import java.net.URI


class SonarQubeClientRest(private val restTemplate: RestTemplate) : SonarQubeClient {

    @Value("\${config.sonarQube.url}")
    lateinit var sonarQubeUrl: String;

    override fun generateToken(sonarRequest: SonarRequest): SQTokenResponse? {
        val headers = HttpHeaders()
        headers.set("Authorization", "Bearer ${sonarRequest.token}")
        val url = "${sonarQubeUrl}/api/user_tokens/generate?name=${sonarRequest.projectName}"
        val requestEntity = RequestEntity<Any>(headers, HttpMethod.POST, URI.create(url))
        return restTemplate.exchange(requestEntity, SQTokenResponse::class.java).body;
    }

    override fun createProject(sonarRequest: SonarRequest): HttpStatusCode {
        val headers = HttpHeaders()
        headers.set("Authorization", "Bearer ${sonarRequest.token}")
        val url =
            "${sonarQubeUrl}/api/projects/create?key=${sonarRequest.projectName}&name=${sonarRequest.projectName}&project=${sonarRequest.projectName}"
        val requestEntity = RequestEntity<Any>(headers, HttpMethod.POST, URI.create(url))
        return restTemplate.exchange(requestEntity, Void::class.java).statusCode;
    }

    override fun retrieveProjectResponse(sonarRequest: SonarRequest): SQProjectsResponse? {
        val headers = HttpHeaders()
        headers.set("Authorization", "Bearer ${sonarRequest.token}")
        val url = "${sonarQubeUrl}/api/projects/search?projects=${sonarRequest.projectName}"
        val requestEntity = RequestEntity<Any>(headers, HttpMethod.GET, URI.create(url))
        return restTemplate.exchange(requestEntity, SQProjectsResponse::class.java).body;
    }

    override fun retrieveIssueResponse(sonarRequest: SonarRequest): SQIssuesResponse? {
        val headers = HttpHeaders()
        headers.set("Authorization", "Bearer ${sonarRequest.token}")
        val url = "${sonarQubeUrl}/api/issues/search?componentKeys=${sonarRequest.projectName}"
        val requestEntity = RequestEntity<Any>(headers, HttpMethod.GET, URI.create(url))
        return restTemplate.exchange(requestEntity, SQIssuesResponse::class.java).body;
    }

}