package br.com.til.msperson.application.core.usecases

import br.com.til.msperson.application.core.dtos.SalaryDTO

interface IncreaseSalaryService {

    fun increaseSalary(salaryDTO: SalaryDTO)
}