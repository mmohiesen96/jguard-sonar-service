package org.jguard.domain.model.sonar.qube.data

data class TextRange(
    val startLine: Int,
    val endLine: Int,
    val startOffset: Int,
    val endOffset: Int
)
