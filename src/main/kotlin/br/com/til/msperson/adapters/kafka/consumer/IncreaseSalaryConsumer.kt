package br.com.til.msperson.adapters.kafka.consumer

import br.com.til.msperson.adapters.repository.mongo.PersonRepositoryImpl
import br.com.til.msperson.application.core.dtos.SalaryDTO
import br.com.til.msperson.application.core.usecases.IncreaseSalaryServiceImpl
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class IncreaseSalaryConsumer(
        private val personRepositoryImpl: PersonRepositoryImpl
) {

    val increaseSalaryService = IncreaseSalaryServiceImpl(personRepositoryImpl)

    @KafkaListener(topics = ["payrollTopic"], groupId = "personGroupId")
    fun increaseSalary(record: ConsumerRecord<String, String>) {

        println("Salary Json: ${record.value()}")
        val salaryDTO: SalaryDTO = jacksonObjectMapper().readValue(record.value(), SalaryDTO::class.java)
        println("SalaryDTO: $salaryDTO")
        increaseSalaryService.increaseSalary(salaryDTO)
    }
}