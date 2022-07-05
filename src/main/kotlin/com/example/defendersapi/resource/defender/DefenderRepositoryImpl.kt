package com.example.defendersapi.resource.defender

import com.example.defendersapi.domain.defender.Defender
import com.example.defendersapi.domain.defender.DefenderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class DefenderRepositoryImpl (
    @Autowired private val defenderEntityRepository: DefenderEntityRepository
    ) : DefenderRepository
{
    override fun getById(id: Long): Defender? =
        defenderEntityRepository.findByIdOrNull(id)?.toDefender()

    override fun getAll(): List<Defender> =
        defenderEntityRepository.findAll().map { it.toDefender() }


    override fun create(defender: Defender): Defender =
        defenderEntityRepository.save(DefenderEntity.from(defender)).toDefender()

    override fun delete(id: Long) = defenderEntityRepository.deleteById(id)

    override fun update(defender: Defender): Defender =
        defenderEntityRepository.save(DefenderEntity.from(defender)).toDefender()
}