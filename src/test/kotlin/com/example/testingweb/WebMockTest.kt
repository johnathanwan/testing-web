package com.example.testingweb

import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@WebMvcTest(GreetingController::class)
class WebMockTest(@Autowired val mockMvc: MockMvc) {

    @MockBean
    val service: GreetingService? = null

    @Test
    fun `greeting should return message from service`() {
        `when`(service!!.greet()).thenReturn("Hello, Mock")

        mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk)
            .andExpect(content().string(containsString("Hello, Mock")))
    }

}