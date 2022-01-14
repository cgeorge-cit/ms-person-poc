package br.com.til.msperson.application.core.usecases

import br.com.til.msperson.application.core.ports.CalculateIncreasePort
import java.math.BigDecimal

class CalculateIncreaseServiceImpl(
        val calculateIncreasePort: CalculateIncreasePort
) : CalculateIncreaseService {
    override fun calculateIncrease(salary: String): String {
        return calculateIncreasePort.calculateIncrease(salary)
    }
}