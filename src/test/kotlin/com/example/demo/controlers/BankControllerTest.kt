package com.example.demo.controlers

import com.example.demo.service.BankService
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get


@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest{
    @Autowired
    private lateinit var mockMvc: MockMvc




    @Test
    fun `healthcheck_endpoint should return hello world`() {
        mockMvc.get("/api/healthcheck").andExpect { status { isOk() } }
            .andExpect { content { string("Everything Looks Good") } }

    }

    @Test
    fun `banklist_endpoint should return collection of banks`(){
        mockMvc.get("/api/banklist")
            .andExpect {
                status { isOk() }
                jsonPath("$[0].accountNumber"){value("1")}
            }

    }

    @Test
    fun `bank_endpoint should return bank`(){
        mockMvc.get("/api/bank/1")
            .andExpect {
                status { isOk() }
                jsonPath("$.accountNumber"){value("1")}
            }

    }


}
