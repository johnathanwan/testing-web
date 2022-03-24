package com.example.testingweb

import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `should return default message`() {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk)
            .andExpect(content().string(containsString("Hello, World")))
    }
}