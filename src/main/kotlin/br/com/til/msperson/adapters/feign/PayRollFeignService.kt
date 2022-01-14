package br.com.til.msperson.adapters.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "ms-payroll", url = "http://localhost:8081", path = "/increase-salary")
interface PayRollFeignService {

    @GetMapping
    fun calculateIncrease(@RequestParam salary:String) : ResponseEntity<String>
}