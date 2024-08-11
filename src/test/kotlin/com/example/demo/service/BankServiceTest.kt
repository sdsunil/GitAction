package com.example.demo.service

import com.example.demo.datasource.mock.MockBankDataSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import io.mockk.mockk
import io.mockk.verify

class BankServiceTest{

      val mockBankDataSource : MockBankDataSource =  mockk(relaxed = true)
      val bankService = BankService(mockBankDataSource)

    @Test
    fun `should call data source function`(){
        val banks = bankService.getBanks()
        val bank = bankService.getBank("1")

        verify(exactly = 1) {mockBankDataSource.getBanks() }
        verify(exactly = 1) {mockBankDataSource.getBank("1") }

       assertTrue(banks.isNotEmpty())
        assertTrue(bank != null)
    }
}