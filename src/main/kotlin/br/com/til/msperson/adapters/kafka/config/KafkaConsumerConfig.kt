package br.com.til.msperson.adapters.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

class KafkaConsumerConfig {

    fun consumerFactory() : ConsumerFactory<String, String> {
        val props = mapOf(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "172.22.145.50:29092",
                ConsumerConfig.GROUP_ID_CONFIG to "personGroupId",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java
        )
        return DefaultKafkaConsumerFactory(props)
    }

    fun concurrentKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()

        factory.consumerFactory = consumerFactory()

        return factory
    }
}