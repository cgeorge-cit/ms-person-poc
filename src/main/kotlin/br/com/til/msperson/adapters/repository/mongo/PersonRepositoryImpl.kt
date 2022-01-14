package br.com.til.msperson.adapters.repository.mongo

import br.com.til.msperson.adapters.repository.mongo.documents.Person
import br.com.til.msperson.application.core.dtos.SalaryDTO
import br.com.til.msperson.application.core.ports.PersonRepositoryPort
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class PersonRepositoryImpl(
        @Lazy private val personRepository: PersonRepository
) : PersonRepositoryPort {

    override fun increaseSalary(salaryDTO: SalaryDTO) {
        val personOptional = personRepository.findByCpf(salaryDTO.cpf)

        if (personOptional.isPresent) personOptional.get().apply {
            salary = salaryDTO.salary
        }. let {
            personRepository.save(it)
        }
    }

    fun save(name: String, cpf: String, salary: BigDecimal) {

        personRepository.save(
                Person(
                        cpf = cpf,
                        name = name,
                        salary = salary
                )
        )
    }
}