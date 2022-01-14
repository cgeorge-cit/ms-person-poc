package br.com.til.msperson.application.core.ports

import br.com.til.msperson.application.core.dtos.SalaryDTO

interface PersonRepositoryPort {

    fun increaseSalary(salaryDTO: SalaryDTO)
}