package org.jguard.domain.model.sonar.qube.data

data class Component(
    val key: String,
    val name: String,
    val qualifier: String?,
    val visibility: String?,
    val lastAnalysisDate: String?,
    val revision: String?,
    val managed: Boolean?
)
