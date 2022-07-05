package com.example.defendersapi.application.web.resource.response

import com.example.defendersapi.domain.defender.Defender
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class DefenderResponse (
    val id: Long?= null,
    @NotBlank
    @NotEmpty
    val name: String,
    @NotBlank
    @NotEmpty
    val alias: String,
    val powers: String?= "",
    val backstory: String?= ""
) {
    companion object{
        fun from(defender: Defender) = DefenderResponse(
            id = defender.id,
            name = defender.name,
            alias = defender.alias,
            powers = defender.powers,
            backstory = defender.backstory
        )
    }
}