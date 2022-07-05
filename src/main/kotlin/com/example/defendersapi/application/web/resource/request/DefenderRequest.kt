package com.example.defendersapi.application.web.resource.request

import com.example.defendersapi.domain.defender.Defender
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class DefenderRequest(
    @NotBlank
    @NotEmpty
    val name: String,
    @NotBlank
    @NotEmpty
    val alias: String,
    val powers: String?= "",
    val backstory: String?= ""
) {
    fun toDefender() = Defender(
            name = name,
            alias = alias,
            powers = powers,
            backstory = backstory
        )

    companion object {
        fun to(id: Long?, request: DefenderRequest) = Defender(
            id = id,
            name = request.name,
            alias = request.alias,
            powers = request.powers,
            backstory = request.backstory
        )
    }
}