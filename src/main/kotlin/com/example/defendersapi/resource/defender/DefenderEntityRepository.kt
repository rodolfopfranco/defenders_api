package com.example.defendersapi.resource.defender

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DefenderEntityRepository : JpaRepository<DefenderEntity, Long>{
}