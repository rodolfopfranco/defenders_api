package com.example.defendersapi.application.web.resource

import com.example.defendersapi.application.web.resource.request.DefenderRequest
import com.example.defendersapi.application.web.resource.response.DefenderResponse
import com.example.defendersapi.domain.defender.DefenderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

private const val API_PATH = "/v1/api/defenders"

@RestController
@RequestMapping(value = [API_PATH])
class DefenderResource(
    @Autowired private val defenderRepository: DefenderRepository
){

    @GetMapping
    fun getDefenders(): ResponseEntity<List<DefenderResponse>> =
        defenderRepository.getAll()
            .map{ DefenderResponse.from(it) }
            .let{ ResponseEntity.ok().body(it) }

    @GetMapping("{id}/details")
    fun getDefenderById(@PathVariable id: Long) =
        defenderRepository.getById(id)
            ?.let {
                ResponseEntity.ok().body(DefenderResponse.from(it))
            }

    @PostMapping
    fun createDefender(@Valid @RequestBody request: DefenderRequest) =
        request.toDefender().run {
            defenderRepository.create(this)
        } .let {
            ResponseEntity
                .created(URI("$API_PATH/${it.id}"))
                .body(DefenderResponse.from(it))
        }

    @PutMapping("{id}")
    fun updateDefender(@Valid @RequestBody request: DefenderRequest, @PathVariable id: Long) =
        defenderRepository.getById(id)
            ?.let {
                DefenderRequest.to(it.id, request).apply {
                    defenderRepository.update(this)
                }.let { updatedDefender ->
                    ResponseEntity.ok().body(DefenderResponse.from(updatedDefender))
                }
            } ?: ResponseEntity.notFound().build<Void>()

    @DeleteMapping("{id}")
    fun deleteDefender(@PathVariable("id") id: Long) =
        defenderRepository.delete(id).let {
            ResponseEntity.accepted().build<Void>()
        }
}