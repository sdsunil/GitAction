package com.example.demo.controlers

import com.example.demo.model.Bank
import com.example.demo.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.NoSuchElementException


@RestController
@RequestMapping("/api")
class BankController(private val bankService: BankService){


    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e:NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message,HttpStatus.NOT_FOUND)


    @GetMapping("/healthcheck")
    fun healthCheck(): String {
        return "Everything Looks Good"
    }

    @GetMapping("/banklist")
    fun getBanks(): Collection<Bank>{
        return  bankService.getBanks()
    }

    @GetMapping("/bank/{accoNo}")
    fun getBank(@PathVariable accoNo: String): Bank? = bankService.getBank(accoNo)
}
