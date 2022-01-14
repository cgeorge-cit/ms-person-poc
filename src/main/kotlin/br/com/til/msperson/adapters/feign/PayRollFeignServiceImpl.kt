package br.com.til.msperson.adapters.feign

import br.com.til.msperson.application.core.ports.CalculateIncreasePort
import org.springframework.stereotype.Service

@Service
class PayRollFeignServiceImpl(
        private val payRollFeignService: PayRollFeignService
) : CalculateIncreasePort {
    override fun calculateIncrease(salary: String): String {
        return payRollFeignService.calculateIncrease(salary).body.toString()
    }
}