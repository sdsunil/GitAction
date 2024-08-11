package com.example.demo.datasource.mock

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MockBankDataSourceTest{

    val mockBankDataSource = MockBankDataSource()
    @Test
    fun `should return list of banks`(){

        val banks = mockBankDataSource.getBanks()

        assertTrue(banks.isNotEmpty())
        assertTrue(banks.all { it.accountNumber.isNotEmpty() })
        assertTrue(banks.any { it.trust != 0.0 })

    }

    @Test
    fun `should return bank with matched accno`(){

        val bank = mockBankDataSource.getBank("1")
        assertNotNull(bank)
        assertEquals(bank?.accountNumber, "1")

    }
}