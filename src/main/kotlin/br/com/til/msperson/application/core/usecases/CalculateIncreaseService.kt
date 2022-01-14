package br.com.til.msperson.application.core.usecases

import java.math.BigDecimal

interface CalculateIncreaseService {

    fun calculateIncrease(salary:String) : String
}