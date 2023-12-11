package org.jguard.domain.model.issues

data class SonarIssuesResponse(
    val total: Long,
    val blocker: Long,
    val critical: Long,
    val major: Long,
    val minor: Long,
    val info: Long
)
