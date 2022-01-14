package br.com.til.msperson.adapters.repository.mongo

import br.com.til.msperson.adapters.repository.mongo.documents.Person
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository : MongoRepository<Person, String> {

    fun findByCpf(cpf: String) : Optional<Person>
}