package br.com.til.msperson.adapters.repository.mongo.documents

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document("person")
class Person (
        var id: String? = null,
        var cpf: String,
        var name: String,
        var salary: BigDecimal
        )