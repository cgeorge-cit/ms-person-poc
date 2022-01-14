package br.com.til.msperson.adapters.restapi

import br.com.til.msperson.adapters.feign.PayRollFeignService
import br.com.til.msperson.adapters.feign.PayRollFeignServiceImpl
import br.com.til.msperson.adapters.repository.mongo.PersonRepository
import br.com.til.msperson.adapters.repository.mongo.PersonRepositoryImpl
import br.com.til.msperson.adapters.repository.mongo.documents.Person
import br.com.til.msperson.adapters.restapi.dtos.PersonRequest
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity
import java.math.BigDecimal

class PersonControllerIT {

    val personRepository = mockk<PersonRepository>()

    private var personRepositoryImpl = PersonRepositoryImpl(personRepository)

    val payRollFeignService = mockk<PayRollFeignService>()

    private var payRollServiceImpl = PayRollFeignServiceImpl(payRollFeignService)

    private var personController:PersonController = PersonController(
            personRepositoryImpl,
            payRollServiceImpl
    )

    @Test
    fun `Calculate Increase`() {
        //given
        every { payRollFeignService.calculateIncrease("10000") } returns ResponseEntity.ok("11000")

        //when
        val newSalary: String = personController.calculateIncrease("10000").body.toString()

        //then
        verify { payRollFeignService.calculateIncrease("10000") }
        Assertions.assertThat(newSalary).isEqualTo("11000")
    }

    @Test
    fun `Save Person`() {
        //given
        every {
            personRepository.save(any())
        } returns mockk()

        //when
        personController.savePerson(PersonRequest(
                name = "Maria",
                cpf = "00011122233",
                salary = BigDecimal.TEN
        ))

        //then
        verify {
            personRepository.save(any())
        }
    }
}