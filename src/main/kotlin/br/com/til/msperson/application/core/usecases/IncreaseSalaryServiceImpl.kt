package br.com.til.msperson.application.core.usecases

import br.com.til.msperson.application.core.dtos.SalaryDTO
import br.com.til.msperson.application.core.ports.PersonRepositoryPort

class IncreaseSalaryServiceImpl(
        private val personRepositoryPort: PersonRepositoryPort
) : IncreaseSalaryService {

    override fun increaseSalary(salaryDTO: SalaryDTO) {
        personRepositoryPort.increaseSalary(salaryDTO)
    }
}