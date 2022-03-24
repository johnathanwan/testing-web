package com.example.testingweb

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.*
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest(@Autowired val restTemplate: TestRestTemplate) {

    @LocalServerPort
    val port: Int? = null

    @Test
    fun `greeting should return default message`() {
        assertThat(restTemplate.getForObject("http://localhost:$port/", String::class.java))
            .contains("Hello, World")
    }

}