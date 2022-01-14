package br.com.til.msperson.adapters.restapi

import br.com.til.msperson.adapters.feign.PayRollFeignServiceImpl
import br.com.til.msperson.adapters.repository.mongo.PersonRepositoryImpl
import br.com.til.msperson.adapters.restapi.dtos.PersonRequest
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class PersonControllerTest {

    private var personRepositoryImpl = mockk<PersonRepositoryImpl>(relaxed = true)

    private var payRollServiceImpl = mockk<PayRollFeignServiceImpl>()

    private var personController:PersonController = PersonController(
            personRepositoryImpl,
            payRollServiceImpl
    )

    @Test
    fun testCalculateIncrease() {
        //given
        every { payRollServiceImpl.calculateIncrease("10000") } returns "11000"

        //when
        val newSalary: String = personController.calculateIncrease("10000").body.toString()

        //then
        verify { payRollServiceImpl.calculateIncrease("10000") }
        Assertions.assertThat(newSalary).isEqualTo("11000")
    }

    @Test
    fun testSavePerson() {
        //given
        justRun {
            personRepositoryImpl.save(
                    name = any(),
                    cpf = any(),
                    salary = any()
            ) }

        //when
        personController.savePerson(PersonRequest(
                name = "Maria",
                cpf = "00011122233",
                salary = BigDecimal.TEN
        ))

        //then
        verify {
            personRepositoryImpl.save(
                    any(),
                    any(),
                    any()
            )
        }
    }
}