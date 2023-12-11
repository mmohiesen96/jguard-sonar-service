package org.jguard.domain.model.sonar.qube.data

import org.jguard.domain.model.sonar.qube.enums.Severity


data class Issue(
    private var key: String,

    val rule: String?,

    val severity: Severity,

    val component: String?,

    val line: Int,

    val hash: String?,

    val textRange: TextRange?,

    val flows: List<Any>?,

    val status: String?,

    val message: String?,

    val effort: String?,

    val debt: String?,

    val author: String?,

    val tags: List<String>?,

    val creationDate: String?,

    val updateDate: String?,

    val type: String?,

    val scope: String?,

    val quickFixAvailable: Boolean,

    val messageFormattings: List<Any>?,

    val codeVariants: List<Any>?,

    val cleanCodeAttribute: String?,

    val cleanCodeAttributeCategory: String?,

    val impacts: List<Impact>?,
)