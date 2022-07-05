package com.example.defendersapi.resource.defender

import com.example.defendersapi.domain.defender.Defender
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class DefenderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val alias: String,
    val powers: String?,
    val backstory: String?
) {
    fun toDefender() = Defender(
        id = id,
        name = name,
        alias = alias,
        powers = powers,
        backstory = backstory,
    )

    companion object {
        fun from(defender: Defender) = DefenderEntity(
            id = defender.id,
            name = defender.name,
            alias = defender.alias,
            powers = defender.powers,
            backstory = defender.backstory,
        )
    }
}