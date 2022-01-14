package br.com.til.msperson.adapters.restapi

import br.com.til.msperson.adapters.feign.PayRollFeignServiceImpl
import br.com.til.msperson.adapters.repository.mongo.PersonRepositoryImpl
import br.com.til.msperson.adapters.restapi.dtos.PersonRequest
import br.com.til.msperson.application.core.usecases.CalculateIncreaseServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController (
        private val personRepositoryImpl: PersonRepositoryImpl,
        private val payRollServiceImpl: PayRollFeignServiceImpl
    ) {

    val calculateIncreaseService = CalculateIncreaseServiceImpl(payRollServiceImpl)

    @PostMapping
    fun savePerson(@RequestBody person: PersonRequest) {

        personRepositoryImpl.save(person.name, person.cpf, person.salary)
    }

    @GetMapping
    fun calculateIncrease(@RequestParam salary:String) : ResponseEntity<String> {
        return ResponseEntity.ok(calculateIncreaseService.calculateIncrease(salary))
    }
}