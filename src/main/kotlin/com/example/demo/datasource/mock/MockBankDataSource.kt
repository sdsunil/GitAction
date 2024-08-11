package com.example.demo.datasource.mock

import com.example.demo.datasource.BankDataSource
import com.example.demo.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    val bankList : Collection<Bank> = listOf(
        Bank("1",1.1,20),
        Bank("2",1.2,30),
        Bank("3",1.3,40)
        )
    override fun getBanks(): Collection<Bank> = bankList
    override fun getBank(accountNumber: String): Bank? = bankList.firstOrNull{it.accountNumber == accountNumber}
}