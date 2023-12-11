package org.jguard.domain.model.sonar.qube.response

import org.jguard.domain.model.sonar.qube.data.Component
import org.jguard.domain.model.sonar.qube.data.Issue
import org.jguard.domain.model.sonar.qube.data.Paging

data class SQIssuesResponse(
    val total: Long,
    val p: Int,
    val ps: Int,
    val paging: Paging,
    val effortTotal: Int,
    val issues: List<Issue>,
    val components: List<Component>,
    val facets: List<Any>
)
