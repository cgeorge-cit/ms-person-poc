package br.com.til.msperson

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MsPersonApplication

fun main(args: Array<String>) {
	runApplication<MsPersonApplication>(*args)
}
