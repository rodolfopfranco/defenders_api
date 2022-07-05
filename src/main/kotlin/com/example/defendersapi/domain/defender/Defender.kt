package com.example.defendersapi.domain.defender

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Defender (
    @Id
    val id: Long? = null,
    val name: String,
    val alias: String,
    val powers: String?,
    val backstory: String?
)