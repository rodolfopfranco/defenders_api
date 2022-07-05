package com.example.defendersapi.domain.defender

data class Defender (
    val id: Long? = null,
    val name: String,
    val alias: String,
    val powers: String?,
    val backstory: String?
)