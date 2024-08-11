package com.example.demo.service

import com.example.demo.datasource.mock.MockBankDataSource
import com.example.demo.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(
    val mockBankDataSource : MockBankDataSource
) {

    fun getBanks() : Collection<Bank> = mockBankDataSource.getBanks();

    fun getBank(accno:String): Bank? = mockBankDataSource.getBank(accno)


}