package com.example.defendersapi.domain.defender

import org.springframework.stereotype.Repository

@Repository
interface DefenderRepository {
     fun getById(id: Long): Defender?
     fun getAll(): List<Defender>
     fun create(defender: Defender): Defender
     fun delete(id: Long)
     fun update(defender: Defender): Defender
}