package br.com.til.msperson.adapters.restapi.dtos

import java.math.BigDecimal

data class PersonRequest(
        val name: String,
        val cpf: String,
        val salary: BigDecimal
        )
